package user_service.exo6;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exo6 {
    public static final Function<List<String>, List<String>> filterFruitsStartingWithA = fruits ->
        fruits.stream()
              .filter(fruit -> fruit.startsWith("A"))
              .collect(Collectors.toList());
}
