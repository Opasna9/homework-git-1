package lesson5Abstract;

import lesson3Object.Ship;
import utils.ShipUtil;

import java.util.List;

/**
 * Created by user on 08.10.2019.
 */
public class Demo {
    public static void main(String[] args) {
        List<Ship> ships = ShipUtil.generateShips(10);
        int i = 1;

        ShipUtil.printShips(ships);

        for (Ship ship : ships) {
            System.out.println("---" + i + "---");
            System.out.println(ship);
            ship.run();
            System.out.println("Cost = " + ship.generateSellPrice());
            i++;
        }
    }
}

