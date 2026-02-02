package com.traineeMgmtApp.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traineeMgmtApp.dto.Trainee;
import com.traineeMgmtApp.service.TraineeService;

@RestController
@Profile("jdbc")
@RequestMapping("/api/trainee")
public class TraineeController {
	private final TraineeService traineeService;

	public TraineeController(TraineeService traineeService) {
		this.traineeService = traineeService;
	}
	
	@PostMapping
    public void addTrainee(@RequestBody Trainee trainee) {
		traineeService.addTrainee(trainee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainee> findById(@PathVariable int id) {
        return traineeService.findById(id)
                             .map(ResponseEntity::ok)
                             .orElse(ResponseEntity.notFound().build());
    }	
	
}
