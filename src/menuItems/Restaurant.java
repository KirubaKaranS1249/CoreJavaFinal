package menuItems;

import java.util.ArrayList;

public class Restaurant {
    private ArrayList<MenuItem> menuItems;

    public Restaurant() {
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
        System.out.println("Menu item added successfully.");
    }

    public void removeMenuItem(String name) {
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getName().equalsIgnoreCase(name)) {
                menuItems.remove(i);
                System.out.println("Menu item removed successfully.");
                return;
            }
        }
        System.out.println("Menu item not found.");
    }

    public MenuItem searchMenuItem(String name) {
        for (MenuItem item : menuItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void displayMenu() {
        if (menuItems.isEmpty()) {
            System.out.println("No menu items available.");
        } else {
            for (MenuItem item : menuItems) {
                System.out.println(item);
            }
        }
    }
}
