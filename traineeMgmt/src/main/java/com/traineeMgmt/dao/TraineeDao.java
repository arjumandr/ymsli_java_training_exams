package com.traineeMgmt.dao;

import com.traineeMgmt.entities.Trainee;

public interface TraineeDao {
    public void addTrainee(Trainee trainee);
    public Trainee findById(Integer traineeId);
}
