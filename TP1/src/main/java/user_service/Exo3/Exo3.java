package user_service.Exo3;

import java.util.function.Function;


public class Exo3 {
    public static final Function<String, Integer> doubleValue = chaine ->
        Integer.parseInt(chaine) * 2;
}
