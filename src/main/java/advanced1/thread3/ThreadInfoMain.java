package advanced1.thread3;

import advanced1.thread2.HelloThread;

import static advanced1.thread2.MyLogger.log;

public class ThreadInfoMain {

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        log("mainThread = "+ mainThread);
        log(mainThread.threadId());
        log(mainThread.getName());
        log(mainThread.getPriority());
        log(mainThread.getThreadGroup());
        log(mainThread.getState());

        Thread myThread = new Thread(new HelloThread(), "myThread");
        log("myThread = " + myThread);
        log("myThread.threadId() = " + myThread.threadId());
        log("myThread.getName() = " + myThread.getName());
        log("myThread.getPriority() = " + myThread.getPriority());
        log("myThread.getThreadGroup() = " + myThread.getThreadGroup());
        log("myThread.getState() = " + myThread.getState());


    }
}
