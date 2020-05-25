package argorithms.ratelimite;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/5/25 - 17:01
 * @description: 漏桶算法
 *
 * <pre>
 *  漏桶(Leaky Bucket)算法思路很简单,水(请求)先进入到漏桶里,漏桶以一定的速度出水(接口有响应速率),
 *  当水流入速度过大会直接溢出(访问频率超过接口响应速率),然后就拒绝请求,可以看出漏桶算法能强行限制数据的传输速率.示意图如下:
 *  http://xiaobaoqiu.github.io/images/guava/rate-limit1.png
 * </pre>
 */
public class LeakyBucket {

    private static final long PARK_NANOS = 1L;

    /**
     * 桶的漏洞的表示水流速度，表示请求的速度。request per seconds
     */
    private int rate = 1000;

    /**
     * 桶的最大容量
     */
    private int capacity = 2000;

    /**
     * 当前的大小
     */
    private AtomicInteger size = new AtomicInteger(0);

    /**
     * 最后一次加水的时间：纳秒，采用cpu时钟，避免系统时间同步导致时间偏移。
     */
    private volatile long lastAddedNanos = System.nanoTime();


    /**
     * 非阻塞漏桶算法
     */
    public boolean tryAcquire(int n) {

        long currentNanos = System.nanoTime();
        int current;
        int nextSize;
        current = size.addAndGet(n);
        nextSize = (int) Math.max(0, (current - (currentNanos - lastAddedNanos) * rate / Math.pow(10, 6)));
        if (nextSize > capacity) {
            return false;
        }
        if (currentNanos > lastAddedNanos) {
            lastAddedNanos = currentNanos;
        }
        return true;
    }

    /**
     * 非阻塞漏桶算法
     */
    public boolean tryAcquire() {
        return tryAcquire(1);
    }

    /**
     * 阻塞漏桶算法
     */
    public void Acquire(int n) {

        long currentNanos = System.nanoTime();
        int current;
        int nextSize;
        do {
            current = size.get();
            nextSize = (int) Math.max(0, (current - (currentNanos - lastAddedNanos) * rate / Math.pow(10, 6))) + n;
            if (nextSize > capacity) {
                LockSupport.parkNanos(PARK_NANOS);
            }
        } while (nextSize > capacity);
        size.addAndGet(n);
        if (currentNanos > lastAddedNanos) {
            lastAddedNanos = currentNanos;
        }
    }


}
