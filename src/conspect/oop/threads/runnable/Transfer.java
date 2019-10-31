package conspect.oop.threads.runnable;

import conspect.oop.threads.model.Account;

import javax.naming.InsufficientResourcesException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static conspect.oop.threads.deadlock.AccountUtils.WAIT_SEC;
import static conspect.oop.threads.deadlock.AccountUtils.doTransfer;

public class Transfer implements Runnable {
    private int id;
    private Account acc1;
    private Account acc2;
    private int amount;
    private static Random rnd = new Random();

    private static AtomicInteger failCounter = new AtomicInteger(0);

    public Transfer() {
    }

    public Transfer(int id, Account acc1, Account acc2, int amount) {
        this.id = id;
        this.acc1 = acc1;
        this.acc2 = acc2;
        this.amount = amount;
    }

    public static AtomicInteger getFailCounter() {
        return failCounter;
    }

    @Override
    public void run() {
        //
        try {
            if(acc1.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)){
                // without deadLock Используем java.util.concurrent.locks.ReentrantLock
                System.out.println("acc1.getLock().tryLock() true " + acc1.getName());
                try {
                    if (acc2.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)){
                        //acc2.getLock().lock();
                        System.out.println("acc2.getLock().tryLock() true " + acc2.getName());
                        try {
                            doTransfer(acc1, acc2, amount);
                            System.out.println("Successful Transfer " + this.id + " " + amount);
                        }finally {
                            acc2.getLock().unlock();
                        }
                    } else {
                        System.out.println("Transfer " + this.id + " " + amount + " Сори, не вышло!");
                        failCounter.incrementAndGet();
                    }
                }finally {
                    acc1.getLock().unlock();
                }
            } else {
                System.out.println("Transfer " + this.id + " " + amount + " Сори, не вышло!");
                failCounter.incrementAndGet();
            }
        } catch (InterruptedException | InsufficientResourcesException e) {
            System.out.println("Transfer " + this.id + " " + amount + " " + e.toString());
            failCounter.incrementAndGet();
            //e.printStackTrace();
        }
    }
}
