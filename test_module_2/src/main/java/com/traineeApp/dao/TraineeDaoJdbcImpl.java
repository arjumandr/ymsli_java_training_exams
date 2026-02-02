package com.traineeApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.traineeApp.dto.Trainee;
import com.traineeApp.util.ConnectionFactory;

public class TraineeDaoJdbcImpl implements TraineeDao {

	private Connection connection;

	public TraineeDaoJdbcImpl() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public Trainee findTraineeById(int traineeId) throws DaoException{
		Trainee trainee = new Trainee();
		try {
			PreparedStatement psmt = connection.prepareStatement("select * from trainee where trainee_id = ?", 
					Statement.RETURN_GENERATED_KEYS);
			psmt.setInt(1, traineeId);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				trainee.setTrainee_id(rs.getInt(1));
				trainee.setTrainee_name(rs.getString(2));
				trainee.setBranch(rs.getString(3));
				trainee.setPercentage(rs.getDouble(4));
			}
			psmt.close();
		} catch (SQLException e) {
			throw new DaoException("Unable to find trainee with this id", e);
		}
		return trainee;
	}

	@Override
	public Trainee addTrainee(Trainee trainee) throws DaoException{
		try {
			PreparedStatement psmt = connection.
					prepareStatement("insert into trainee(trainee_id, trainee_name, branch, percentage) values(?,?,?,?)",
							Statement.RETURN_GENERATED_KEYS);
			psmt.setInt(1, trainee.getTrainee_id());
			psmt.setString(2, trainee.getTrainee_name());
			psmt.setString(3, trainee.getBranch());
			psmt.setDouble(4, trainee.getPercentage());
			psmt.executeUpdate();
			ResultSet rs = psmt.getGeneratedKeys();
			if(rs.next()) {
				trainee.setTrainee_id(rs.getInt(1));
			}
			psmt.close();
		} catch(SQLException e) {
			throw new DaoException("Unable to add trainee", e);
		}
		return trainee;
	}

}












