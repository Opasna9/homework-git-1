package conspect;

public class SwitchWithBreak {
    public static void main(String[] args) {
        String s = new String("one");
        switch (s) {
            case "two":
                System.out.println("two");
                break;
            case "three":
                System.out.println("three");
                break;
            case "four":
                System.out.println("four");
                break;
            case "one":
                System.out.println("one");
                break;
            default:
                System.out.println("default");
        }
    }
}
