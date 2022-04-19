package edu.mum.cs245.eregistrar.service.imp;

import edu.mum.cs245.eregistrar.model.Classroom;
import edu.mum.cs245.eregistrar.repository.ClassroomRepository;
import edu.mum.cs245.eregistrar.service.ClassroomService;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private ClassroomRepository classroomRepository;

    ClassroomServiceImpl(ClassroomRepository classroomRepository){
        this.classroomRepository = classroomRepository;
    }

    @Override
    public Classroom addClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public Classroom getClassroomById(int id) {
        return classroomRepository.findById(id).orElse(null);
    }
}
