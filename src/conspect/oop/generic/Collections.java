package conspect.oop.generic;

import java.util.ArrayList;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
//        Extends
//        1) new ArrayList<C2>(): can store C2 D1 D2 E1 E2 E3 E4
//        2) new ArrayList<D1>(): can store    D1    E1 E2
//        3) new ArrayList<D2>(): can store       D2       E3 E4
//        4) new ArrayList<E1>(): can store          E1
//        5) new ArrayList<E2>(): can store             E2
//        6) new ArrayList<E3>(): can store                E3
//        7) new ArrayList<E4>(): can store                   E4
//        Super
//        1) new ArrayList<A1>(): can store A1          B1 B2       C1 C2    D1 D2 E1 E2 E3 E4
//        2) new ArrayList<A2>(): can store    A2          B2       C1 C2    D1 D2 E1 E2 E3 E4
//        3) new ArrayList<A3>(): can store       A3          B3       C2 C3 D1 D2 E1 E2 E3 E4
//        4) new ArrayList<A4>(): can store          A4       B3 B4    C2 C3 D1 D2 E1 E2 E3 E4
//        5) new ArrayList<B2>(): can store                B2       C1 C2    D1 D2 E1 E2 E3 E4
//        6) new ArrayList<B3>(): can store                   B3       C2 C3 D1 D2 E1 E2 E3 E4
//        7) new ArrayList<C2>(): can store
//                         C2    D1 D2 E1 E2 E3 E4

        List<E1> output = new ArrayList<>();
        List<A3> input = new ArrayList<>();
        Collections.copy(output,input);
        //Collections.copy(input,output); // error

        //output = get(input);
        //input = get(output);

    }

    public static <T> void copy(List<? super T> writeList, List<? extends T> readList) {
        for (int i = 0; i < readList.size(); i++)
            writeList.set(i, readList.get(i));
    }

}

class A1 extends B1{}
class A2 extends B2{}
class A3 extends B3{}
class A4 extends B4{}
class B1{}
class B2 implements C1,C2{}
class B3 implements C3,C2{}
class B4{}
interface C1 extends D1{}
interface C2 extends D1,D2{}
interface C3{}
interface D1 extends E1,E2{}
interface D2 extends E3,E4{}
interface E1{}
interface E2{}
interface E3{}
interface E4{}

