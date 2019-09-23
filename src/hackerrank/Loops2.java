package hackerrank;

import java.util.Scanner;

public class Loops2 {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int result;
        String s;
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            result = a;
            s = ""+a;
            //System.out.println("n = " + n);
            for(int j = 0; j < n; j++){

                s+= ("+2^"+j+"*"+b);
                //System.out.println(s);
                result += (int)Math.pow(2, j)*b;
                System.out.print(result + " ");
            }
            System.out.println("");
        }
        in.close();
    }
}
