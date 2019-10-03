package test;

public class CloneObjectTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        SimpleClass simpleClass = new SimpleClass(15,10);
        SimpleClass simpleClassClone = simpleClass.clone();
        simpleClassClone.setParam2(120);
        System.out.println("simpleClass = " + simpleClass);
        System.out.println("simpleClassClone = " + simpleClassClone);
    }
}

class SimpleClass implements Cloneable{
    private double param1 ;
    private int param2;
    public SimpleClass() {
    }

    SimpleClass(double param1, int param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    public double getParam1() {
        return param1;
    }

    public void setParam1(double param1) {
        this.param1 = param1;
    }

    public int getParam2() {
        return param2;
    }

    public void setParam2(int param2) {
        this.param2 = param2;
    }

    @Override
    public String toString() {
        return "SimpleClass{" +
                "param1=" + param1 +
                ", param2=" + param2 +
                '}';
    }

    @Override
    protected SimpleClass clone() throws CloneNotSupportedException {
        return (SimpleClass) super.clone();
    }
}
