package work;

import java.lang.reflect.Array;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test implements Cloneable {
    public int i;

    public static void main(String[] args) {
        System.out.println(1 + 1 / 2);
        System.out.println("Льготный".equals("Льготный"));
        int y = 10;
        System.out.println(y);
        y = y + (y >> 1);
        System.out.println(y);
        y = y + (y >> 1);
        System.out.println(y);
        y = y + (y >> 1);
        System.out.println(y);


        System.out.println(1 << 30);


        Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(15, 0.75f, true) {{
            put(1, "obj1");
            put(15, "obj15");
            put(4, "obj4");
            put(38, "obj38");
        }};

        System.out.println(linkedHashMap);
        System.out.println(linkedHashMap.get(1));

        linkedHashMap = new LinkedHashMap<Integer, String>(15, 0.75f, false) {{
            put(1, "obj1");
            put(15, "obj15");
            put(4, "obj4");
            put(38, "obj38");
        }};

        System.out.println(linkedHashMap);
        System.out.println(linkedHashMap.get(1));

    }




}


