package com.sis.ExcelReport.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sis.ExcelReport.Model.PrfObMaster;
import com.sis.ExcelReport.dao.EmployeeDao;
import com.sis.ExcelReport.dao.PrfObDao;
import com.sis.ExcelReport.dao.ServiceDao;

@Service
public class ReportService {
	@Autowired
	ServiceDao servicedao;
	
	@Autowired
	EmployeeDao empdao;
	
	@Autowired
	PrfObDao prfdao;
           
	 Logger logger = LoggerFactory.getLogger(ReportService.class);

	
	public List<ServiceMaster> getList(){
		return servicedao.findAll();
		
	}
	
public List<ServiceMaster> getListByReportType(String type){
		return servicedao.finByReportType(type);
		
	}

public List<ServiceMaster> getListByDate(String fdate,String tdate){
	return servicedao.finByDate(fdate,tdate);
	
}

public List<ServiceMaster> getListByDate_new(LocalDateTime fdate,LocalDateTime tdate){
	return servicedao.finByDate_LocalDateTime(fdate,tdate);
	
}

public List<ServiceMaster> getListByDate2(LocalDateTime fdate,LocalDateTime tdate){
	return servicedao.finByDate2(fdate,tdate);
	
}

public List<ServiceMaster> getListByReportTypeandDate(String fdate,String tdate,String type){
	return servicedao.finByReportTypeByDate(fdate, tdate, type);
	
}

public List<ServiceMaster> getPFRNList(){
	
	return servicedao.getPendingFRNList();
	
}


public List<ServiceMaster> getOBPendingList(){
	
	return servicedao.getOBPendingList();
	
}

public List<ServiceMaster> getURList(){
	
	return servicedao.getUnderRepairList();
	
}

public List<PrfObMaster> getPRfObPendingList(String status){
	
	return prfdao.finPrfObList(status);
	
}

public List<PrfObMaster> getPRfObCompletedList(String frDate,String toDate,String status){
	
	return prfdao.finPrfObListTypeByDate(status, frDate, toDate);
	
}


public List<ServiceMaster> getListByReportTypeandDateAndDiv(String fdate,String tdate,String type,String div){
	List<ServiceMaster> serlist = servicedao.finByReportTypeByDate(fdate, tdate, type);
	if("all".equals(div)) {
		return serlist;
	}else {
		List<ServiceMaster> resultList = serlist.stream().filter(obj -> obj.getDivisionName().equals(div)).collect(Collectors.toList());
		return resultList;
	}
	
	
}

public List<ServiceMaster> getListByDiv(List<ServiceMaster> serlist,String div){
		List<ServiceMaster> resultList = serlist.stream().filter(obj -> obj.getDivisionName().equals(div)).collect(Collectors.toList());
		return resultList;
	
}

public List<PrfObMaster> getPrfobListByDiv(List<PrfObMaster> serlist,String div){
	List<PrfObMaster> resultList = serlist.stream().filter(obj -> obj.getDivision().equals(div)).collect(Collectors.toList());
	return resultList;

}
	
	public String CreateExcel() throws IOException {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet =  workbook.createSheet();
		Row row =  sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("welcomeee");
		FileOutputStream outputStream = new FileOutputStream("sample.xlsx");
		workbook.write(outputStream);
		workbook.close();
		return "sample.xlsx";
	}
	
	public String getEmpname(String id){
		
		return empdao.findEmpName(Integer.parseInt(id));
		
	}
	
	
	public void getDispatchReport(String cat) {
		
	}
	
	public long getDiffDays(String date_from_serCenter) throws ParseException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate current = LocalDate.now();
		LocalDate date1 = LocalDate.parse(date_from_serCenter, dtf);
		long daysBetween = Duration.between( date1.atStartOfDay(),current.atStartOfDay()).toDays();
		System.out.println ("Days: " + daysBetween);
		return daysBetween;
	}
	
	
	public List<ServiceMaster> getListByReportTypeandDate2(LocalDateTime fdate,LocalDateTime tdate,String type){
		return servicedao.finByReportTypeByDate2(fdate, tdate, type);
		
	}
	
}
