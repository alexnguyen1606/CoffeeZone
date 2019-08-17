package com.CoffeeZone.controller;

import com.CoffeeZone.entity.Student;
import com.CoffeeZone.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller

public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping( value = {"/student","/student/student"})
    public String Student(Model model){
        ArrayList<Student> listStudent =  studentService.findALl();
        model.addAttribute("listStudent",listStudent);
        return "student";
    }
    @GetMapping("/student/new")
    public String New(Model model){
        if(!model.containsAttribute("student")){
        model.addAttribute("student" ,new Student());
        model.addAttribute("method","POST");}
        return "saveStudent";
    }
    @PostMapping("/student")
    public String Save(@ModelAttribute("student") @Valid Student student, BindingResult result,Model model){
        studentService.Save(student);
        model.addAttribute("student",student);
        return "studentDetail";
    }
    @GetMapping("/student/delete")
    public RedirectView delete(@RequestParam("id") int id, Model model){
        studentService.Delete(id);
        return new RedirectView("student");
    }
    @GetMapping("/student/update")
    public String update(@RequestParam("id") int id ,Model model){
        model.addAttribute("student",studentService.getOne(id));
        model.addAttribute("method","PUT");
        return "saveStudent";
    }
    @PutMapping("/student")
    public String Update(@ModelAttribute("student") @Valid Student student,BindingResult result,Model model){
        studentService.Save(student);
        model.addAttribute("student",student);
        return "studentDetail";
    }
    @GetMapping("/student/{id}")
        public String Detail(@PathVariable("id") int id,Model model) {
        model.addAttribute("student",studentService.getOne(id));
        return "studentDetail";
    }
}
