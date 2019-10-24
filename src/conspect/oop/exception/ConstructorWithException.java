package conspect.oop.exception;

import java.io.IOException;

public class ConstructorWithException {
    public static void main(String[] args) {
        MyClass myClass = null;
        try {
            myClass = new MyClass();
        } catch (ArithmeticException e){
            // объект не создастся
            System.out.println("Гасим исключение конструктора");
        }
        System.out.println(myClass.getI());
    }
}

class MyClass {
    private int i;
    public MyClass() {
        i = 20 / i;
    }
    public int getI(){
        return i;
    }
}