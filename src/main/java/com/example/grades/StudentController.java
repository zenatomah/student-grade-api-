package com.example.grades;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
  
@RestController 
@RequestMapping("/api") 
public class StudentController { 
 private List<Student> students = new ArrayList<>(List.of( 
        new Student(1L, "Ahmed", "SE4111", 95.0), 
        new Student(2L, "Sara",  "SE4111", 88.5) 
    )); 
private static final Logger logger = 
LoggerFactory.getLogger(StudentController.class); 

 @GetMapping("/students") 
    public List<Student> getAll() { 
        return students; 
    } 
  
    @GetMapping("/students/{id}") 
    public Student getById(@PathVariable Long id) { 
        return students.stream() 
            .filter(s -> s.getId().equals(id)) 
            .findFirst() 
            .orElse(null); 
    } 
   
 
 @PostMapping("/students") 
    public Student add(@RequestBody Student s) { 
        s.setId((long) (students.size() + 1)); 
        students.add(s); 
        return s; 
    } 
}