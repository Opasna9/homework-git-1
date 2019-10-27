package conspect.oop.threads.deadlock;

import javax.naming.InsufficientResourcesException;

public class Operations {
    public static void main(String[] args) {
        final Account a = new Account(1,"a", 1000);
        final Account b = new Account(2,"b",2000);

        System.out.println("a = " + a.getBalance());
        System.out.println("b = " + b.getBalance());

        try {
            //  в отдельном потоке запускаем
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //AccountUtils.transfer(a, b, 500); // with deadLock
                        //AccountUtils.transferWithoutDeadLock(a, b, 500); // without deadLock Используем иерархию по ID
                        AccountUtils.transferReentrantLock(a, b, 500); // without deadLock Используем java.util.concurrent.locks.ReentrantLock
                        System.out.println("a = " + a.getBalance());
                        System.out.println("b = " + b.getBalance());
                    } catch (InsufficientResourcesException | InterruptedException e) {
                        e.printStackTrace();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
                    }
                }
            });
             thread1.start();

            //AccountUtils.transfer(b, a, 300);
            //AccountUtils.transferWithoutDeadLock(b, a, 300);
            AccountUtils.transferReentrantLock(b, a, 300);

            thread1.join(); // - останавливает поток main до завершения потока thread1

            System.out.println("a = " + a.getBalance());
            System.out.println("b = " + b.getBalance());


        } catch (InsufficientResourcesException | InterruptedException e) {
            e.printStackTrace();
        }


    }
}
