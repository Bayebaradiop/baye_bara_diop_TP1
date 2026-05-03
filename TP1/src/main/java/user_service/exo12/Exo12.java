package user_service.exo12;

import user_service.model.Product;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Exo12 {
    public static final Function<List<Product>, DoubleSummaryStatistics> getPriceStatistics = products ->
        products.stream()
                .collect(Collectors.summarizingDouble(Product::getPrice));
}
