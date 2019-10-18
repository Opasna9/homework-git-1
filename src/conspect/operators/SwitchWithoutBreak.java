package conspect.operators;

public class SwitchWithoutBreak {
    public static void main(String[] args) {
        int x = 10;
        switch (x) {
            case 20:
                System.out.println("20");
            case 30:
                System.out.println("30");
            default:
                System.out.println("default");
            case 10:
                System.out.println("10");
            case 40:
                System.out.println("40");
        }
    }
}
