package conspect.oop.threads.thread;

public class Demo {
    public static void main(String[] args) {

        // with extends Thread
        Thread1 t1 = new Thread1();

        // чаще всего, тк у  нас 2 объекта и Thread2 может наследоваться от чего угодно
        // with implements Runnable()
        Thread t2 = new Thread(new Thread2());

        // для мелких задач
        // with anonymous class
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Привеn из t3...");
                // Код потока t3
            }
        });

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Главный поток завершён...");


    }
}
