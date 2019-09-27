package lesson3;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created by user on 26.09.2019.
 */
public class Demo {
    public static void main(String[] args) {
        List<Ship> ships = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Ship ship = new Ship();
            ship.setName(RandomStringUtils.random(4));
            ship.setDateRelease(RandomStringUtils.random(4));
            ship.setPrice(parseInt(RandomStringUtils.randomNumeric(4)));
            ship.setType(RandomStringUtils.random(4));
            ship.setWeight(parseInt(RandomStringUtils.randomNumeric(4)));
            ships.add(ship);
        }

        for (Ship ship : ships) {
            System.out.println(ship.toString());
        }

        Arrays.sort(ships.toArray());

        for (Ship ship : ships) {
            System.out.println(ship.toString());
        }



    }
}
