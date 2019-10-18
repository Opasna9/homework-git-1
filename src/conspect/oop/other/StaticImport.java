package conspect.oop.other;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class StaticImport {
    // импорт статических полей и методов классов
    public static void main(String[] args) {
        int i = 20;
        double x;
        x = pow(i,2) * PI;
        System.out.println(x);
    }
}
