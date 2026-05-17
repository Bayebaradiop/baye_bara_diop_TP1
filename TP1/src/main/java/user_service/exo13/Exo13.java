package user_service.exo13;

import user_service.model.Student;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Exo13 {
    public static final Function<List<Student>, Map<Boolean, List<Student>>> partitionByGrade = students ->
        students.stream()
                .collect(Collectors.partitioningBy(student -> student.getGrade() >= 10));
}
