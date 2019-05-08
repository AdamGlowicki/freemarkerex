package repository;

import model.Student;

import javax.faces.bean.ApplicationScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class StudentRepository {

    private final List<Student> students;

    public StudentRepository() {
        final List<Student> students = new ArrayList<>();

        students.add(
                new Student(
                        1,
                        "heniek",
                        "warelich",
                        Arrays.asList(2,3,4,5),
                        true));
        students.add(
                new Student(
                        2,
                        "Jadzia",
                        "Zamojska",
                        Arrays.asList(2,3,3,3),
                        false));
        students.add(
                new Student(
                        3,
                        "Rysiek",
                        "Perliczka",
                        Arrays.asList(5,5,4,5),
                        true));

        this.students = students;
    }

    public Student getByID(Integer id) {
         return students.stream()
                .filter(students -> students.getId().equals(id))
                .findFirst()
                .get();
    }
}
