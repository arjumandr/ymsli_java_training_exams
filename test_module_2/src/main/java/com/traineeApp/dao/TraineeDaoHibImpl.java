package com.traineeApp.dao;

import com.traineeApp.dto.Trainee;
import com.traineeApp.util.EmFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class TraineeDaoHibImpl implements TraineeDao {

	private EntityManagerFactory entityManagerFactory;
	
	
	public TraineeDaoHibImpl() {
		entityManagerFactory=EmFactory.getEntityManagerFactory();
	}

	@Override
	public Trainee findTraineeById(int traineeId) throws PWrapperException{
		try {
	    EntityManager em = entityManagerFactory.createEntityManager();
	    Trainee trainee = em.find(Trainee.class, traineeId);
	    em.close();
	    return trainee;
		}
		catch (PersistenceException e) {
			throw new PWrapperException("Unable to find trainee with the id", e);
		}
	}

	@Override
	public Trainee addTrainee(Trainee trainee) throws PersistenceException{
		EntityManager em=entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(trainee);
			tx.commit();
		}catch(PersistenceException e) {
			throw new PWrapperException("Unable to find trainee with the id", e);
		}
		em.close();
		return trainee;
	}
}
