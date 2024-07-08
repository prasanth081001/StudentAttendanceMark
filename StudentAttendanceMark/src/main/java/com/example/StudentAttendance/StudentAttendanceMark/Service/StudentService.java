package com.example.StudentAttendance.StudentAttendanceMark.Service;


import com.example.StudentAttendance.StudentAttendanceMark.Entity.Student;
import com.example.StudentAttendance.StudentAttendanceMark.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
     @Autowired
    private StudentRepository studentRepository;

     public List <Student> getAllStudents() {
         return studentRepository.findAll() ;
     }

     public void saveStudent(Student student){
         studentRepository.save(student);
     }
     public Student getStudentById(long id){
       return  studentRepository.findById(id).orElse(null) ;
     }

     public void deleteStudentById(long id){
         studentRepository.deleteById(id) ;
     }



}
