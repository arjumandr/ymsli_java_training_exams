package com.traineeApp.controller;

import com.traineeApp.dao.DaoException;
import com.traineeApp.dao.TraineeDao;
import com.traineeApp.dao.TraineeDaoHibImpl;
import com.traineeApp.dto.Trainee;

public class TraineeAppHibController {
	public static void main(String[] args) {

		TraineeDao traineeDao = new TraineeDaoHibImpl();
		
		Trainee trainee = new Trainee("AR R", "Node.js", 20);
		try {
			trainee = traineeDao.addTrainee(trainee);
		} catch (DaoException e) {
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
		Trainee t2;
		try {
			t2 = traineeDao.findTraineeById(12);
			System.out.println(t2);
		} catch (DaoException e) {
			e.printStackTrace();
		}

		Trainee t3 = new Trainee("LMN", "Angular", 62);
		// this trainee is not yet in the db
		System.out.println("=======================");
		Trainee t4;
		try {
			t4 = traineeDao.findTraineeById(t3.getTrainee_id());
			System.out.println(t4);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
}
