package user_service.exo17;

import user_service.model.User;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exo17 {
    private static final UserRepository repository = new UserRepository();

    public static final Function<List<String>, List<User>> findExistingUsers = ids ->
        ids.stream()
           .map(repository::findById)
           .filter(Optional::isPresent)
           .map(Optional::get)
           .collect(Collectors.toList());
}
