package conspect;

public class LigicOP {
    public static void main(String[] args) {
        boolean bTrue = true;
        boolean bFalse = false;
        //&& || - вычисление по сокращенной схеме
        //& | - вычисление по полной схеме

        if (bTrue && bFalse){
            System.out.println("1");
        }
        if (bTrue & bFalse){
            System.out.println("2");
        }
        if (bTrue || bFalse){
            System.out.println("3");
        }
        if (bTrue | bFalse){
            System.out.println("4");
        }
    }
}
