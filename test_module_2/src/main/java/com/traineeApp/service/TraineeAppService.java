package com.traineeApp.service;

import com.traineeApp.dao.DaoException;
import com.traineeApp.dto.Trainee;

public interface TraineeAppService {
//    public List<Trainee> getAllBooks() ;
//    public Trainee addBook(Trainee book);
	
    Trainee addTrainee(Trainee trainee) throws DaoException;
    
    Trainee findTraineeById(int traineeId) throws DaoException;
}
