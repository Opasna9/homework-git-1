package conspect.oop.threads.waitnotify;

public class WaitNotifyTest {
    public static void main(String[] args) {
        Message msg = new Message("обработать");

        new Thread(new Waiter(msg),"waiter").start();
        new Thread(new Waiter(msg), "waiter1").start();
        new Thread(new Notifier(msg), "notifier").start();

        System.out.println("Стартовали все потоки");
    }
}
