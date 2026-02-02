package com.traineeMgmt.dao.jpa;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.traineeMgmt.dao.TraineeDao;
import com.traineeMgmt.entities.Trainee;
import com.traineeMgmt.exception.TraineeDataAccessException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;

@Repository
@Primary
public class TraineeJpaDAO implements TraineeDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addTrainee(Trainee trainee) {
        try {
            em.persist(trainee);
        } catch (PersistenceException e) {
            throw new TraineeDataAccessException("Error adding trainee", e);
        }
    }

    @Override
    public Trainee findById(Integer id) {
        try {
            return em.find(Trainee.class, id);
        } catch (PersistenceException e) {
            throw new TraineeDataAccessException("Error finding trainee", e);
        }
    }
}
