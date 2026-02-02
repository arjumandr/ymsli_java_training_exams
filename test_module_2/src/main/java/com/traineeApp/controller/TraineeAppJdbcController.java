package com.traineeApp.controller;

import com.traineeApp.dao.DaoException;
import com.traineeApp.dao.PWrapperException;
import com.traineeApp.dao.TraineeDao;
import com.traineeApp.dao.TraineeDaoHibImpl;
import com.traineeApp.dto.Trainee;

public class TraineeAppJdbcController {
	
	public static void main(String[] args) {
		
		TraineeDao traineeDao = new TraineeDaoHibImpl();
		
//		TraineeDao traineeDao = new TraineeDaoJdbcImpl();
//		
//		Trainee trainee = new Trainee("AR", "Java", 50);
//		trainee = traineeDao.addTrainee(trainee);
		
		Trainee trainee2 = new Trainee("New Person", "full stack", 44.44);
		try {
			trainee2 = traineeDao.addTrainee(trainee2);
		} catch (DaoException e) {
			e.printStackTrace();
		} catch (PWrapperException e) {
			e.printStackTrace();
		}

		System.out.println("=======================");
		// trainee with id=1
		System.out.println("Trainee with id = 1");
		Trainee t1;
		try {
			t1 = traineeDao.findTraineeById(1);
			System.out.println(t1);
		} catch (DaoException e) {
			e.printStackTrace();
		}		

		System.out.println("=======================");
		System.out.println("Trainee with id = 12");
		try {
			Trainee t2 = traineeDao.findTraineeById(12);
			System.out.println(t2);
		} catch (DaoException e) {
			e.printStackTrace();
		}

		
		System.out.println("=======================");
		try {
			Trainee t4 = traineeDao.findTraineeById(trainee2.getTrainee_id());
			System.out.println(t4);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
	}

}
