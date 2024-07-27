package advanced1.thread2;

import static advanced1.thread2.MyLogger.log;
import static java.lang.Thread.sleep;

public class StartTest4Main {

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            while (true) {
                log("A");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Thread-A");
        Thread threadB = new Thread(() -> {
            while (true) {
                log("B");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Thread-B");
        threadA.start();
        threadB.start();
    }
}
