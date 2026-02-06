package com.traineeMgmt.dao.jpa;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.traineeMgmt.dao.TraineeDao;
import com.traineeMgmt.entities.Trainee;
import com.traineeMgmt.exception.TraineeDataAccessException;
import com.traineeMgmt.exception.TraineeNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;

@Repository
@ConditionalOnProperty(name = "trainee.dao.type", havingValue = "jpa")
//@ConditionalOnProperty(
//	    name = "trainee.dao.type",
//	    havingValue = "jpa"
//	)
//@Primary
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
        }catch(EmptyResultDataAccessException e) {
        	throw new TraineeNotFoundException("Trainee with this Id not found.");
        } catch (PersistenceException e) {
            throw new TraineeDataAccessException("Error finding trainee", e);
        }
    }
}
