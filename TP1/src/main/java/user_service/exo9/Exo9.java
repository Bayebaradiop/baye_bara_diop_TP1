package user_service.exo9;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Exo9 {
    public static final Function<List<String>, List<String>> getUniqueSortedNames = names ->
        names.stream()
             .distinct()
             .sorted()
             .collect(Collectors.toList());
}
