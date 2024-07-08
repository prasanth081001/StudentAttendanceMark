package com.example.StudentAttendance.StudentAttendanceMark.Controller;

import com.example.StudentAttendance.StudentAttendanceMark.Entity.Student;
import com.example.StudentAttendance.StudentAttendanceMark.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listStudents",studentService.getAllStudents());
        return "index";
    }
    @GetMapping("/newStudentForm")
    public String NewStudentForm(Model model){
        Student student=new Student() ;
        model.addAttribute("student",student);
        return "new_student" ;
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student")Student student) {

        student.setDate(LocalDate.now());
        studentService.saveStudent(student) ;
        return "redirect:/" ;
    }
    @GetMapping("/updateForm/{id}")
    public String FormForUpdate(@PathVariable(value = "id")long id,Model model){
        Student student=studentService.getStudentById(id);
        model.addAttribute("student",student) ;
        return "update_student" ;
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id")long id){
        studentService.deleteStudentById(id);
        return "redirect:/" ;
    }

}
