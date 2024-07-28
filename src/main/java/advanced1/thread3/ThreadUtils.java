package advanced1.thread3;

import static advanced1.thread2.MyLogger.log;

public class ThreadUtils {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log("인터럽트 발생, " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
