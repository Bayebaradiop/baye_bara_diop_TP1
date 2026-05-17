package user_service.model;

/**
 * Classe User pour les exercices 7, 10, 15 et 17
 */
public class User {
    private String name;
    private String email;
    private String role;
    private Address address;

    public User(String name, String email, String role) {
        this(name, email, role, null);
    }

    public User(String name, String email, String role, Address address) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "', role='" + role + "', address=" + address + "}";
    }
}
