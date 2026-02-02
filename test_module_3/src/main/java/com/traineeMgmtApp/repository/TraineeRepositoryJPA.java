package com.traineeMgmtApp.repository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traineeMgmtApp.dto.Trainee;

@Repository
@ConditionalOnProperty(
	    name = "trainee.dao.type",
	    havingValue = "jpa"
	)
public interface TraineeRepositoryJPA extends JpaRepository<Trainee, Integer>{

}
