package argorithms.ratelimite;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/5/25 - 23:09
 * @description: 限流令牌桶算法
 */
public class TokenBucket {

    private final static long PARK_NANOS = 1L;

    //桶的容量
    private int capacity = 100;

    //当前的数量
    private AtomicInteger size = new AtomicInteger(0);

    //令牌添加的速度，个/秒
    private int rate = 1000;

    //最后访问时间
    private long lastAccessNanos = System.nanoTime();

    /**
     * 非阻塞的申请令牌
     *
     * @param n 申请的令牌数量
     * @return 当桶中的令牌数量大于等于n返回true，否则返回false。
     */
    public boolean tryAcquire(int n) {
        long nanos = System.nanoTime();
        int currSize = (int) Math.min(capacity, size.get() + (nanos - lastAccessNanos) * rate / Math.pow(10, 6));
        if (currSize >= n) {
            //还有可用的令牌，可以访问
            size.addAndGet(-n);
            lastAccessNanos = nanos;
            return true;
        }
        return false;
    }

    /**
     * 非阻塞的申请一个令牌
     */
    public boolean tryAcquire() {
        return tryAcquire(1);
    }

    /**
     * 阻塞式申请n个令牌
     */
    public void acquire(int n) {
        long currNanos;
        int currSize;
        do {
            currNanos = System.nanoTime();
            currSize = (int) Math.min(capacity, size.get() + (currNanos - lastAccessNanos) * rate / Math.pow(10, 6));
            if (currSize < n) {
                LockSupport.parkNanos(PARK_NANOS);
            } else {
                break;
            }
        } while (true);
        //还有可用的令牌，可以访问
        size.addAndGet(-n);
        lastAccessNanos = currNanos;
    }


    /**
     * 阻塞式申请1个令牌
     */
    public void acquire() {
        acquire(1);
    }


}
