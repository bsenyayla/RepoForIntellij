package edu.mum.cs245.eregistrar.repository;


import edu.mum.cs245.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
