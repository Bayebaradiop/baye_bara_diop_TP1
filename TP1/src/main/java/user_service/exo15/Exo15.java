package user_service.exo15;

import user_service.model.User;
import java.util.function.Function;


public class Exo15 {
    public static final Function<User, String> getStreetName = user ->
        java.util.Optional.ofNullable(user)
                         .map(User::getAddress)
                         .map(address -> address.getStreet())
                         .orElse("Rue inconnue");
}
