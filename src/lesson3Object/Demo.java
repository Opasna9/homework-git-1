package lesson3Object;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

import static java.lang.Integer.parseInt;
import static java.util.Comparator.comparing;

public class Demo {
    public static void main(String[] args) {
        List<Ship> ships = new ArrayList<>();
        List<Ship> newShips;
        int weightMax = 1500;
        int weightMin = 10;

        for (int i = 0; i < 10; i++) {
            Ship ship = new Ship();
            ship.setName(RandomStringUtils.random(10, true, false));
            ship.setHumanSeats(parseInt(RandomStringUtils.randomNumeric(5)));
            ship.setPrice(parseInt(RandomStringUtils.randomNumeric(7)));
            ship.setType(RandomStringUtils.random(4, true, false));
            ship.setWeight(parseInt(RandomStringUtils.randomNumeric(4)));
            ships.add(ship);
        }

        for (Ship ship : ships) {
            System.out.println(ship.toString());
        }

        System.out.println("\nCollections.sort ships getPrice ");
        Collections.sort(ships, comparing(Ship::getPrice));

        for (Ship ship : ships) {
            System.out.println(ship.toString());
        }

        System.out.println("");
        sortBubbleShipList(ships, "getName");

        for (Ship ship : ships) {
            System.out.println(ship.toString());
        }

        System.out.println("");
        newShips = filterShipListByWeight(ships,weightMax,weightMin);
        for (Ship ship : newShips) {
            System.out.println(ship.toString());
        }
    }

    /**
     * Sort method Bubble for List<Ship> by field
     *
     * @param list list objects Ship for sort
     * @param field name get method for sort
     */
    private static void sortBubbleShipList(List<Ship> list, String field) {
        System.out.println("sortBubbleShipArray ships " + field);
        Ship temp;
        for (int i = 0; i < list.size(); i++) {
            for (int j = (list.size() - 1); j >= (i + 1); j--) {
                boolean condition;
                switch (field) {
                    case "getPrice":
                        condition = list.get(j).getPrice() < list.get(j - 1).getPrice();
                        break;
                    case "getHumanSeats":
                        condition = list.get(j).getHumanSeats() < list.get(j - 1).getHumanSeats();
                        break;
                    case "getWeight":
                        condition = list.get(j).getWeight() < list.get(j - 1).getWeight();
                        break;
                    case "getName":
                        condition = list.get(j - 1).getName().compareTo(list.get(j).getName()) > 0;
                        break;
                    case "getType":
                        condition = list.get(j - 1).getType().compareTo(list.get(j).getType()) > 0;
                        break;
                    default:
                        condition = false;
                }
                if (condition) {
                    temp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                }
            }
        }
    }

    /**
     * Returns List<Ship> filtered for by field weight
     *
     * @param list list objects Ship for filter
     * @param weightMax max value weight
     * @param weightMin min value weight
     * @return new list after filter
     */
    private static List<Ship> filterShipListByWeight(List<Ship> list, int weightMax, int weightMin) {
        System.out.println("filterShipListByWeight ships: weightMax = " + weightMax + " weightMin = " + weightMin);
        List<Ship> ships = new ArrayList<>();
        for (Ship ship : list) {
            if ((ship.getWeight() >= weightMin) && (ship.getWeight() <= weightMax)) {
                ships.add(ship);
            }
        }
        return ships;
    }

}
