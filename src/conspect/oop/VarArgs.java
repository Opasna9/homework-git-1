package conspect.oop;

public class VarArgs {
    public static void main(String[] args) {
        System.out.println("N1 = " + getArgCount(1,11,1,34));

        Integer[] i = {2, 4, 5, 6, 10};
        System.out.println("N2 = " + getArgCount(i));

        //System.out.println("N2 = " + VarArgs.getArgCount(i,i)); -?


    }

    public static int getArgCount(Integer... args){
        if (args.length == 0){
            System.out.println("No arg");
        }
        for (Integer arg : args) {
            System.out.println("arg: " + arg);
        }
        return (args.length);
    }

}
