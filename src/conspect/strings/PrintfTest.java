package conspect.strings;

public class PrintfTest {
    public static void main(String[] args) {
        System.out.printf("%7d%10.2f%nhellow!%10s%n", 6666, 55.789, "Sam");
        System.out.println("");
        Integer i=675;
        double root;
        root = Math.sqrt(i);
        System.out.printf("Корень числа %d равен %f%n", i, root );
        System.out.println("");
        System.out.printf("%,d%n", 7845);
        System.out.printf("%07d%n", 7845);
        System.out.printf("%+07d%n", 7845);
        System.out.printf("%-7d%n", 7845);
        System.out.println("");
        System.out.printf("%s%n", "Hello");
        System.out.printf("%.3s%n", "Hello");
        System.out.printf("%8.3s%n", "Hello");

        String s = String.format("Курс валют: %-4s%-8.4f  %-4s%-8.4f","USD", 58.4643, "EUR", 63.3695);
        System.out.println(s);
    }
}
