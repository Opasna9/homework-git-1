package conspect.oop.threads.callable;

import conspect.oop.threads.deadlock.Account;

import javax.naming.InsufficientResourcesException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static conspect.oop.threads.deadlock.AccountUtils.doTransfer;

public class Transfer implements Callable<TransferReturn> {
    private int id;
    private Account acc1;
    private Account acc2;
    private int amount;
    private static Random rnd = new Random();

    private static AtomicInteger failCounter = new AtomicInteger(0);


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
    public TransferReturn call() {
        System.out.println("- Tread " + this.id + " transferReentrantLock(" + acc1.getName() + ", " + acc2.getName() + ", " + amount + ")");
        return transferReentrantLock(this.acc1, this.acc2,this.amount);
    }

    public TransferReturn transferReentrantLock(final Account acc1, final Account acc2, final int amount) {

        try {
            if(acc1.getLock().tryLock(rnd.nextInt(3), TimeUnit.SECONDS)){
                //acc1.getLock().lock();
                System.out.println("Tread " + this.id + " acc1.getLock().tryLock() true " + acc1.getName());
                try {
                    if (acc2.getLock().tryLock(rnd.nextInt(3), TimeUnit.SECONDS)){
                        //acc2.getLock().lock();
                        System.out.println("Tread " + this.id + " acc2.getLock().tryLock() true " + acc2.getName());
                        try {
                            doTransfer(acc1, acc2, amount);
                            System.out.println("Successful Transfer " + this.id + " " + amount);
                            return new TransferReturn(true, "Successful");
                        }finally {
                            acc2.getLock().unlock();
                        }
                    } else {
                        System.out.println("Transfer " + this.id + " " + amount + "Сори, не вышло!");
                        failCounter.incrementAndGet();
                        return new TransferReturn(false,"Сори, не вышло!" );
                    }
                }finally {
                    acc1.getLock().unlock();
                }
            } else {
                System.out.println("Transfer " + this.id + " " + amount + "Сори, не вышло!");
                failCounter.incrementAndGet();
                return new TransferReturn(false,"Сори, не вышло!" );
                //eturn false;
            }
        } catch (InterruptedException | InsufficientResourcesException e) {
            // обрабатываем InsufficientResourcesException fromAcc.getBalance() < amount
            //e.printStackTrace();
            failCounter.incrementAndGet();
            return new TransferReturn(false,e.toString());
            //return false;
        }
    }

}

