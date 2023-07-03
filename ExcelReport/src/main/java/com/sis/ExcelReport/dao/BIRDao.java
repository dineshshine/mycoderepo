package com.sis.ExcelReport.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sis.ExcelReport.Model.BirMaster;
import com.sis.ExcelReport.Service.ServiceMaster;
@Repository
public interface BIRDao extends JpaRepository<BirMaster, Integer>{
	@Query(value = "SELECT * FROM birmaster WHERE final_status='Pending' and current_date between ?1 and ?2 ",nativeQuery = true)
    public List<BirMaster> finBirListTypeByDate(String fromdate,String todate);
}
