package user_service.exo4;

import java.util.function.Supplier;


public class Exo4 {
    public static final Supplier<Double> interestRateSupplier = () ->
        Math.random() * 5.0;
}
