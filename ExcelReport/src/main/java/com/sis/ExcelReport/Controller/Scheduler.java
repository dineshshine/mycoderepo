package com.sis.ExcelReport.Controller;

import java.io.IOException;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sis.ExcelReport.Service.EmailService;
import com.sis.ExcelReport.Service.ExcelService;
import com.sis.ExcelReport.Service.OB_PendingService;
import com.sis.ExcelReport.Service.PRFOBService;
import com.sis.ExcelReport.Service.PendingFRNService;
import com.sis.ExcelReport.Service.ReportService;
import com.sis.ExcelReport.Service.UnderRepairService;

@Controller
public class Scheduler {
     
	
	@Autowired
	ExcelService excelservice;
	
	@Autowired
	PendingFRNService Pfrnservice;
	
	@Autowired
	OB_PendingService observice;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	ReportService reportService;
	
	
	
	@Autowired
	UnderRepairService URService;
	
	@Autowired
	PRFOBService PrfObService;
	
	@Autowired
	ReportController reportController;
	
	Logger logger = LoggerFactory.getLogger(Scheduler.class);
	
	
//	//@Scheduled(cron = "0 30 10 ? * MON")
//	public void cronJob_dispatch_eve() throws IOException {
//		System.out.println("inside!!!" + LocalDateTime.now());
//		getPendingFRNReport();
//	}
	
	//@Scheduled(cron = "0 30 11 1/1 * ? ")
	public void cronJob_Dispatch() throws IOException {
		System.out.println("inside!!! cronJob_Dispatch" + LocalDateTime.now());
		
		reportController.getDispatchReport1(null);
	}
	
	//@Scheduled(cron = "0 6 16 1/1 * ?")
	public void cronJob_dispatch_eve() throws IOException {
		System.out.println("inside!!! cronJob_dispatch_eve" + LocalDateTime.now());
		reportController.getDispatchReport_eve(null);
	}
	
	//@Scheduled(cron = "0 30 10 ? * MON")
	public void cronJob_PFRN() throws IOException {
		System.out.println("inside!!! cronJob_PFRN" + LocalDateTime.now());
		reportController.getOBPendingReport(null);
	}
	
	//@Scheduled(cron = "0 0 10 ? * MON")
	public void cronJob_UR() throws IOException {
		System.out.println("inside!!!" + LocalDateTime.now());
		reportController.getURReport(null);
	}
	
	
	//@Scheduled(cron = "0 0 11 ? * MON")
	public void cronJob_OBPen() throws IOException {
		System.out.println("inside!!!" + LocalDateTime.now());
		reportController.getPendingFRNReport(null);
	}
	
	//@Scheduled(cron = "0 40 9 1/1 * ?")
	public void cronJob_PRFOB_Pen() throws IOException {
		System.out.println("inside!!!" + LocalDateTime.now());
		reportController.getPRFOBPendingList(null);
	}
	
	//@Scheduled(cron = "0 30 18 1/1 * ?")
	public void cronJob_PRFOB_Completed() throws IOException {
		System.out.println("inside!!!" + LocalDateTime.now());
		reportController.getPRFOBCompletedList(null);
	}
	
	//@Scheduled(cron = "0 0 20 1/1 * ?")
	public void cronJob_Stocklist() throws IOException {
		System.out.println("inside!!!" + LocalDateTime.now());
		reportController.getStockReport_eve(null);
	}
	
	//@Scheduled(cron = "0 0 21 1 1/1 ?")
	public void cronJob_Scraplist1() throws IOException {
		System.out.println("inside!!!" + LocalDateTime.now());
		reportController.getScrapReport1(null);
	}
	
	//@Scheduled(cron = "0 0 21 16 1/1 ?")
	public void cronJob_Scraplist2() throws IOException {
		System.out.println("inside!!!" + LocalDateTime.now());
		reportController.getScrapReport2(null);
	}
	
//	//@Scheduled(cron = "0 30 18 1/1 * ?")
//	public void cronJob_PRFOB_Completed() throws IOException {
//		System.out.println("inside!!!" + LocalDateTime.now());
//		reportController.getPRFOBCompletedList();
//	}
	
	
	
	
}
