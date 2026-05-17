package user_service.exo2;

import java.util.function.Consumer;


public class Exo2 {
    public static final Consumer<String> logger = chaine ->
        System.out.println("LOG-" + chaine.toUpperCase());
}
