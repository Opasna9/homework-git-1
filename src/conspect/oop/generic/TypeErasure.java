package conspect.oop.generic;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TypeErasure<T> {

    public <E> void test(Collection<E> collection){
        for (E e : collection) {
            System.out.println(e);
        }
    }

    public void test(List<Integer> integerList){
        for (Integer integer : integerList) {
            System.out.println(integer);
        }
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("value");

        TypeErasure<?> typeErasure1 = new TypeErasure(); // создан с generic
        // стирает всю информацию с дженериками
        typeErasure1.test(list);// вызывается 1 метод

        TypeErasure typeErasure = new TypeErasure(); // сырой тип, тк создан без generic
        // стирает всю информацию с дженериками
        typeErasure.test(list);// вызывается 2 метод и насильно приводит к Integer
    }

}
