package com.accolite.demo.controller;
 
 
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.accolite.demo.model.Student;
 
@Service("studentService")
public class StudentService{
     
    private static final AtomicLong counter = new AtomicLong();
     
    private static List<Student> masterStudents;
     
    static{
        masterStudents= populateDummyStudent();
    }
 
    public List<Student> findAllStudent() {
        return masterStudents;
    }
     
    public Student findByRollno(long rollNo) {
        for(Student student : masterStudents){
            if(student.getRollNo() == rollNo){
                return student;
            }
        }
        return null;
    }
     
    public Student findByName(String name) {
        for(Student student : masterStudents){
            if(student.getName().equalsIgnoreCase(name)){
                return student;
            }
        }
        return null;
    }
     
    public void saveStudent(Student student) {
        student.setRollNo(counter.incrementAndGet());
        masterStudents.add(student);
    }
 
    public void updateStudent(Student student) {
        int index = masterStudents.indexOf(student);
        masterStudents.set(index, student);
    }
 
    public void deleteStudentByRollno(long rollNo) {
         
        for (Iterator<Student> iterator = masterStudents.iterator(); iterator.hasNext(); ) {
            Student student = iterator.next();
            if (student.getRollNo() == rollNo) {
                iterator.remove();
            }
        }
    }
 
    public boolean isStudentExist(Student student) {
        return findByName(student.getName())!=null;
    }
 
    private static List<Student> populateDummyStudent(){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(counter.incrementAndGet(), "Prashant", new Date(1990+1900, 11, 28)));
        students.add(new Student(counter.incrementAndGet(), "Sagar", new Date(1990+1900, 10, 28)));
        students.add(new Student(counter.incrementAndGet(), "Teju", new Date(1990+1900, 9, 28)));
        students.add(new Student(counter.incrementAndGet(), "Mayra", new Date(1990+1900, 8, 28)));
        return students;
    }
 
    public void deleteAllStudent() {
        masterStudents.clear();
    }
 
}