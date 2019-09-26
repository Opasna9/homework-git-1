package hackerrank;

import java.util.Scanner;

public class Loops2 {
    public static void main(String []argh){
        /* The first line contains an integer, , denoting the number of queries.
        Each line  of the  subsequent lines contains three space-separated integers describing the respective ,
        a^i b^i n^i, and  values for that query.
        */
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int result;
        String s;
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            result = a;
            s = "" + a;
            for(int j = 0; j < n; j++){
                s += ("+2^"+j+"*"+b);
                result += (int)Math.pow(2, j)*b;
                System.out.print(result + " ");
            }
            System.out.println("");
        }
        in.close();
    }
}
