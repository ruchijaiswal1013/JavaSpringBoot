package com.studentassign.repository;

import com.studentassign.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<StudentEntity,Long> {

}
