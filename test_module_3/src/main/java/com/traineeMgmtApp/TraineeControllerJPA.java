package com.traineeMgmtApp;

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
@RequestMapping("/api/trainee")
public class TraineeControllerJPA {

    private final TraineeService traineeService;

    public TraineeControllerJPA(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @PostMapping
    public Trainee addTrainee(@RequestBody Trainee trainee) {
        return traineeService.addTrainee(trainee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainee> findById(@PathVariable int id) {
        return traineeService.findById(id)
                             .map(ResponseEntity::ok)
                             .orElse(ResponseEntity.notFound().build());
    }
}
