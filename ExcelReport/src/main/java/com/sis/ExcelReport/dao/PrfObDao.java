package com.sis.ExcelReport.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sis.ExcelReport.Model.BirMaster;
import com.sis.ExcelReport.Model.PrfObMaster;
@Repository
public interface PrfObDao extends JpaRepository<PrfObMaster, Integer>{
	@Query(value = "SELECT * FROM prfobmaster WHERE status_type=?1 and current_date between ?1 and ?2 ",nativeQuery = true)
    public List<PrfObMaster> finPrfObListTypeByDate(String status,String fromdate,String todate);
	@Query(value = "SELECT * FROM prfobmaster WHERE status_type=?1  ",nativeQuery = true)
    public List<PrfObMaster> finPrfObList(String status);
}
