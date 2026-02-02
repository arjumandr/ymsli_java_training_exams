package com.traineeMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traineeMgmt.dao.TraineeDao;
import com.traineeMgmt.entities.Trainee;

@Service
public class TraineeServiceImpl implements TraineeService {
    private final TraineeDao traineeDao;

    public TraineeServiceImpl(TraineeDao traineeDAO) {
        this.traineeDao = traineeDAO;
    }

    @Override
    public void addTrainee(Trainee trainee) {
        // Basic validation
        if (trainee.getName() == null || trainee.getEmail() == null)
            throw new IllegalArgumentException("Name and email required");
        traineeDao.addTrainee(trainee);
    }

    @Override
    public Trainee findById(int id) {
        return traineeDao.findById(id);
    }
}
