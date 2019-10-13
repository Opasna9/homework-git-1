package conspect;

public class IntegerCash {
    public static void main(String[] args) {
        // В классах Long, Integer, Short и Byte присутствует внутренний кеш ссылок на значения от -128 до 127
        Integer i1 = 10;
        Integer i2 = 10;
        System.out.println(i1 == i2);
        i1 = 128;
        i2 = 128;
        System.out.println(i1 == i2);

        int i=3;
        i = -i++ + i++ + -i;
        System.out.println(i);
    }
}
