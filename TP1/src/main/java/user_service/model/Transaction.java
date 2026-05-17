package user_service.model;

/**
 * Classe Transaction pour les exercices 11 et 16
 */
public class Transaction {
    private double amount;
    private String currency;
    private String userType;

    public Transaction(double amount, String currency, String userType) {
        this.amount = amount;
        this.currency = currency;
        this.userType = userType;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return "Transaction{amount=" + amount + ", currency='" + currency + "', userType='" + userType + "'}";
    }
}
