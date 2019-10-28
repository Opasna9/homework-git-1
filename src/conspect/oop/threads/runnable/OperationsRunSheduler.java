package conspect.oop.threads.runnable;

import conspect.oop.threads.deadlock.Account;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static conspect.oop.threads.callable.OperationsCall.rnd;

public class OperationsRunSheduler {
    public static void main(String[] args) {
        try {
            final Account acc1 = new Account(1, "a", 1000);
            final Account acc2 = new Account(2, "b", 2000);

            System.out.println("acc1 = " + acc1);
            System.out.println("acc1 = " + acc2);

            ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

            //  в отдельном потоке запускаем
            for (int i = 1; i <= 10; i++) {
                Transfer transfer = new Transfer(1, acc1, acc2, rnd.nextInt(400));
                // запуск после 5 сек
                //service.schedule(transfer, 5, TimeUnit.SECONDS);
                service.scheduleAtFixedRate(transfer, 2,1, TimeUnit.SECONDS);
            }


            service.awaitTermination(5, TimeUnit.SECONDS);// ждем 5 секунд работы
            service.shutdown(); // чтобы больше не принимал Transfer
            service.awaitTermination(4, TimeUnit.SECONDS);// ждем 1 для завршения запущенных потоков



            System.out.println("acc1 = " + acc1);
            System.out.println("acc1 = " + acc2);
            System.out.println(new Transfer().getFailCounter());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

