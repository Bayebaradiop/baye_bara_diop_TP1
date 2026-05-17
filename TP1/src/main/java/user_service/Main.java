package user_service;

import user_service.exo1.Exo1;
import user_service.exo2.Exo2;
import user_service.Exo3.Exo3;
import user_service.exo4.Exo4;
import user_service.exo5.Exo5;
import user_service.exo6.Exo6;
import user_service.exo7.Exo7;
import user_service.exo8.Exo8;
import user_service.exo9.Exo9;
import user_service.exo10.Exo10;
import user_service.exo11.Exo11;
import user_service.exo12.Exo12;
import user_service.exo13.Exo13;
import user_service.exo14.Exo14;
import user_service.exo15.Exo15;
import user_service.exo16.Exo16;
import user_service.exo17.Exo17;
import user_service.exo18.Exo18;
import user_service.model.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.DoubleSummaryStatistics;

public class Main {
    public static void main(String[] args) {
        System.out.println("TP1 - Prédicats et Expressions Lambda");
        System.out.println("=====================================\n");

        // Tests Exercice 1
        System.out.println("=== Exercice 1 : Le Prédicat Simple ===");
        System.out.println("isPositive.test(5): " + Exo1.isPositive.test(5));
        System.out.println("isPositive.test(0): " + Exo1.isPositive.test(0));
        System.out.println("isPositive.test(-3): " + Exo1.isPositive.test(-3));


        // Tests Exercice 2
        System.out.println("\n=== Exercice 2 : Le Consommateur ===");
        Exo2.logger.accept("hello world");
        Exo2.logger.accept("java");
        Exo2.logger.accept("consumer");


        // Tests Exercice 3
        System.out.println("\n=== Exercice 3 : La Transformation (Function) ===");
        System.out.println("doubleValue.apply(\"10\"): " + Exo3.doubleValue.apply("10"));
        System.out.println("doubleValue.apply(\"5\"): " + Exo3.doubleValue.apply("5"));
        System.out.println("doubleValue.apply(\"0\"): " + Exo3.doubleValue.apply("0"));



        // Tests Exercice 4
        System.out.println("\n=== Exercice 4 : Le Fournisseur (Supplier) ===");
        System.out.println("Taux d'intérêt aléatoire 1: " + Exo4.interestRateSupplier.get() + "%");
        System.out.println("Taux d'intérêt aléatoire 2: " + Exo4.interestRateSupplier.get() + "%");
        System.out.println("Taux d'intérêt aléatoire 3: " + Exo4.interestRateSupplier.get() + "%");


        // Tests Exercice 5
        System.out.println("\n=== Exercice 5 : Interface Personnalisée ===");
        System.out.println("emailValidator.validate(\"user@example.com\"): " + Exo5.emailValidator.validate("user@example.com"));
        System.out.println("emailValidator.validate(\"invalid-email\"): " + Exo5.emailValidator.validate("invalid-email"));
        System.out.println("emailValidator.validate(null): " + Exo5.emailValidator.validate(null));


        // Tests Exercice 6
        System.out.println("\n=== Exercice 6 : Filtrage simple ===");
        List<String> fruits = List.of("Apple", "Banana", "Apricot", "Orange", "Avocado", "Grape");
        List<String> result = Exo6.filterFruitsStartingWithA.apply(fruits);
        System.out.println("Fruits originaux: " + fruits);
        System.out.println("Fruits commençant par 'A': " + result);


        // Tests Exercice 7
        System.out.println("\n=== Exercice 7 : Extraction de données ===");
        List<User> users = List.of(
            new User("Alice", "alice@example.com", "USER"),
            new User("Bob", "bob@example.com", "ADMIN"),
            new User("Charlie", "charlie@example.com", "USER")
        );
        List<String> emails = Exo7.extractEmails.apply(users);
        System.out.println("Utilisateurs: " + users);
        System.out.println("Emails extraits: " + emails);



        // Tests Exercice 8
        System.out.println("\n=== Exercice 8 : Calcul d'agrégation ===");
        List<Integer> prices = List.of(50, 120, 80, 150, 90, 200);
        int total = Exo8.sumPricesAbove100.applyAsInt(prices);
        System.out.println("Prix: " + prices);
        System.out.println("Somme des prix > 100: " + total);


        // Tests Exercice 9
        System.out.println("\n=== Exercice 9 : Unicité et Tri ===");
        List<String> names = List.of("Charlie", "Alice", "Bob", "Alice", "David", "Bob");
        List<String> uniqueNames = Exo9.getUniqueSortedNames.apply(names);
        System.out.println("Noms originaux: " + names);
        System.out.println("Noms uniques triés: " + uniqueNames);

        // Tests Exercice 10
        System.out.println("\n=== Exercice 10 : Recherche ciblée ===");
        Optional<User> admin = Exo10.findAnyAdmin.apply(users);
        System.out.println("Recherche d'un admin: " + admin.orElse(null));

        // Tests Exercice 11
        System.out.println("\n=== Exercice 11 : Groupement de données ===");
        List<Transaction> transactions = List.of(
            new Transaction(100.0, "EUR", "STANDARD"),
            new Transaction(200.0, "XOF", "PREMIUM"),
            new Transaction(150.0, "EUR", "STANDARD"),
            new Transaction(300.0, "USD", "PREMIUM")
        );
        Map<String, List<Transaction>> byCurrency = Exo11.groupByCurrency.apply(transactions);
        System.out.println("Transactions: " + transactions);
        System.out.println("Groupées par devise: " + byCurrency);

        // Tests Exercice 12
        System.out.println("\n=== Exercice 12 : Statistiques descriptives ===");
        List<Product> products = List.of(
            new Product("Laptop", 1200.0),
            new Product("Mouse", 25.0),
            new Product("Keyboard", 75.0),
            new Product("Monitor", 300.0)
        );
        DoubleSummaryStatistics stats = Exo12.getPriceStatistics.apply(products);
        System.out.println("Produits: " + products);
        System.out.println("Statistiques des prix: min=" + stats.getMin() +
                          ", max=" + stats.getMax() + ", moyenne=" + stats.getAverage());

        // Tests Exercice 13
        System.out.println("\n=== Exercice 13 : Partitionnement ===");
        List<Student> students = List.of(
            new Student("Alice", 12.5),
            new Student("Bob", 8.0),
            new Student("Charlie", 15.0),
            new Student("David", 9.5)
        );
        Map<Boolean, List<Student>> results = Exo13.partitionByGrade.apply(students);
        System.out.println("Étudiants: " + students);
        System.out.println("Note >= 10: " + results.get(true));
        System.out.println("Note < 10: " + results.get(false));

        // Tests Exercice 14
        System.out.println("\n=== Exercice 14 : Aplatissement (FlatMap) ===");
        List<Order> orders = List.of(
            new Order("ORD001", List.of(new Item("Laptop", 1), new Item("Mouse", 2))),
            new Order("ORD002", List.of(new Item("Keyboard", 1), new Item("Monitor", 1)))
        );
        List<Item> allItems = Exo14.flattenAllItems.apply(orders);
        System.out.println("Commandes: " + orders);
        System.out.println("Tous les articles: " + allItems);

        // Tests Exercice 15
        System.out.println("\n=== Exercice 15 : Chaînage sécurisé (Optional) ===");
        User userWithAddress = new User("Alice", "alice@example.com", "USER",
                                       new Address("123 Main St"));
        User userWithoutAddress = new User("Bob", "bob@example.com", "USER");
        String street1 = Exo15.getStreetName.apply(userWithAddress);
        String street2 = Exo15.getStreetName.apply(userWithoutAddress);
        String street3 = Exo15.getStreetName.apply(null);
        System.out.println("Utilisateur avec adresse: " + street1);
        System.out.println("Utilisateur sans adresse: " + street2);
        System.out.println("Utilisateur null: " + street3);

        // Tests Exercice 16
        System.out.println("\n=== Exercice 16 : Composition de Prédicats ===");
        Transaction tx1 = new Transaction(100.0, "XOF", "STANDARD");
        Transaction tx2 = new Transaction(-50.0, "EUR", "PREMIUM");
        Transaction tx3 = new Transaction(-20.0, "EUR", "STANDARD");
        System.out.println("Transaction 1 (100 XOF STANDARD): " + Exo16.complexValidator.test(tx1));
        System.out.println("Transaction 2 (-50 EUR PREMIUM): " + Exo16.complexValidator.test(tx2));
        System.out.println("Transaction 3 (-20 EUR STANDARD): " + Exo16.complexValidator.test(tx3));

        // Tests Exercice 17
        System.out.println("\n=== Exercice 17 : Nettoyage de flux (Optional + Stream) ===");
        List<String> ids = List.of("1", "4", "2", "5", "3");
        List<User> existingUsers = Exo17.findExistingUsers.apply(ids);
        System.out.println("IDs recherchés: " + ids);
        System.out.println("Utilisateurs trouvés: " + existingUsers);



        // Tests Exercice 18
        System.out.println("\n=== Exercice 18 : Challenge Final - L'Importateur Résilient ===");
        List<String> csvLines = Arrays.asList(
            "Alice;30;50000.0",
            "Bob;25;45000.0",
            "Charlie;abc;40000.0",
            "David;35",
            "Eve;28;55000.0"
        );
        List<Employee> employees = Exo18.parseCsvEmployees.apply(csvLines);
        System.out.println("Lignes CSV: " + csvLines);
        System.out.println("Employés parsés: " + employees);
        
    }
}