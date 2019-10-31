package conspect.oop.generic.advanced;

import conspect.oop.generic.advanced.model.*;

public class GenericExtends2 {
    public static void main(String[] args) {

        Container<Product> c1 = new Container<>();
        c1.setItem(new Product());
        c1.setItem(new Phone());
        c1.setItem(new Camera());
        Product p = c1.getItem();

        ContainerExt<Product> c2 = new ContainerExt<>();
        c2.setItem(new Product());
        c2.setItem(new Phone());
        c2.setItem(new Camera());
        //c1.setItem(new String()); // Compile Error

        //ContainerExtImpl<Product> c3 = new ContainerExtImpl<>();// Compile Error
        ContainerExtImpl<Camera> c4 = new ContainerExtImpl<>();
        c4.setItem(new Camera());
    }
}

