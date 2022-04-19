package edu.mum.cs245.eregistrar.service;

import edu.mum.cs245.eregistrar.model.Student;

import java.util.List;

public interface StudentService {
    public abstract Student saveStudent(Student student);
    public abstract List<Student> getAllStudents();
    public abstract Student getStudentById(int id);
    public abstract void removeStudent(int id);
    public abstract Student updateStudent(int id, Student student);
}
