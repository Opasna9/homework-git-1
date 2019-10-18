package conspect.oop.parameirization;

public class Holder<T> {
    T v;
    T get() {
        return v;
    }
    void set(T n) {
        v=n;
    }

    public static void main(String[]args) {
        Holder<? super Number> hs = new Holder();
        Holder<? extends Number> he = new Holder();
        Holder<?> h = new Holder();

        Integer i =1;
        Number n = 1;
        Object o = new Object();

        // Producer Super
        //i = hs.get(); // <? super Number> cannot be converted to Integer
        //n = hs.get(); // <? super Number> cannot be converted to Number
        o = hs.get();

        // Consumer Super
        hs.set(i);
        hs.set(n);
        //hs.set(o); // Object cannot be converted to <? super Number>

        // Producer Extends
       // i = he.get(); // <? extends Number> cannot be converted to Integer
        n = he.get();
        o = he.get();

        // Consumer Extends: always gives an error
        //he.set(i); // Integer cannot be converted to <? extends Number>
        //he.set(n); // Number cannot be converted to <? extends Number>
        //he.set(o); // Object cannot be converted to <? extends Number>

        // Producer Super
        //i = h.get(); // <?> cannot be converted to Integer
        //n = h.get(); // <?> cannot be converted to Number
        o = h.get();

        // Consumer Super
        //h.set(i); // Integer cannot be converted to <?>
        //h.set(n); // Number cannot be converted to <?>
        //h.set(o); // Object cannot be converted to <?>
    }
}

