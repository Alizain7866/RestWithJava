package com.example.student_crud.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.student_crud.entity.StudentEntry;
import com.example.student_crud.repository.StudentEntryRepository;

import ch.qos.logback.core.joran.spi.NoAutoStart;

@Component
public class StudentEntryService 
{

    @Autowired
    private StudentEntryRepository StudentEntryRepository; //DI

    public void saveEntry(StudentEntry entity)
    {
        StudentEntryRepository.save(entity);
    }

    public List<StudentEntry> getAll()
    {
        return StudentEntryRepository.findAll();
    }
    public Optional<StudentEntry> FindbyId(ObjectId objId)
    {
        return StudentEntryRepository.findById(objId);
    }

    public void DeletebyId(ObjectId objId)
    {
         StudentEntryRepository.deleteById(objId);
    }
    


}


//controller --> service -->Repository --> Database