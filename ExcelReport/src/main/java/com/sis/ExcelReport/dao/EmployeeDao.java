package com.sis.ExcelReport.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sis.ExcelReport.Model.EmployeeMaster;
@Repository
public interface EmployeeDao extends JpaRepository<EmployeeMaster,Integer>{
	@Query(value = "SELECT emp_name FROM emploeemaster WHERE emp_id = ?",nativeQuery = true)
    public String findEmpName(Integer id);
}
