package edu.mum.cs245.eregistrar.service;


import edu.mum.cs245.eregistrar.model.Classroom;

public interface ClassroomService {

    Classroom addClassroom(Classroom classroom);
    Classroom getClassroomById(int id);
}
