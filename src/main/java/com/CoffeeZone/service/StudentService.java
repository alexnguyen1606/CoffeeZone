package com.CoffeeZone.service;

import com.CoffeeZone.entity.Student;
import com.CoffeeZone.repository.StudentRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public ArrayList<Student> findALl(){
        return (ArrayList<Student>) studentRepository.findAll();
    }
    public Student Save(Student student){
        Student student1 = studentRepository.saveAndFlush(student);
        return student1;
    }
    public void Delete(int id){
        Student student =  studentRepository.getOne(id);

            studentRepository.delete(student);

    }
    public Student getOne(int id){
        return studentRepository.getOne(id);
    }
}
