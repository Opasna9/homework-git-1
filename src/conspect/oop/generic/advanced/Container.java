package conspect.oop.generic.advanced;

import conspect.oop.generic.advanced.model.*;

public class Container<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

class ContainerExt<T extends Product> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

class ContainerExtImpl<T extends Product & Comparable<T>> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}