package com.traineeApp.dao;

import com.traineeApp.dto.Trainee;

public interface TraineeDao {
    Trainee addTrainee(Trainee trainee) throws DaoException;
    
    Trainee findTraineeById(int traineeId) throws DaoException;
}