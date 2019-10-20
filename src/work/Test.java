package work;

import java.lang.reflect.Array;

public class Test implements Cloneable{
    public int i;

    public static void main(String[] args) {
        System.out.println(1+1/2);
        System.out.println("Льготный".equals("Льготный"));
        int y = 10;
        System.out.println(y);
        y= y + (y>>1) ;
        System.out.println(y);
        y=y+(y>>1);
        System.out.println(y);
    }

}


