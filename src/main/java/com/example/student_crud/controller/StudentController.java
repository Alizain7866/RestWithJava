package com.example.student_crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.student_crud.entity.StudentEntry;

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

    private HashMap<Long, StudentEntry> studentEntries = new HashMap<>();

    @GetMapping("/abc")
    public List<StudentEntry> getAll()
    {
        return new ArrayList<>(studentEntries.values());
    }

    @PostMapping("/create")
    public boolean createEntry(@RequestBody StudentEntry entity) 
    {
        studentEntries.put(entity.getId(), entity);
        return true;
    }
    

    @GetMapping("id/{myId}")
    public StudentEntry getStudentEntryById(@PathVariable Long myId) {
        return studentEntries.get(myId);
    }


    @DeleteMapping("id/{myId}")
    public StudentEntry deleteStudentEntryById(@PathVariable Long myId)
    {
        return studentEntries.remove(myId);
    }
    
    @PutMapping("update/{id}")
    public StudentEntry putStudentEntryById(@PathVariable Long id, @RequestBody StudentEntry entity) {
        return studentEntries.put(id, entity);
    }


}
