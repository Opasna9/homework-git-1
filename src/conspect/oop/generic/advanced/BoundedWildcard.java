package conspect.oop.generic.advanced;

import conspect.oop.generic.advanced.model.*;

import java.util.List;

public class BoundedWildcard {
    public static void main(String[] args) {

    }

    void copyProduct(List<Product> src, List<Product> dest){
        for (Product p : src) {
            dest.add(p);
        }
    }

//    void copyWildcard(List<? extends Product> src, List<? extends Product> dest){
//        for (Product p : src) {
//            dest.add(p);
//        }
//    }

    // все, что до продукта можем засунуть во все, что выше продукта
    // чтобы не могли список камер засунуть в список телефонов
    void copyWildcard(List<? extends Product> src, List<? super Product> dest){
        for (Product p : src) {
            dest.add(p);
        }
    }

}
