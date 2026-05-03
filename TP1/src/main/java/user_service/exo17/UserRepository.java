package user_service.exo17;

import user_service.model.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class UserRepository {
    private static final Map<String, User> users = new HashMap<>();

    static {
        users.put("1", new User("Alice", "alice@example.com", "USER"));
        users.put("2", new User("Bob", "bob@example.com", "ADMIN"));
        users.put("3", new User("Charlie", "charlie@example.com", "USER"));
        // "4" n'existe pas pour tester
    }

    public Optional<User> findById(String id) {
        return Optional.ofNullable(users.get(id));
    }
}
