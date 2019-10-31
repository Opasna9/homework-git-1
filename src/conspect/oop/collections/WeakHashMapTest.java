package conspect.oop.collections;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) {
        // подходит для временного хранилища
        Map<Data, String> map = new WeakHashMap<>();
        Data data = new Data();
        map.put(data, "informations");

        data = null; // сделали досупным для gc()
        System.gc(); // вызываем сборщика мусора

        // чтобы дождаться отработки gc()
        for (int i =1; i <10000 ; i++ ){
            if (map.isEmpty()){
                System.out.println(i);
                System.out.println("Empty!");
                break;
            }
        }
    }

    static class Data{
        private String value;
    }
}
