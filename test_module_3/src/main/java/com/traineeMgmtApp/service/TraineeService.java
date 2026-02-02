package com.traineeMgmtApp.service;

import java.util.Optional;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import com.traineeMgmtApp.dao.TraineeDao;
import com.traineeMgmtApp.dto.Trainee;

@Service

public class TraineeService {
	private final TraineeDao traineeRepo;

	public TraineeService(TraineeDao traineeRepo) {
		this.traineeRepo = traineeRepo;
	    System.out.println("Using DAO implementation: " + traineeRepo.getClass().getName());
	}
	public Trainee addTrainee(Trainee trainee) {
		return traineeRepo.addTrainee(trainee);
	}
	public Optional<Trainee> findById(int traineeId) {
		return traineeRepo.findById(traineeId);
	}
}
