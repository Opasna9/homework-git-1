package test;

public class MemoryTest {
    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();

    }
}

class X { // 8/16 byte
    int a; // 4 byte
    byte b; // 1 byte
    java.lang.Integer c; // 4/8 byte

}
// +  выранвниване до 8
// 17 -> 24 для 32

class Y extends X { // 8/16 + 4 + 1 + 4/8 byte
    java.util.List d; // 4/8 byte
    java.util.Date e;// 4/8 byte
}
// +  выранвниване до 8
// 25 -> 32 для 32

