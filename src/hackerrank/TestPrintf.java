package hackerrank;

import java.util.Scanner;

public class TestPrintf {
    public static void main(String[] args) {
        //java 100
        //cpp 65
        //python 50
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            //Complete this line
            System.out.printf("%-15s%03d%n", s1, x);
        }
        System.out.println("================================");
    }
}
