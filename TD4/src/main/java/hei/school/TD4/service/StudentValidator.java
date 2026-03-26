package hei.school.TD4.service;

import hei.school.TD4.entity.Student;
import hei.school.TD4.exception.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentValidator {
    public void validateStudents(List<Student> students) {
        for (Student s : students) {
            if (s.getReference() == null || s.getReference().isBlank()) {
                throw new BadRequestException("La référence de l'étudiant ne peut pas être vide.");
            }
            if (s.getFirstName() == null || s.getFirstName().isBlank()) {
                throw new BadRequestException("Le prénom de l'étudiant ne peut pas être vide.");
            }
            if (s.getLastName() == null || s.getLastName().isBlank()) {
                throw new BadRequestException("Le nom de l'étudiant ne peut pas être vide.");
            }
            if (s.getAge() <= 0) {
                throw new BadRequestException("L'âge doit être un nombre positif.");
            }
        }
    }
}
