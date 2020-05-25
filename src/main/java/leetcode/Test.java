package leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/5/16 - 09:48
 * @description:
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();
        Thread ta = new Thread(new Print(c1, c2, lock, "A"));
        Thread tb = new Thread(new Print(c2, c3, lock, "B"));
        Thread tc = new Thread(new Print(c3, c1, lock, "C"));
        ta.start();
        ta.join();
        tb.start();
        tb.join();
        tc.start();
        tc.join();

    }

    static class Print implements Runnable {

        private AtomicInteger count = new AtomicInteger(0);
        private Condition curr;
        private Condition next;
        private ReentrantLock lock;
        private String tag;

        public Print(Condition curr, Condition next, ReentrantLock lock, String tag) {
            this.curr = curr;
            this.next = next;
            this.tag = tag;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (count.incrementAndGet() <= 50) {
                try {

                    lock.lock();
                    curr.await();
                    System.out.print(tag);
                    next.signal();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private AtomicInteger count = new AtomicInteger();

    public boolean verify(int n){
        return count.incrementAndGet() <= n;
    }



}
