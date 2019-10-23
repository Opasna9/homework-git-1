package conspect.oop.exception;

public class TestIllegalArgumentException {
    public static void main(String[] args) {
        System.out.println("prev code");
        area(-10,-10);
        System.out.println("next code");
    }
    public static int area(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
        }
        return width * height;
    }
}
