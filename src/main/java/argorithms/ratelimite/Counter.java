package argorithms.ratelimite;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/5/25 - 22:30
 * @description: 计数器的方式实现限流
 */
public class Counter {

    //当前线程阻塞的纳秒时长，单位纳秒
    private static final long PARK_NANOS = 1L;

    //最后一次更新的时间时钟纳秒
    private volatile long lastNanos = System.nanoTime();

    //当前访问的次数
    private AtomicInteger count = new AtomicInteger(0);

    //每秒中最大的次数 100 QPS
    private int maxRate = 100;

    //时间间隔，单位纳秒
    private int intervalNanos = 1_000_0000;

    private static final Unsafe THE_UNSAFE;
    private static final long LAST_NANOS_OFFSET;

    static {
        try {
            final PrivilegedExceptionAction<Unsafe> action = new PrivilegedExceptionAction<Unsafe>() {
                @Override
                public Unsafe run() throws Exception {
                    Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                    theUnsafe.setAccessible(true);
                    return (Unsafe) theUnsafe.get(null);
                }
            };
            THE_UNSAFE = AccessController.doPrivileged(action);
            LAST_NANOS_OFFSET = THE_UNSAFE.objectFieldOffset(Counter.class.getDeclaredField("lastNanos"));

        } catch (Exception e) {
            throw new RuntimeException("Unable to load unsafe", e);
        }
    }

    /**
     * 非阻塞申请
     *
     * @param n
     */
    public boolean tryAcquire(int n) {
        long currNanos = System.nanoTime();

        //计数器失效
        if (currNanos - lastNanos > intervalNanos) {
            //重置计数器并且将当前申请的加入
            count.set(0);
        }
        if (lastNanos < intervalNanos) {
            lastNanos = intervalNanos;
        }
        return count.addAndGet(n) <= maxRate;
    }

    public boolean compareAndSetLastNanos(long expect, long newValue) {
        return THE_UNSAFE.compareAndSwapLong(this, LAST_NANOS_OFFSET, expect, newValue);
    }

    public boolean tryAcquire() {
        return tryAcquire(1);
    }

    /**
     * 阻塞申请
     *
     * @param n
     */
    public void acquire(int n) {
        long currNanos = System.nanoTime();

        //计数器失效
        if (isExpire(currNanos)) {
            //重置计数器并且将当前申请的加入
            count.set(0);
        }
        int currCount;
        do {
            currCount = count.get() + n;
            if (currCount > maxRate) {
                LockSupport.parkNanos(PARK_NANOS);
            }
        } while (currCount > maxRate);
        if (lastNanos < currCount) {
            lastNanos = currNanos;
        }
    }

    private boolean isExpire(long currNanos) {
        return currNanos - lastNanos > intervalNanos;
    }

    public void acquire() {
        acquire(1);
    }
}
