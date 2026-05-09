package domain.valueobject;

import java.util.Objects;

public record PhoneNumber(String value) {

    private static final String SENEGAL_PHONE_REGEX = "^(?:\\+221)?(?:70|76|77|78)\\d{7}$";

    public PhoneNumber {
        Objects.requireNonNull(value, "Le numero de telephone est obligatoire");

        value = value.strip();

        if (!value.matches(SENEGAL_PHONE_REGEX)) {
            throw new IllegalArgumentException("Numero senegalais invalide");
        }
    }
}
