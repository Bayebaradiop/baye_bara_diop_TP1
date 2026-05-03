package user_service.exo8;

import java.util.List;
import java.util.function.ToIntFunction;

/**
 * Exercice 8 : Calcul d'agrégation
 * Fonction qui calcule la somme des prix supérieurs à 100.
 */
public class Exo8 {
    public static final ToIntFunction<List<Integer>> sumPricesAbove100 = prices ->
        prices.stream()
              .filter(price -> price > 100)
              .mapToInt(Integer::intValue)
              .sum();
}
