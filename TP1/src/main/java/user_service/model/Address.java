package user_service.model;

/**
 * Classe Address pour l'exercice 15
 */
public class Address {
    private String street;

    public Address(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return "Address{street='" + street + "'}";
    }
}
