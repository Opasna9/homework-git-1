package conspect.oop.threads.deadlock;

import javax.naming.InsufficientResourcesException;
import java.util.concurrent.TimeUnit;

public class AccountUtils {

    private static Object monitor = new Object();

    public static final long WAIT_SEC = 1;

    private AccountUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void doTransfer(final Account fromAcc, final Account toAcc, final int amount) throws InsufficientResourcesException {
        if (fromAcc.getBalance() < amount) {
            throw new InsufficientResourcesException();
        } else {
            fromAcc.withdraw(amount);
            toAcc.deposit(amount);
        }
    }

    public static void transfer(Account acc1, Account acc2, int amount) throws InsufficientResourcesException, InterruptedException {
        // deadlock
        System.out.println("start transfer " + acc1.getName() + " -> " + acc2.getName() + " " + amount);

        synchronized (acc1) {
            System.out.println("lock object acc1 = " + acc1.getName());
            Thread.sleep(1000); // гарантируем deadlock
            synchronized (acc2) {
                System.out.println("lock object acc2 = " + acc2.getName());
                doTransfer(acc1, acc2, amount);
            }
        }
        System.out.println("Transfer successful " + amount);
    }

    public static void transferMonitor(Account acc1, Account acc2, int amount) throws InsufficientResourcesException, InterruptedException {
        // without deadLock Используем монитор
        System.out.println("start transfer " + acc1.getName() + " -> " + acc2.getName() + " " + amount);
        synchronized (monitor) {
            doTransfer(acc1, acc2, amount);
        }
        System.out.println("Transfer successful " + amount);
    }

    public static void transferWithoutDeadLock(final Account acc1, final Account acc2, final int amount) throws InsufficientResourcesException {
        // without deadLock Используем иерархию по ID
        long fromId = acc1.getId();
        long toId = acc2.getId();
        System.out.println("start transfer " + acc1.getName() + " -> " + acc2.getName() + " " + amount);
        if (fromId > toId) {
            synchronized (acc1) {
                System.out.println("lock object acc1 = " + acc1.getName());
                synchronized (acc2) {
                    System.out.println("lock object acc2 = " + acc2.getName());
                    doTransfer(acc1, acc2, amount);
                }
            }
        } else {
            synchronized (acc2) {
                System.out.println("lock object acc2 = " + acc2.getName());
                synchronized (acc1) {
                    System.out.println("lock object acc1 = " + acc1.getName());
                    doTransfer(acc1, acc2, amount);
                }
            }
        }
        System.out.println("Transfer successful " + amount);
    }

    public static void transferReentrantLock(final Account acc1, final Account acc2, final int amount) throws InsufficientResourcesException, InterruptedException {
        //
        if (acc1.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
            // without deadLock Используем java.util.concurrent.locks.ReentrantLock
            System.out.println("acc1.getLock().tryLock() true " + acc1.getName());
            try {
                if (acc2.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
                    //acc2.getLock().lock();
                    System.out.println("acc2.getLock().tryLock() true " + acc2.getName());
                    try {
                        doTransfer(acc1, acc2, amount);
                        System.out.println("Transfer successful " + amount);
                    } finally {
                        acc2.getLock().unlock();
                    }
                } else {
                    System.out.println("Transfer " + amount + " Сори, не вышло!");
                }
            } finally {
                acc1.getLock().unlock();
            }
        } else {
            System.out.println("Transfer " + amount + " Сори, не вышло!");
        }

    }

}
