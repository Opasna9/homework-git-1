package hackerrank;

import java.util.Scanner;

public class StdinStdout {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        scan.nextLine(); // ???
        String s = scan.nextLine();

        System.out.println("Int: " + i);
        System.out.println("Double: " + d);
        System.out.print("String: " + s);
    }
}
