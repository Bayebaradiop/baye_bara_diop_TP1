package user_service.model;

import java.util.List;

/**
 * Classe Order pour l'exercice 14
 */
public class Order {
    private String id;
    private List<Item> items;

    public Order(String id, List<Item> items) {
        this.id = id;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order{id='" + id + "', items=" + items + "}";
    }
}
