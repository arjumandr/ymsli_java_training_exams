package com.traineeMgmtApp.dao;

import java.util.Optional;

import com.traineeMgmtApp.dto.Trainee;

public interface TraineeDao {
	public Trainee addTrainee(Trainee trainee);
	public Optional<Trainee> findById(int traineeId);
}
