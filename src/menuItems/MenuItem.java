package menuItems;

public class MenuItem {
    private String name;
    private double price;
    private String quantity;

    public MenuItem(String name, double price, String quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Price: $" + price + ", Quantity: " + quantity;
    }
}
