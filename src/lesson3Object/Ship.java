package lesson3Object;

public class Ship {
    private int price;
    private String name;
    private int weight;
    private String type;
    private int humanSeats;

    public Ship() {
    }

    public Ship(int price, String name, int weight, String type, int humanSeats) {
        this.price = price;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.humanSeats = humanSeats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHumanSeats() {
        return humanSeats;
    }

    public void setHumanSeats(int humanSeats) {
        this.humanSeats = humanSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Ship ship = (Ship) o;
        if (price != ship.price) { return false; }
        if (weight != ship.weight) { return false; }
        if (name != null ? !name.equals(ship.name) : ship.name != null) { return false; }
        if (type != null ? !type.equals(ship.type) : ship.type != null) { return false; }
        return humanSeats != ship.humanSeats;
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + weight;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + humanSeats;
        return result;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", type='" + type + '\'' +
                ", humanSeats='" + humanSeats + '\'' +
                '}';
    }
}
