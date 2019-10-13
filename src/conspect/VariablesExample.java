package conspect;

public class VariablesExample {
    boolean statusOn;
    double javaVar = 2.34;

    public static void main(String[] args) {
        int itemSold = 04;
        double salary = 1.234e3;
        float itemCost = 11.0f;
        int i = 0xFd45, k$;
        double _inreresrRate;
        System.out.println("itemSold = " + itemSold);
        System.out.println("salary = " + salary);
        System.out.println("itemCost = " + itemCost);
        System.out.println("i = " + i);
        javaMethod();
    }

    public static void javaMethod(){
        long simpleVar = 1_000_000_000_000L;
        byte byteVar2 = 123;
        System.out.println("simpleVar = " + simpleVar);
        System.out.println("byteVar2 = " + byteVar2);
    }
}
