package com.traineeMgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traineeMgmt.entities.Trainee;
import com.traineeMgmt.service.TraineeService;

@RestController
@RequestMapping("/trainees")
public class TraineeController {
    @Autowired
    private TraineeService traineeService;

//    @PostMapping
//    public ResponseEntity<Trainee> addTrainee(@RequestBody Trainee trainee) {
//    	traineeService.addTrainee(trainee);
//        return ResponseEntity.ok(trainee);
//    }
    @PostMapping
    public void addTrainee(@RequestBody Trainee trainee) {
    	traineeService.addTrainee(trainee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainee> getTrainee(@PathVariable Integer id) {
        Trainee trainee = traineeService.findById(id);
        return ResponseEntity.ok(trainee);
    }
}
