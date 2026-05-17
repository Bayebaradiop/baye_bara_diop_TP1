package app;

import domain.entity.Account;
import domain.valueobject.Money;
import domain.valueobject.PhoneNumber;
import java.math.BigDecimal;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Account alice = new Account(
                UUID.randomUUID(),
                new PhoneNumber("771234567"),
                new Money(new BigDecimal("50000"), "XOF"));

        Account bob = new Account(
                UUID.randomUUID(),
                new PhoneNumber("+221781234567"),
                new Money(new BigDecimal("5000"), "XOF"));

        alice.transfererVers(bob, new Money(new BigDecimal("15000"), "XOF"));

        System.out.println("Alice: " + alice.solde().toPlainString() + " " + alice.devise());
        System.out.println("Bob: " + bob.solde().toPlainString() + " " + bob.devise());

        testerEchec("Montant negatif", () -> new Money(new BigDecimal("-1000"), "XOF"));
        testerEchec("Devises differentes", () -> alice.transfererVers(bob, new Money(new BigDecimal("1000"), "EUR")));
        testerEchec("Solde insuffisant", () -> bob.debiter(new Money(new BigDecimal("100000"), "XOF")));
    }

    private static void testerEchec(String scenario, Runnable operation) {
        try {
            operation.run();
            System.out.println("[ECHEC] " + scenario);
        } catch (RuntimeException exception) {
            System.out.println("[OK] " + scenario + " -> " + exception.getMessage());
        }
    }
}
