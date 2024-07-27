package advanced1.thread2;

import static advanced1.thread2.MyLogger.log;

public class InnerRunnableMainV2 {

    public static void main(String[] args) {
        log("main() start");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        };


        Thread thread = new Thread(runnable);

        thread.start();

        log("main() end");
    }
}
