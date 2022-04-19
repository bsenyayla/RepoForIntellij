package edu.mum.cs245.eregistrar.controller;

import edu.mum.cs245.eregistrar.model.Classroom;
import edu.mum.cs245.eregistrar.model.Course;
import edu.mum.cs245.eregistrar.model.Student;
import edu.mum.cs245.eregistrar.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = {"/student"})
public class StudentPageController {

    private StudentService studentService;

    StudentPageController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(value = "")
    public ModelAndView displayStudentPage() {
        var modelAndView = new ModelAndView();
        var students = studentService.getAllStudents();
        System.out.println("------------------------ Student----------------");
        modelAndView.addObject("students",students);
        modelAndView.addObject("studentsCount", ((List)students).size());
        modelAndView.setViewName("secure/student/student");
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public String getStudent(Model model) {
        model.addAttribute("student", new Student(null, null, null,null,0,null));
        return "secure/student/new";
    }

    @PostMapping(value = {"/new"})
    public String registerNewPublisher(@Valid @ModelAttribute("student") Student student,
                                       BindingResult bindingResult, Model model) {

        System.out.println("----------------- tttt -----------------");
        Course c1 = new Course(1,"SA", "CS570", 4.0f);
        Classroom cr1 = new Classroom(1,"McLaughlin building", "M105");
        student.setStudentId(6);
        student.setClassroom(cr1);
        student.addCourses(List.of(c1));
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secure/student/new";
        }
        studentService.saveStudent(student);

        System.out.println("----------------- tttt aaaaaaaa-----------------");
        return "redirect:/";
    }


    @GetMapping(value = {"/edit/{studentId}"})
    public String editStudent(@PathVariable Integer studentId, Model model) {
        var student = studentService.getStudentById(studentId);
        if(student != null) {
            model.addAttribute("student", student);
            return "secure/student/edit";
        }
        return "redirect:/";
    }

    @PostMapping(value = {"/update"})
    public String updatePublisher(@Valid @ModelAttribute("student") Student student,
                                  BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secure/student/edit";
        }
        studentService.updateStudent(student.getStudentId(),student);
        return "redirect:/student";
    }

    @GetMapping(value = {"/delete/{studentId}"})
    public String deleteStudent(@PathVariable Integer studentId) {
        studentService.removeStudent(studentId);
        return "redirect:/student";
    }
}
