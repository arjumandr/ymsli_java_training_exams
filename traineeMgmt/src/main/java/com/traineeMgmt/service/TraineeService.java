package com.traineeMgmt.service;

import com.traineeMgmt.entities.Trainee;

public interface TraineeService {
	public void addTrainee(Trainee trainee);
	public Trainee findById(int id);
}
