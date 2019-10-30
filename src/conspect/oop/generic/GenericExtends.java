package conspect.oop.generic;

public class GenericExtends {
    public static void main(String[] args) {

    }

    public Number sum(Box<? extends Number> b1,Box<? extends Number> b2){
        Number result = b1.getValue().doubleValue() + b2.getValue().doubleValue();
        return result;
    }
}

class Box <T extends Number>{
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}