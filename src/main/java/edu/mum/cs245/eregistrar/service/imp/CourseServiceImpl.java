package edu.mum.cs245.eregistrar.service.imp;

import edu.mum.cs245.eregistrar.model.Course;
import edu.mum.cs245.eregistrar.repository.CourseRepository;
import edu.mum.cs245.eregistrar.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
}
