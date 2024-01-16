package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
      StudentRepo Srepo;
   StudentService(StudentRepo Srepo)
   {
       this.Srepo=Srepo;
   }
    public List<StudentEntity> getAllPersons() {
        return Srepo.findAll();
    }

    public Optional<StudentEntity> getPersonById(int id) {
        return Srepo.findById(id);
    }

    public StudentEntity savePerson(StudentEntity person) {
        return  Srepo.save(person);
    }

    public void deletePerson(int id) {
        Srepo.deleteById(id);
    }
    public void updateStudent(int studentId, StudentEntity updatedStudent) {
        // Step 1: Retrieve the existing student
        Optional<StudentEntity> existingStudentOptional = Srepo.findById(studentId);

        if (existingStudentOptional.isPresent()) {
            // Step 2: Modify the existing student
            StudentEntity existingStudent = existingStudentOptional.get();
            existingStudent.setFirstName(updatedStudent.getFirstName());
            existingStudent.setLastName(updatedStudent.getLastName());
            existingStudent.setRoll(updatedStudent.getRoll());
            existingStudent.setCourse(updatedStudent.getCourse());
            existingStudent.setSemester(updatedStudent.getSemester());

            // Step 3: Save the updated student
            Srepo.save(existingStudent);
        } else {
            // Handle the case where the student with the given ID is not found
            // You can throw an exception, return an error message, etc.
        }
    }
}
