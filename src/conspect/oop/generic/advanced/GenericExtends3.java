package conspect.oop.generic.advanced;

import conspect.oop.generic.advanced.model.*;

import java.util.ArrayList;
import java.util.List;

public class GenericExtends3 {
    public static void main(String[] args) {
        List<Camera> cameras = new ArrayList<>( );

        //find(cameras, new Camera());//Compile Error лист камер - это не лист продуктов

        findWildcard(cameras, new Camera());
        findWildcard(cameras, new Phone());
        findWildcard(cameras, new Product());

        findGeneric(cameras, new Camera());
        //findGeneric(cameras, new Phone());//Compile Error
        //findGeneric(cameras, new Product());//Compile Error, тк T extends Product

    }

    public boolean find(List<Product> all, Product p){
        for (Product sp : all) {
            if(sp.isSameProduct(p)){
                return true;
            }
        }
        return false;
    }

    public static boolean findWildcard(List<? extends Product> all, Product p){
        for (Product sp : all) {
            if(sp.isSameProduct(p)){
                return true;
            }
        }
        return false;
    }

    public static <T extends Product> boolean findGeneric(List<T> all, T p){
        for (Product sp : all) {
            if(sp.isSameProduct(p)){
                return true;
            }
        }
        return false;
    }

//    public static <? extends Product> boolean findGenericWildcard(List<?> all, ? p){
//        for (Product sp : all) {
//            if(sp.isSameProduct(p)){
//                return true;
//            }
//        }
//        return false;
//    }
}
