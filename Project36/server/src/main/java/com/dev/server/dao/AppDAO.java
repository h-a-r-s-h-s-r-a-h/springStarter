package com.dev.server.dao;

import com.dev.server.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);
}
