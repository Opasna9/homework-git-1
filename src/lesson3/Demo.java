package lesson3;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.*;
import static java.lang.Integer.parseInt;
import static java.util.Comparator.comparing;

/**
 * Created by user on 26.09.2019.
 */
public class Demo {
    public static void main(String[] args) {
        List<Ship> ships = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Ship ship = new Ship();
            ship.setName(RandomStringUtils.random(10,true,true));
            ship.setHumanSeats(parseInt(RandomStringUtils.randomNumeric(5)));
            ship.setPrice(parseInt(RandomStringUtils.randomNumeric(7)));
            ship.setType(RandomStringUtils.random(4,true,false));
            ship.setWeight(parseInt(RandomStringUtils.randomNumeric(4)));
            ships.add(ship);
        }

        for (Ship ship : ships) {
            System.out.println(ship.toString());
        }

        System.out.println("sort");

        Collections.sort(ships, comparing(Ship::getPrice));

        for (Ship ship : ships) {
            System.out.println(ship.toString());
        }



    }
}
