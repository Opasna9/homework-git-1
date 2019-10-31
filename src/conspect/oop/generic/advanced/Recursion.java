package conspect.oop.generic.advanced;

public class Recursion {
    public static void main(String[] args) {
        Phone phone1 = new Phone();

        Camera cam1 = new Camera();
        Camera cam2 = new Camera();

        cam1.compareTo(cam2);
        //cam1.compareTo(phone1);// Compile Error

    }

    abstract static class Product<T extends Product<T>> implements Comparable<T>{
        private String name;
        private int price;
        private T type;

        public boolean isSameProduct(Product p) {
            return true;
        }

        @Override
        public int compareTo(T p) {
            // ? как сравнить продукты вначале
            return subCompare(p);
        }

        //abstract int subCompare(Product p);

        abstract int subCompare(T p);
    }

    static class Camera extends Product<Camera> {
        private int pixel;

//        @Override
//        int subCompare(Product p){
//            if (p instanceof Camera){ // fail save
//                Camera c = (Camera) p;
//                return c.pixel >= pixel ? -1 : 0;
//            } else {
//                return 0;
//            }
//        }

        @Override
        int subCompare(Camera c){
            return c.pixel >= pixel ? -1 : 0;
        }
    }

    static class Phone extends Product<Phone>{
        private String model;

//        @Override
//        int subCompare(Product p){
//            if (p instanceof Phone){ // fail save
//                Phone ph = (Phone) p;
//                return model.compareTo(ph.model);
//            } else {
//                return 0;
//            }
//        }

        @Override
        int subCompare(Phone ph){
            return model.compareTo(ph.model);
        }
    }
}





