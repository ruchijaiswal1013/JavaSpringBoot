package com.studentassign.service;

import com.studentassign.entity.StudentEntity;
import com.studentassign.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public Boolean checkId(Long id, StudentEntity studentEntity) {

        Optional<StudentEntity> student= studentRepo.findById(id);
        if (student.isEmpty()){
            return false;
        }else {
            return true;
        }


    }
}
