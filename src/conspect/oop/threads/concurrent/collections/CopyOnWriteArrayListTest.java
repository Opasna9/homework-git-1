package conspect.oop.threads.concurrent.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        List<Integer> list1 = Collections.synchronizedList(new ArrayList<>());
        List<Integer> list2 = new CopyOnWriteArrayList<>();

        fillList(list1, 100);
        fillList(list2, 100);

        System.out.println("List synchronized");
        checkList(list1);

        System.out.println("CopyOnWriteArrayList");
        checkList(list2);
    }

    private static void checkList(List<Integer> list) {
        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Long> f1 = ex.submit(new ListRunner(0,50,list, latch));
        Future<Long> f2 = ex.submit(new ListRunner(50,100,list, latch));
        // запустили 2 патока работающих с одним листом
        latch.countDown();

        ex.shutdown();
        try {
            System.out.println("Thread 1: " + f1.get()/1000);// ждет, когда поток завершится
            System.out.println("Thread 2: " + f2.get()/1000);// ждет, когда поток завершится
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void fillList(List<Integer> list1, int i) {
        for (int j = 0; j < i; j++) {
            list1.add(j);
        }
    }

    static class ListRunner implements Callable<Long>{
        private CountDownLatch latch;
        private int start;
        private int end;
        private List<Integer> list;

        public ListRunner(int start, int end, List<Integer> list, CountDownLatch latch) {
            this.latch = latch;
            this.start = start;
            this.end = end;
            this.list = list;
        }

        @Override
        public Long call() throws Exception {
            latch.await();
            long startTime = System.nanoTime();

            for (int i = start; i < end; i++){
                list.get(i);
            }
            return System.nanoTime() - startTime;
        }
    }


}
