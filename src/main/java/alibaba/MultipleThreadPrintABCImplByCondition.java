package alibaba;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/5/16 - 18:14
 * @description: 使用3个线程，分别控制打印A、B、C，输出效果为ABCABCABC...，循环50次
 */
public class MultipleThreadPrintABCImplByCondition {

    static int state = 0;

    public static void main(String[] args) throws InterruptedException {

        Print print = new Print();
        Thread ta = new Thread(print::printA);
        Thread tb = new Thread(print::printB);
        Thread tc = new Thread(print::printC);
        ta.start();
        tb.start();
        tc.start();
    }

    static class Print {
        private ReentrantLock lock = new ReentrantLock();
        private Condition ctrA = lock.newCondition();
        private Condition ctrB = lock.newCondition();
        private Condition ctrC = lock.newCondition();
        private int state = 0;

        public void printA() {
            lock.lock();
            try {
                for (int i = 0; i < 50; i++) {
                    while (state % 3 != 0)
                        ctrA.await();
                    System.out.print("A");
                    state++;
                    ctrB.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }


        public void printB() {
            lock.lock();
            try {
                for (int i = 0; i < 50; i++) {
                    while (state % 3 != 1)
                        ctrB.await();
                    System.out.print("B");
                    state++;
                    ctrC.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

        public void printC() {
            lock.lock();
            try {
                for (int i = 0; i < 50; i++) {
                    while (state % 3 != 2)
                        ctrC.await();
                    System.out.print("C");
                    state++;
                    ctrA.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

}

