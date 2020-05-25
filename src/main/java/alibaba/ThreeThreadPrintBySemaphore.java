package alibaba;

import java.util.concurrent.Semaphore;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/5/16 - 20:09
 * @description:
 */
public class ThreeThreadPrintBySemaphore {

    public static void main(String[] args) {

        Print print = new Print();
        Thread ta = new Thread(print::printA);
        Thread tb = new Thread(print::printB);
        Thread tc = new Thread(print::printC);
        ta.start();
        tb.start();
        tc.start();
    }

    static class Print {

        Semaphore permitsOfA = new Semaphore(1);
        Semaphore permitsOfB = new Semaphore(0);
        Semaphore permitsOfC = new Semaphore(0);

        public void printA() {
            for (int i = 0; i < 50; i++) {
                try {
                    permitsOfA.acquire();
                    System.out.print("A");
                    permitsOfB.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void printB() {
            for (int i = 0; i < 50; i++) {
                try {
                    permitsOfB.acquire();
                    System.out.print("B");
                    permitsOfC.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void printC() {
            for (int i = 0; i < 50; i++) {
                try {
                    permitsOfC.acquire();
                    System.out.print("C");
                    permitsOfA.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
