import product.Product;
import valueobject.Money;
import valueobject.SKU;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Product p = new Product(
                new SKU("TEC-12345"),
                "Laptop HP",
                new Money(new BigDecimal("500000"), "FCFA")
        );

        System.out.println(p);

        p.applyDiscount(new BigDecimal("10"));

        System.out.println("Après réduction:");
        System.out.println(p);
    }
}