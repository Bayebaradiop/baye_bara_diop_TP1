package domain.entity;

import domain.valueobject.Money;
import domain.valueobject.PhoneNumber;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

public class Account {

    private final UUID id;
    private final PhoneNumber phoneNumber;
    private final String devise;
    private BigDecimal solde;

    public Account(UUID id, PhoneNumber phoneNumber, Money soldeInitial) {
        this.id = Objects.requireNonNull(id, "L'identifiant est obligatoire");
        this.phoneNumber = Objects.requireNonNull(phoneNumber, "Le numero de telephone est obligatoire");
        Objects.requireNonNull(soldeInitial, "Le solde initial est obligatoire");
        this.devise = soldeInitial.currency();
        this.solde = soldeInitial.amount();
    }

    public Account(UUID id, PhoneNumber phoneNumber, String devise) {
        this.id = Objects.requireNonNull(id, "L'identifiant est obligatoire");
        this.phoneNumber = Objects.requireNonNull(phoneNumber, "Le numero de telephone est obligatoire");
        Objects.requireNonNull(devise, "La devise est obligatoire");

        devise = devise.strip().toUpperCase(Locale.ROOT);

        if (devise.isBlank()) {
            throw new IllegalArgumentException("La devise ne doit pas etre vide");
        }

        this.devise = devise;
        this.solde = BigDecimal.ZERO;
    }

    public UUID id() {
        return id;
    }

    public PhoneNumber phoneNumber() {
        return phoneNumber;
    }

    public BigDecimal solde() {
        return solde;
    }

    public String devise() {
        return devise;
    }

    public void crediter(Money montant) {
        Objects.requireNonNull(montant, "Le montant a crediter est obligatoire");
        verifierDevise(montant);
        solde = solde.add(montant.amount());
    }

    public void debiter(Money montant) {
        Objects.requireNonNull(montant, "Le montant a debiter est obligatoire");
        verifierDevise(montant);

        if (solde.compareTo(montant.amount()) < 0) {
            throw new IllegalArgumentException("Solde insuffisant");
        }

        solde = solde.subtract(montant.amount());
    }

    public void transfererVers(Account destinataire, Money montant) {
        Objects.requireNonNull(destinataire, "Le compte destinataire est obligatoire");
        Objects.requireNonNull(montant, "Le montant a transferer est obligatoire");

        if (id.equals(destinataire.id)) {
            throw new IllegalArgumentException("Impossible de transferer vers le meme compte");
        }

        verifierDevise(montant);
        destinataire.verifierDevise(montant);

        debiter(montant);
        destinataire.crediter(montant);
    }

    private void verifierDevise(Money montant) {
        if (!devise.equals(montant.currency())) {
            throw new IllegalArgumentException("Les devises doivent etre identiques");
        }
    }
}
