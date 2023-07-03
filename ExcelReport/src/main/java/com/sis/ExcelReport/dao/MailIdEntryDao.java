package com.sis.ExcelReport.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sis.ExcelReport.Model.DropDownMaster;
import com.sis.ExcelReport.Model.MailIdEntry;

public interface MailIdEntryDao extends JpaRepository<MailIdEntry, Integer>{

	@Query(value = "SELECT temp1 FROM schillerindiaservices_2023.mail_id_entry where report_type = ? or report_type = 'all'  group by  temp1;",nativeQuery = true)
    public List<String> getCategories(String reporttype);
	
	@Query(value = "SELECT * FROM schillerindiaservices_2023.mail_id_entry where report_type = 'all' or report_type = ?",nativeQuery = true)
    public List<MailIdEntry> getMailIdList(String reporttype);
	
}
