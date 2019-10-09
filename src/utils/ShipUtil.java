package utils;

import lesson3Object.Ship;
import lesson3Object.WorkDaysOfWeek;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created by user on 08.10.2019.
 */
public class ShipUtil {
    public static List<Ship> generateShips(int countShip){
        List<Ship> ships = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Ship ship = new Ship();
            ship.setName(RandomStringUtils.random(10, true, false));
            ship.setHumanSeats(parseInt(RandomStringUtils.randomNumeric(5)));
            ship.setPrice(parseInt(RandomStringUtils.randomNumeric(7)));
            ship.setType(RandomStringUtils.random(4, true, false));
            ship.setWeight(parseInt(RandomStringUtils.randomNumeric(4)));
            ship.setWorkDaysOfWeek(WorkDaysOfWeek.FIVE);
            ships.add(ship);
        }
        return ships;
    }

    public static void printShips(List<Ship> ships){
        for (Ship ship : ships) {
            System.out.println(ship);
        }
    }
}
