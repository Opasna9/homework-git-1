package conspect.oop.threads.callable;

import conspect.oop.threads.deadlock.Account;
import conspect.oop.threads.deadlock.AccountUtils;

import javax.naming.InsufficientResourcesException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static conspect.oop.threads.deadlock.AccountUtils.WAIT_SEC;
import static conspect.oop.threads.deadlock.AccountUtils.doTransfer;

public class Transfer implements Callable<Boolean> {
    private int id;
    private Account acc1;
    private Account acc2;
    private int amount;
    private static Random rnd = new Random();

    public Transfer(int id, Account acc1, Account acc2, int amount) {
        this.id = id;
        this.acc1 = acc1;
        this.acc2 = acc2;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println("- Tread " + this.id + " transferReentrantLock(" + acc1.getName() + ", " + acc2.getName() + ", " + amount + ")");
        return transferReentrantLock(this.acc1, this.acc2,this.amount);
    }

    public Boolean transferReentrantLock(final Account acc1, final Account acc2, final int amount) throws InsufficientResourcesException, InterruptedException {
        //
        if(acc1.getLock().tryLock(rnd.nextInt(3), TimeUnit.SECONDS)){
            //acc1.getLock().lock();
            System.out.println("Tread " + this.id + " acc1.getLock().tryLock() true " + acc1.getName());
            try {
                if (acc2.getLock().tryLock(rnd.nextInt(3), TimeUnit.SECONDS)){
                    //acc2.getLock().lock();
                    System.out.println("Tread " + this.id + " acc2.getLock().tryLock() true " + acc2.getName());
                    try {
                        doTransfer(acc1, acc2, amount);
                        System.out.println("Transfer " + this.id + "  " + amount + " successful");
                        return true;
                    }finally {
                        acc2.getLock().unlock();
                    }
                } else {
                    System.out.println("Transfer " + this.id + " " + amount + " Сори, не вышло!");
                    return false;
                }
            }finally {
                acc1.getLock().unlock();
            }
        } else {
            System.out.println("Transfer " + this.id + " " + amount + " Сори, не вышло!");
            return false;
        }
    }

}
