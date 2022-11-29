package com.cg.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.entity.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer>{

}
