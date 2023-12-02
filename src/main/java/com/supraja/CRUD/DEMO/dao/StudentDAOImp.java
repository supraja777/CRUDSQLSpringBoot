package com.supraja.CRUD.DEMO.dao;

import com.supraja.CRUD.DEMO.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImp implements StudentDAO{

    //Define field for entity manager
    private EntityManager entityManager;

    //Create constructor for entity manager
    @Autowired
    public StudentDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Create save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer studentId) { return entityManager.find(Student.class, studentId);}

    @Override
    public List<Student> findAllStudents () {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findStudentByLastName (String last_name) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName = :lastName", Student.class);
        theQuery.setParameter("lastName", last_name);
        return theQuery.getResultList();

    }
}
