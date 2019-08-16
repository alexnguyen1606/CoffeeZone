package com.CoffeeZone.controller;

import com.CoffeeZone.entity.Student;
import com.CoffeeZone.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
        Student student = new Student();
        model.addAttribute("student" ,student);
        model.addAttribute("method","POST");
        return "saveStudent";
    }
    @PostMapping("/student")
    public RedirectView Save(@ModelAttribute("student") Student student,Model model){
        try {
            studentService.Save(student);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
      //  model.addAttribute("listStudent",studentService.findALl());
        return new RedirectView("student");
    }
    @GetMapping("/student/delete")
    public String delete(@RequestParam("id") int id, Model model){
       studentService.Delete(id);
        return "redirect:student";
    }
    @GetMapping("/student/detail")
    public String update(@RequestParam("id") int id ,Model model){
        model.addAttribute("student",studentService.getOne(id));
        model.addAttribute("method","POST");
        return "saveStudent";
    }
    @PutMapping("/student")
    public RedirectView Save(@ModelAttribute("student") Student student){
        try {
        studentService.Save(student);}
        catch (Exception e){
            System.out.println(e.toString());
        }
        return new RedirectView("student");
    }
}
