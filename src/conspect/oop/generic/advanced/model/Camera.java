package conspect.oop.generic.advanced.model;

public class Camera extends Product implements Comparable<Camera>{
    private int pixel;

    @Override
    public int compareTo(Camera o) {
        return o.pixel >= pixel ? -1 : 0;
    }
}
