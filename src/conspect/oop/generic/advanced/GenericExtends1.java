package conspect.oop.generic.advanced;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericExtends1 {

    public static void main(String[] args) {
        // ЗАПОМНИТЬ НАСЛЕДОВАНИЕ
        List<String> strList =  new ArrayList<>();
        List<Object> objList =  new ArrayList<>();

        print(strList);
        //print(objList);// Compile Error

    }

    public static void print(Collection<String> list){
        for (String string : list) {
            System.out.println(string);
        }
    }

}

