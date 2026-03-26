package hei.school.TD4.service;

import hei.school.TD4.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void addStudents(List<Student> newStudents) {
        students.addAll(newStudents);
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
