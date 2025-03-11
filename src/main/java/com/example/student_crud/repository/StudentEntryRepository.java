package com.example.student_crud.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.student_crud.entity.StudentEntry;

public interface StudentEntryRepository extends MongoRepository<StudentEntry, ObjectId>
{

    
}
