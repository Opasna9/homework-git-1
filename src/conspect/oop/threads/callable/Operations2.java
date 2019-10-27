package conspect.oop.threads.callable;

import conspect.oop.threads.deadlock.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Operations2 {
    private static Random rnd = new Random();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        final Account acc1 = new Account(1, "a", 1000);
        final Account acc2 = new Account(2, "b", 2000);

        List<Future<Boolean>> futureList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Transfer transfer = new Transfer(i, acc1, acc2, rnd.nextInt(400));
            Future<Boolean> future = service.submit(transfer);
            futureList.add(future);
        }

        service.shutdown();// чтобы больше не принимал Transfer

        int i = 0;
        try {
            service.awaitTermination(4, TimeUnit.SECONDS); // Ждет конца всех завршения потоков

            for (Future<Boolean> future : futureList) {
                System.out.println("--future " + i + " " +future.get().toString());
                i++;
            }
           // service.awaitTermination(4, TimeUnit.SECONDS); // Ждет конца всех завршения потоков
        } catch (InterruptedException e) {
            System.err.println(i + " " + e.getMessage());
            //e.printStackTrace();
        } catch (ExecutionException e) {
            System.err.println(i + " " + e.getMessage());
            e.printStackTrace();
        }

    }
}
