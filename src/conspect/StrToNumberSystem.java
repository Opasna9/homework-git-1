package conspect;

import java.util.Scanner;

public class StrToNumberSystem {
    //Для преобразования целого числа в десятичную, двоичную, шестнадцатеричную и восьмеричную строки
    // используются методы toString(), toBinaryString(), toHexString() и toOctalString().
    public static void main(String[] args) {
        System.out.println(Integer.toString(267));
        System.out.println(Integer.toBinaryString(267));
        System.out.println(Integer.toHexString(267));
        System.out.println(Integer.toOctalString(267));
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println("s = " + s);

    }
}
