package conspect.oop.generic;

public class GenericExtends {
    public static void main(String[] args) {

        Box box1 = new Box(1);
        Box box2 = new Box(3L);
        Number s = sumBox(box1,box2);
        System.out.println("box1 + box2 = " + s);

        System.out.println(sum(3,6L));

    }

    // Используем дженерик класс в методе
    public static Number sumBox(Box<? extends Number> b1,Box<? extends Number> b2){
        Number result = b1.getValue().doubleValue() + b2.getValue().doubleValue();
        return result;
    }

    // Дженерилизируем только метод
    public static <T extends String, K extends Number, M extends Number> T sum(K value1, M value2){
        T result = (T) Double.toString(value1.doubleValue() + value2.doubleValue());
        return result;
    }
}

class Box <T extends Number>{
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}