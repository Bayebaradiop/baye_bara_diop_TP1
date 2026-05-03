package user_service.exo10;

import user_service.model.User;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public class Exo10 {
    public static final Function<List<User>, Optional<User>> findAnyAdmin = users ->
        users.stream()
             .filter(user -> "ADMIN".equals(user.getRole()))
             .findAny();
}
