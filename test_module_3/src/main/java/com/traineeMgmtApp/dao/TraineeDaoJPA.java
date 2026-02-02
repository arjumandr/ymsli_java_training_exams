package com.traineeMgmtApp.dao;

import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.traineeMgmtApp.dto.Trainee;
import com.traineeMgmtApp.repository.TraineeRepositoryJPA;

@Repository
@Profile("jpa")

public class TraineeDaoJPA implements TraineeDao {

    private final TraineeRepositoryJPA repo;

    public TraineeDaoJPA(TraineeRepositoryJPA repo) {
        this.repo = repo;
    }

    @Override
    public Trainee addTrainee(Trainee trainee) {
        return repo.save(trainee);
    }

    @Override
    public Optional<Trainee> findById(int traineeId) {
        return repo.findById(traineeId);
    }
}
