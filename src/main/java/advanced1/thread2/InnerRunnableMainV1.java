package advanced1.thread2;

import static advanced1.thread2.MyLogger.log;

public class InnerRunnableMainV1 {

    public static void main(String[] args) {
        log("main() start");

        Runnable runnable = new MyRunnable();

        Thread thread = new Thread(runnable);
        thread.start();

        log("main() end");
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            log("run()");
        }
    }
}
