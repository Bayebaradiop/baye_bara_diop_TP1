package user_service.exo11;

import user_service.model.Transaction;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Exo11 {
    public static final Function<List<Transaction>, Map<String, List<Transaction>>> groupByCurrency = transactions ->
        transactions.stream()
                    .collect(Collectors.groupingBy(Transaction::getCurrency));
}
