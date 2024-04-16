package com.studentassign.controller;

import com.fasterxml.jackson.databind.node.ValueNode;
import com.studentassign.entity.StudentEntity;
import com.studentassign.repository.StudentRepo;
import com.studentassign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    StudentService studentService;
    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public List<StudentEntity> getStudents(){
        return studentRepo.findAll();
    }
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public StudentEntity createStudent(@RequestBody StudentEntity studentEntity){
        return studentRepo.save(studentEntity);
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public StudentEntity getStudentById(@PathVariable("id") Long id){
       return studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student with ID not found"));
    }
@RequestMapping(value = "/deleteById/{id}",method = RequestMethod.DELETE)
    public StudentEntity deleteStudent(@PathVariable("id") Long id){
    StudentEntity objOfStudent=  getStudentById(id);
        studentRepo.deleteById(id);
        return objOfStudent;
    }
@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public StudentEntity updateStudent(@RequestBody StudentEntity studentEntity,@PathVariable("id") Long id){
      Boolean result= studentService.checkId(id,studentEntity);
      if(!result){
          System.out.println("not present id");
      }
          studentEntity.setId(id);
          return studentRepo.save(studentEntity);
    }
}
