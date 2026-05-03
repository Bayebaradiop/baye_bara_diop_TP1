package user_service.exo16;

import user_service.model.Transaction;
import java.util.function.Predicate;

public class Exo16 {
    public static final Predicate<Transaction> isXof = transaction ->
        "XOF".equals(transaction.getCurrency());

    public static final Predicate<Transaction> isPremium = transaction ->
        "PREMIUM".equals(transaction.getUserType());

    public static final Predicate<Transaction> complexValidator = transaction ->
        (transaction.getAmount() > 0 && "XOF".equals(transaction.getCurrency())) ||
        "PREMIUM".equals(transaction.getUserType());
}
