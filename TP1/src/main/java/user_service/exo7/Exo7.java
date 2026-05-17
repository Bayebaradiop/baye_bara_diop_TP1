package user_service.exo7;

import user_service.model.User;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exo7 {
    public static final Function<List<User>, List<String>> extractEmails = users ->
        users.stream()
             .map(User::getEmail)
             .collect(Collectors.toList());
}
