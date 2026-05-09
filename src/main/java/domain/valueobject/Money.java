package domain.valueobject;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Objects;

public record Money(BigDecimal amount, String currency) {

    public Money {
        Objects.requireNonNull(amount, "Le montant est obligatoire");
        Objects.requireNonNull(currency, "La devise est obligatoire");

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Le montant doit etre strictement positif");
        }

        amount = amount.stripTrailingZeros();
        currency = currency.strip().toUpperCase(Locale.ROOT);

        if (currency.isBlank()) {
            throw new IllegalArgumentException("La devise ne doit pas etre vide");
        }
    }

    public Money add(Money other) {
        Objects.requireNonNull(other, "Le montant a ajouter est obligatoire");

        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException("Les devises doivent etre identiques");
        }

        return new Money(amount.add(other.amount), currency);
    }
}
