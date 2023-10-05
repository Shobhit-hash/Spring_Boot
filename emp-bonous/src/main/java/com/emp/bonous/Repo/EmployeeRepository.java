package com.emp.bonous.Repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emp.bonous.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	//@Query("SELECT e FROM Employee e WHERE :date BETWEEN e.joiningDate AND e.exitDate")
	 @Query("SELECT e FROM Employee e WHERE e.joiningDate <= :date AND e.exitDate >= :date")
	 List<Employee> findEligibleEmployees(@Param("date") LocalDate date);
}

