package com.sis.ExcelReport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sis.ExcelReport.Model.BranchMaster;
import com.sis.ExcelReport.Model.Productmaster;

public interface Branchdao extends JpaRepository<BranchMaster,Integer>{
	@Query(value = "SELECT branchname FROM branch WHERE branchid= ?",nativeQuery = true)
    public String findbranchName(Integer id);
}
