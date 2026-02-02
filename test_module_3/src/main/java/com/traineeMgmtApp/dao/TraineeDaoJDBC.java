package com.traineeMgmtApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.traineeMgmtApp.dto.Trainee;

@Repository
@Profile("jdbc")

public class TraineeDaoJDBC implements TraineeDao {

    private final JdbcTemplate jdbcTemplate;

    public TraineeDaoJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Trainee addTrainee(Trainee trainee) {
        String sql = "INSERT INTO trainee2 (name, email) VALUES (?, ?)";
        jdbcTemplate.update(sql, trainee.getTraineeName(), trainee.getDepartment());
        return trainee;
    }

    @Override
    public Optional<Trainee> findById(int traineeId) {
        String sql = "SELECT * FROM trainee2 WHERE traineeId = ?";

        List<Trainee> list = jdbcTemplate.query(
            sql,
            new Object[]{traineeId},
            (rs, rowNum) -> {
                Trainee t = new Trainee();
                t.setId(rs.getInt("traineeId"));
                t.setTraineeName(rs.getString("name"));
                t.setDepartment(rs.getString("department"));
                return t;
            }
        );

        return list.stream().findFirst();
    }
}
