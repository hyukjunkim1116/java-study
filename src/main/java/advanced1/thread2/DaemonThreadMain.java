package advanced1.thread2;

public class DaemonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");
        DeamonThread deamonThread = new DeamonThread();
        deamonThread.setDaemon(true);
        deamonThread.start();
        System.out.println(Thread.currentThread().getName()+": main() end");
    }

    static class DeamonThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run() start");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": run()");
        }
    }
}
