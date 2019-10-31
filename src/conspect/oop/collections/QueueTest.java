package conspect.oop.collections;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        //Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();// обычный компоратор
        q.add(5);
        q.add(4);
        q.add(333);
        q.add(2);
        q.add(1);

        System.out.println(q);
        while (!q.isEmpty()){
            System.out.println(q.poll());// достаем из очереди
        }
        System.out.println(q);



    }
}
