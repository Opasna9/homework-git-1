package conspect.oop.threads.callable;

import conspect.oop.threads.deadlock.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class OperationsCall {
    public static Random rnd = new Random();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        final Account acc1 = new Account(1, "a", 1000);
        final Account acc2 = new Account(2, "b", 2000);
        System.out.println("acc1 = " + acc1);
        System.out.println("acc1 = " + acc2);

        List<Future<TransferReturn>> futureList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Transfer transfer = new Transfer(i, acc1, acc2, rnd.nextInt(400));
            Future<TransferReturn> future = service.submit(transfer);
            futureList.add(future);
        }

        service.shutdown();// чтобы больше не принимал Transfer

        int i = 0;
        try {
            service.awaitTermination(4, TimeUnit.SECONDS); // Ждет конца всех завршения потоков

            System.out.println("FailCounter = " + Transfer.getFailCounter());

            for (Future<TransferReturn> future : futureList) {
                System.out.println("--future " + i + " " +future.get().toString());
                i++;
            }
            System.out.println("acc1 = " + acc1);
            System.out.println("acc1 = " + acc2);


        } catch (InterruptedException e) {
            System.err.println(i + " " + e.getMessage());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
