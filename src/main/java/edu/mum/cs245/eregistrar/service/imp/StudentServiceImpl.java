package edu.mum.cs245.eregistrar.service.imp;

import edu.mum.cs245.eregistrar.model.Student;
import edu.mum.cs245.eregistrar.repository.StudentRepository;
import edu.mum.cs245.eregistrar.service.StudentService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    public StudentRepository studentRepository;


    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        studentRepository.findById(student.getStudentId()).orElse(null);
        return  studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll(Sort.by("firstName"));
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void removeStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(int id, Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            return studentRepository.save(student);
        }
        return student;
    }
}
