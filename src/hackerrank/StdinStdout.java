package hackerrank;

import java.util.Scanner;

public class StdinStdout {
    public static void main(String[] args) {
        //https://javadevblog.com/klass-scanner-v-java-opisanie-i-primer-ispol-zovaniya.html
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
//        scan.nextLine(); // ???
//        String s = scan.nextLine();
        String s = scan.next();
        System.out.println("Int: " + i);
        System.out.println("Double: " + d);
        System.out.print("String: " + s);
    }
}
