package lesson4;

import lesson3.Boat;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created by user on 01.10.2019.
 */

public class Demo {
    public static void main(String[] args) {
        List<Boat> boats = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Boat boat = new Boat(parseInt(RandomStringUtils.randomNumeric(5)),
                    parseInt(RandomStringUtils.randomNumeric(3)));
            Boat boat1 = new Boat(parseInt(RandomStringUtils.randomNumeric(7)),
                    RandomStringUtils.random(10, true, false),
                    parseInt(RandomStringUtils.randomNumeric(5)),
                    RandomStringUtils.random(4, true, false),
                    parseInt(RandomStringUtils.randomNumeric(4)),
                    parseInt(RandomStringUtils.randomNumeric(5)),
                    parseInt(RandomStringUtils.randomNumeric(3)));
            boats.add(boat);
            boats.add(boat1);
        }


        for (Boat b : boats) {
            System.out.println(b.toString());
        }

        System.out.println("Count boats = " + Boat.getCount());
    }

}
