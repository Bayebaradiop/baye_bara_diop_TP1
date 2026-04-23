package valueobject;

public record SKU(String value) {

    public SKU {

        if (value == null || !value.matches("^[A-Z]{3}-\\d{4,6}$")) {
            throw new IllegalArgumentException("SKU invalide : " + value);
        }
    }
}