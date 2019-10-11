package utils;

import lesson3Object.Ship;
import lesson3Object.WorkDaysOfWeek;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ShipUtils {

    /**
     * Returns an array of Ship objects with random fields
     *
     * @param countShip - number of objects
     * @return - array of objects Ship
     */
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

    /**
     * Print a List of Ship objects
     *
     * @param ships - List of Ship objects
     */
    public static void printShips(List<Ship> ships){
        for (Ship ship : ships) {
            System.out.println(ship);
        }
    }
}
