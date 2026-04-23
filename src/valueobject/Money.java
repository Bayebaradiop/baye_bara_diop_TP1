package valueobject;

import java.math.BigDecimal;
import exception.InvalideCurrencyException;

public record Money(BigDecimal amount, String currency) {

    public Money {

        // 1. vérifier montant
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Montant invalide");
        }

        // 2. vérifier devise
        if (currency == null ||
                (!currency.equals("EUR") && !currency.equals("FCFA"))) {
            throw new InvalideCurrencyException("Devise invalide: " + currency);
        }
    }

    // addition
    public Money add(Money other) {

        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Devises différentes");
        }

        return new Money(
                this.amount.add(other.amount),
                this.currency
        );
    }
}