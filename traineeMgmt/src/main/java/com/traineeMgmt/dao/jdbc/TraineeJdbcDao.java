package com.traineeMgmt.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.traineeMgmt.dao.TraineeDao;
import com.traineeMgmt.entities.Trainee;
import com.traineeMgmt.exception.TraineeDataAccessException;

@Repository
//@Primary
public class TraineeJdbcDao implements TraineeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addTrainee(Trainee trainee) {
        try {
            jdbcTemplate.update(
                "INSERT INTO trainees(name,email,domain) VALUES (?,?,?)",
                trainee.getName(), trainee.getEmail(), trainee.getDomain()
            );
        } catch (DataAccessException e) {
        	e.printStackTrace();
            throw new TraineeDataAccessException("Error adding trainee", e);
        }
    }

    @Override
    public Trainee findById(Integer id) {
        try {
            return jdbcTemplate.queryForObject(
                "SELECT * FROM trainees WHERE id=?",
                new BeanPropertyRowMapper<>(Trainee.class),
                id
            );
        } catch (DataAccessException e) {
            throw new TraineeDataAccessException("Error finding trainee", e);
        }
    }
}

