package conspect.oop.serialization;

import java.io.*;

public class Demo {
    public static void main(String[] args) {

        writeObject();

        readObject("store.bin");

    }

    private static void writeObject() {
        DataObject obj = new DataObject();
        obj.setMyData("hahahaha");

        System.out.println(obj);

        File file = new File("store.bin");

        try(FileOutputStream fo = new FileOutputStream(file);
            ObjectOutputStream so = new ObjectOutputStream(fo);){
            so.writeObject(obj);
            so.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readObject(String fileName) {
        try(FileInputStream fi = new FileInputStream(fileName);
            ObjectInputStream si = new ObjectInputStream(fi);){

            DataObject objNew = (DataObject) si.readObject();
            System.out.println(objNew);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
