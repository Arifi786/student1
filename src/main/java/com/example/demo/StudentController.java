package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("StudentEntry")
public class StudentController {
    @Autowired
     StudentService SService;

    @GetMapping("AllEntries")
    public List<StudentEntity> getAllPersons() {
        return SService.getAllPersons();
    }

    @GetMapping("get//{id}")
    public Optional<StudentEntity> getPersonById(@PathVariable int id) {
        return SService.getPersonById(id);
    }

    @PostMapping("NewEntry")
    public StudentEntity savePerson(@RequestBody StudentEntity person) {
        return SService.savePerson(person);
    }

    @DeleteMapping("delete//{id}")
    public void deletePerson(@PathVariable int id) {
        SService.deletePerson(id);
    }
    @PutMapping("Update//{id}")
    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody StudentEntity updatedStudent) {
        try {
            SService.updateStudent(id, updatedStudent);
            return ResponseEntity.ok("Student updated successfully");
        } catch (Exception e) {
            // Handle exceptions, e.g., student not found
            return ResponseEntity.status(404).body("Error updating student: " + e.getMessage());
        }
    }
}
