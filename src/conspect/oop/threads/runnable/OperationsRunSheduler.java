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

            ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

            //  в отдельном потоке запускаем
            for (int i = 1; i <= 10; i++) {
                Transfer transfer = new Transfer(i, acc1, acc2, rnd.nextInt(400));
                // запуск после 5 сек
                service.schedule(transfer, 5, TimeUnit.SECONDS);
                //service.scheduleAtFixedRate(transfer, 2,1, TimeUnit.SECONDS);
            }


            System.out.println("--Thread.activeCount() = " + Thread.activeCount());// кол.-во активных потоков, для дэбага
            System.out.println("--Thread thread = Thread.currentThread()");
            Thread thread = Thread.currentThread(); // получает текущий поток

            {
                System.out.println("  --thread.getName() = " + thread.getName());
                System.out.println("  --thread.toString() = " + thread.toString());
                System.out.println("  --thread.getId() = " + thread.getId());
                System.out.println("  --thread.getStackTrace() = " + thread.getStackTrace());
                System.out.println("  --thread.getContextClassLoader() = " + thread.getContextClassLoader());
                System.out.println("  --thread.getPriority() = " + thread.getPriority());
                System.out.println("  --thread.getState() = " + thread.getState());
                System.out.println("  --thread.getThreadGroup() = " + thread.getThreadGroup());
                System.out.println("  --thread.isAlive() = " + thread.isAlive());
                System.out.println("  --thread.isDaemon() = " + thread.isDaemon());
                System.out.println("  --thread.isInterrupted() = " + thread.isInterrupted());
                //System.out.println("  --thread.getContextClassLoader() = " + thread.);
                System.out.println("  --thread.start()");
                //thread.start(); // запускает
                System.out.println("  --thread.interrupt()");
                //thread.interrupt(); // прерывает
                System.out.println("  --thread.join()");
                //thread.join(); // выполняется до конца
                System.out.println("  --thread.setName()");
                thread.setName("Super MAIN =)");
                System.out.println("  --thread.getName() = " + thread.getName());
            }

            System.out.println("--Thread.holdsLock(Object) = " + Thread.holdsLock(acc1));// держит ли монитор у объекта?
            System.out.println("--Thread.interrupted() = " + Thread.interrupted());// прерван ли?
            System.out.println("--Thread.sleep(2000)");
            Thread.sleep(2000);// засыпает
            System.out.println("--Thread.yield()");
            Thread.yield();// уступает процессорное время другим потокам
//            System.out.println("--Thread.dumpStack()");// для дэбага
//            Thread.dumpStack();


            service.awaitTermination(5, TimeUnit.SECONDS);// ждем 5 секунд работы
            service.shutdown(); // чтобы больше не принимал Transfer
            service.awaitTermination(4, TimeUnit.SECONDS);// ждем 1 для завршения запущенных потоков

            System.out.println("acc1 = " + acc1);
            System.out.println("acc2 = " + acc2);
            System.out.println("FailCounter = " + new Transfer().getFailCounter());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

