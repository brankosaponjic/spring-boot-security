package brankosaponjic.springbootsecurity.controller;

import brankosaponjic.springbootsecurity.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Paolo Rossi"),
            new Student(2, "Bruno Conti"),
            new Student(3, "Marco Tardelli")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudents(@PathVariable Integer studentId) {
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exists."));
    }
}
