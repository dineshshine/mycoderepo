package com.sis.ExcelReport.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sis.ExcelReport.Service.ServiceMaster;
@Repository
public interface ServiceDao extends JpaRepository<ServiceMaster,Integer> {
	@Query(value = "select * from service_master where report_type = ?",nativeQuery = true)
     public List<ServiceMaster> finByReportType(String reporttype);
	@Query(value = "select * from service_master where currentDate between ?1 and ?2",nativeQuery = true)
    public List<ServiceMaster> finByDate(String fromdate,String todate);
	
	@Query(value = "select * from service_master where currentDate between ?1 and ?2",nativeQuery = true)
    public List<ServiceMaster> finByDate_LocalDateTime(LocalDateTime fromdate,LocalDateTime todate);
	
	@Query(value = "select * from service_master where currentDate between ?1 and ?2",nativeQuery = true)
    public List<ServiceMaster> finByDate2(LocalDateTime fromdate,LocalDateTime todate);
	
	@Query(value = "select * from service_master where currentDate between ?1 and ?2 and report_type = ?3 ",nativeQuery = true)
    public List<ServiceMaster> finByReportTypeByDate(String fromdate,String todate,String reporttype);
	
	
	
	@Query(value = "select * from service_master where currentDate between ?1 and ?2 and report_type = ?3 and and division_name=?4",nativeQuery = true)
    public List<ServiceMaster> finByReportTypeByDateandDept(String fromdate,String todate,String reporttype,String division);
	
	//SELECT * FROM service_master sm INNER JOIN dropdownmaster dm ON sm.unit_status=dm.dd_id AND ddvalue NOT IN("OW","LAMC") AND (sm.ship_dt_frm_ser_cntr IS NULL ) AND report_type='servicecenter';
	@Query(value = "SELECT * FROM service_master sm where unit_status NOT IN(42,45) AND (sm.ship_dt_frm_ser_cntr IS NULL ) AND report_type='servicecenter'",nativeQuery = true)
    public List<ServiceMaster> getPendingFRNList();
	
	@Query(value = "SELECT * FROM service_master sm where unit_status NOT IN(42,45) AND (sm.ship_dt_frm_ser_cntr IS NULL ) AND report_type='servicecenter'",nativeQuery = true)
    public List<ServiceMaster> getPendingFRNReportByDept();
	
	@Query(value = "SELECT * FROM service_master sm where unit_status IN(42,45) AND (sm.ship_dt_frm_ser_cntr IS NULL ) AND report_type='servicecenter'",nativeQuery = true)
    public List<ServiceMaster> getOBPendingList();
	
	@Query(value = "SELECT * FROM service_master WHERE ship_dt_frm_ser_cntr IS NOT NULL  AND (repaired_brd_stk_date IS NULL)",nativeQuery = true)
    public List<ServiceMaster> getUnderRepairList();
	
	
	@Query(value = "select * from service_master where currentDate between ?1 and ?2 and report_type = ?3 ",nativeQuery = true)
    public List<ServiceMaster> finByReportTypeByDate2(LocalDateTime fromdate,LocalDateTime todate,String reporttype);
}
