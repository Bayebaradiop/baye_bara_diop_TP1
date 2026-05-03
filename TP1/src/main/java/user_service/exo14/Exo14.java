package user_service.exo14;

import user_service.model.Order;
import user_service.model.Item;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Exo14 {
    public static final Function<List<Order>, List<Item>> flattenAllItems = orders ->
        orders.stream()
              .flatMap(order -> order.getItems().stream())
              .collect(Collectors.toList());
}
