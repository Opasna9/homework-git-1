package conspect.oop.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataObject extends NonSerializable implements Serializable {
    private int i = 5;
    private String s = "aaa";
    private transient String[] def = new String[]{"111", "2222"};
    private CustomObject customObject;
    private List<Integer> list = new ArrayList<>();

    public DataObject() {
        list.add(1);
        list.add(2);
    }

    @Override
    public String toString() {
        return super.toString() +
                "DataObject{" +
                "i=" + i +
                ", s='" + s + '\'' +
                ", def=" + Arrays.toString(def) +
                ", customObject=" + customObject +
                ", list=" + list +
                '}';
    }

    // если хотим сериализовать поля родителя NonSerializable

    // переопределяем методы
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();// всегда вызываем
        out.writeObject(getMyData());

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();// всегда вызываем
        setMyData((String) in.readObject());
    }

}
