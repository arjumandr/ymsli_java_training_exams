package com.employeeapp.repo;

import com.employeeapp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	@Query("SELECT e FROM Employee e JOIN FETCH e.department")
	List<Employee> findAll();
	
	@Query("select e from Employee e join e.department d where d.dname = :deptName")
	List<Employee> findByDepartmentDname(String deptName);
}
