package hei.school.TD2.controlleur;

import hei.school.TD2.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentControlleur {
    private static List<Student> students = new ArrayList<>();

    @GetMapping("/welcome")
    public String welcome(@RequestParam String name) {
        return "Welcome " + name;
    }

    @PostMapping("/students")
    public String addStudents(@RequestBody List<Student> newStudents) {
        students.addAll(newStudents);

        StringBuilder result = new StringBuilder();
        for (Student s : students) {
            result.append(s.getFirstName()).append(" ").append(s.getLastName()).append("\n");
        }
        return result.toString();
    }

    @GetMapping("/students")
    public ResponseEntity<String> getStudents(@RequestHeader("Accept") String acceptHeader) {
        if ("text/plain".equals(acceptHeader)) {
            StringBuilder result = new StringBuilder();
            for (Student s : students) {
                result.append(s.getFirstName()).append(" ").append(s.getLastName()).append("\n");
            }
            return ResponseEntity.ok(result.toString());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Format non supporté. Seul text/plain est accepté.");
        }
    }
}
