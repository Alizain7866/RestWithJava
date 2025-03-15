package com.example.student_crud.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.student_crud.entity.StudentEntry;
import com.example.student_crud.repository.StudentEntryRepository;

@SpringBootTest
public class StudentServiceTest 
{
    @Autowired
    private StudentEntryRepository StudentEntryRepository;
    @Disabled
    @Test
    public void testFindAll()
    {
        assertEquals(4, 2+2);
        assertNotNull(StudentEntryRepository.findAll());

    }

    @Disabled
    @Test
    public void testContent()
    {
        assertNotNull(StudentEntryRepository.findById(new ObjectId("67d0bcf95bd15e5edf87a291")));
        // assertTrue(StudentEntryRepository.deleteById(new ObjectId("67d0be145bd15e5edf87a292")));
        StudentEntry studentEntry = StudentEntryRepository.findById(new ObjectId("67d0bcf95bd15e5edf87a291")).orElse(null);
        assertTrue(!studentEntry.getContent().isEmpty(),"Content is empty");        
    }

    @ParameterizedTest
    @CsvSource({
        "1,2,3",
        "2,3,5",
        "3,4,7"})
    public void test(int a, int b, int expected)
    {
        assertEquals(expected,a+b, "Failed for "+a+" "+b);
    }


    

}
