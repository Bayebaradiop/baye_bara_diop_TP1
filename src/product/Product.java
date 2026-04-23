package product;

import java.math.BigDecimal;
import java.util.UUID;

import valueobject.Money;
import valueobject.SKU;

public class Product {

    private final UUID id;
    private final SKU sku;
    private final String name;
    private Money price;

    public Product(SKU sku, String name, Money price) {

        if (sku == null) {
            throw new IllegalArgumentException("SKU obligatoire");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nom obligatoire");
        }

        if (price == null) {
            throw new IllegalArgumentException("Prix obligatoire");
        }

        this.id = UUID.randomUUID();
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public void applyDiscount(BigDecimal percentage) {

        if (percentage == null ||
                percentage.compareTo(BigDecimal.valueOf(0.1)) < 0 ||
                percentage.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new IllegalArgumentException("Pourcentage invalide");
        }

        BigDecimal reduction =
                price.amount()
                        .multiply(percentage)
                        .divide(BigDecimal.valueOf(100));

        BigDecimal newPrice =
                price.amount().subtract(reduction);

        this.price = new Money(newPrice, price.currency());
    }

    public UUID getId() {
        return id;
    }

    public SKU getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", sku=" + sku.value() +
                ", name='" + name + '\'' +
                ", price=" + price.amount() + " " + price.currency() +
                '}';
    }
}