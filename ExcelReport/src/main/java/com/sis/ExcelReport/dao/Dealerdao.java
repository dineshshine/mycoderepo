package com.sis.ExcelReport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sis.ExcelReport.Model.DealerMaster;

public interface Dealerdao extends JpaRepository<DealerMaster,Integer>{
	@Query(value = "SELECT dealer_name FROM dealermaster WHERE dealer_id= ?",nativeQuery = true)
    public String findDealerName(Integer id);
}
