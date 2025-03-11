package com.example.student_crud.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.student_crud.entity.StudentEntry;
import com.example.student_crud.service.StudentEntryService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired StudentEntryService StudentEntryService;


    @GetMapping("/abc")
    public List<StudentEntry> getAll()
    {
        return StudentEntryService.getAll();
    }

    @PostMapping("/create")
    public StudentEntry createEntry(@RequestBody StudentEntry entity) 
    {
        entity.setDate(LocalDateTime.now());
        StudentEntryService.saveEntry(entity);
        return entity;

    }
    

    @GetMapping("id/{myId}")
    public StudentEntry getStudentEntryById(@PathVariable ObjectId myId) 
    {
        return StudentEntryService.FindbyId(myId).orElse(null);
    }


    @DeleteMapping("id/{myId}")
    public boolean deleteStudentEntryById(@PathVariable ObjectId myId)
    {
        StudentEntryService.DeletebyId(myId);
        return true;
    }
    
    @PutMapping("update/{id}")
    public StudentEntry putStudentEntryById(@PathVariable ObjectId id, @RequestBody StudentEntry entity)
    {
        StudentEntry old=StudentEntryService.FindbyId(id).orElse(null);
        if(old !=null)
        {
            old.setTitle(entity.getTitle() !=null && !entity.getTitle().equals("") ? entity.getTitle():old.getTitle());
            old.setContent(entity.getContent() != null && !entity.getTitle().equals("") ? entity.getContent():old.getContent());

        }
        StudentEntryService.saveEntry(entity);
        return old;
    }


}
