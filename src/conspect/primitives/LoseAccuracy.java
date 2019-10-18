package conspect.primitives;

public class LoseAccuracy {
    public static void main(String[] args) {
        LoseAccuracy01 loseAccuracy01 = new LoseAccuracy01();
        LoseAccuracy02 loseAccuracy02 = new LoseAccuracy02();
        LoseAccuracy03 loseAccuracy03 = new LoseAccuracy03();
        LoseAccuracy04 loseAccuracy04 = new LoseAccuracy04();

    }

    public static class LoseAccuracy01{
        public LoseAccuracy01 (){
            System.out.println("LoseAccuracy01");
            int x1 = 123456789;
            int x2 = 99999999;
            float f1 = x1;
            float f2 = x2;
            System.out.println("f1 = " + f1);
            System.out.println("f2 = " + f2);
        }
    }

    public static class LoseAccuracy02{
        public LoseAccuracy02 (){
            System.out.println("LoseAccuracy02");
            float f1 = 1.2345f;
            System.out.println("f1 = " +f1);
            System.out.printf("f1 = %.16f\n",f1);
            double d1 = f1;
            double d2 = 1.2345;
            System.out.println("d1 = " +d1);
            System.out.printf("d2 = %.16f\n",d2);
        }
    }

    public static class LoseAccuracy03 {
        public LoseAccuracy03() {
            System.out.println("LoseAccuracy03");
            long l1 = 1234567891234L;
            float f1 = l1;
            System.out.println("l1 = " + l1);
            System.out.println("f1 = " + f1);
        }
    }

    public static class LoseAccuracy04 {
        public LoseAccuracy04() {
            System.out.println("LoseAccuracy04");
            long a = 10_000_000_000L;
            int x;

            x = (int) a;
            System.out.println("x = " + x);

            byte b5 = 50;
            byte b4 = (byte) (b5 * 2);
            System.out.println("b4 = " + b4);

            byte b1 = 50, b2 = 20, b3 = 127;
            int x2 = b1 * b2 * b3;
            System.out.println("x2 = " + x2);

            double d = 12.34;
            int x3;
            x3 = (int) d;
            System.out.println("x3 = " + x3);
        }
    }
}
