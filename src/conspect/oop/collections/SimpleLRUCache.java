package conspect.oop.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleLRUCache<K, V> extends LinkedHashMap <K, V> {
    private final int capacity;

    public SimpleLRUCache(int capacity) {
        // размер не меняется, переполнение невозможно, сортировка по доступу
        super(capacity +1, 1.1f, true);
        this.capacity = capacity;
    }

    @Override
    // (автоматом вызывается после вставки элемента)
    // колизий не будет никогда
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
        return this.size() > capacity; // скосит наиболее редкий элемент
    }

    public static void main(String[] args) {
        SimpleLRUCache<Integer,String> cache = new SimpleLRUCache<>(2);
        cache.put(1,"a");
        cache.put(2,"b");
        cache.put(3,"c"); // удалет старую =1, тк размер 2
        System.out.println(cache);
        cache.get(2); // переместился в конец, типа только добавили
        cache.put(9,"sss");// удалет старую =3
        System.out.println(cache);
    }
}
