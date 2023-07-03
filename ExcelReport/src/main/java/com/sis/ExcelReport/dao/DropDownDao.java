package com.sis.ExcelReport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sis.ExcelReport.Model.DropDownMaster;

@Repository
public interface DropDownDao extends JpaRepository<DropDownMaster, Integer>{

	@Query(value = "SELECT ddvalue FROM dropdownmaster WHERE dd_id = ?",nativeQuery = true)
    public String findDDName(Integer id);
	
}
