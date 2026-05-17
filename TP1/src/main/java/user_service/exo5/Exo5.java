package user_service.exo5;


public class Exo5 {
    public static final Validator emailValidator = s ->
        s != null && s.contains("@");
}

