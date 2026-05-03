package user_service.exo18;

import user_service.model.Employee;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Exo18 {
    public static final Function<List<String>, List<Employee>> parseCsvEmployees = csvLines ->
        csvLines.stream()
                .map(line -> {
                    try {
                        String[] parts = line.split(";");
                        if (parts.length != 3) return null;
                        String name = parts[0].trim();
                        int age = Integer.parseInt(parts[1].trim());
                        double salary = Double.parseDouble(parts[2].trim());
                        return new Employee(name, age, salary);
                    } catch (Exception e) {
                        return null; // Ignore les lignes corrompues
                    }
                })
                .filter(employee -> employee != null)
                .collect(Collectors.toList());
}
