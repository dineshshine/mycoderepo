package com.sis.ExcelReport.Controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sis.ExcelReport.Model.EmailDetails;
import com.sis.ExcelReport.Model.MailIdEntry;
import com.sis.ExcelReport.Model.Model;
import com.sis.ExcelReport.Model.PrfObMaster;
import com.sis.ExcelReport.Service.EmailService;
import com.sis.ExcelReport.Service.ExcelService;
import com.sis.ExcelReport.Service.OB_PendingService;
import com.sis.ExcelReport.Service.PRFOBService;
import com.sis.ExcelReport.Service.PendingFRNService;
import com.sis.ExcelReport.Service.ReportService;
import com.sis.ExcelReport.Service.ServiceMaster;
import com.sis.ExcelReport.Service.StockReportService;
import com.sis.ExcelReport.Service.UnderRepairService;

@Controller
public class ReportController {
	@Autowired
	ReportService reportService;

	@Autowired
	ExcelService excelservice;

	@Autowired
	EmailService emailService;

	@Autowired
	PendingFRNService Pfrnservice;

	@Autowired
	OB_PendingService observice;

	@Autowired
	UnderRepairService URService;

	@Autowired
	PRFOBService PrfObService;

	@Autowired
	StockReportService stockservice;

	Logger logger = LoggerFactory.getLogger(ReportController.class);

	@GetMapping("/getResponse")
	public String generator() throws IOException {
		EmailDetails mail = new EmailDetails();
		mail.setMsgBody("Welcome to this sample mail!");
		mail.setSubject("testing mail");
		mail.setAttachment("docfile.xlsx");
		emailService.sendMailWithAttachments(mail);
		return "Report";
	}

	@GetMapping("/")
	public String gethome() throws IOException {

		return "home";
	}

	@GetMapping("/getReport")
	public String getReport(org.springframework.ui.Model model) throws IOException {
		List<ServiceMaster> serList = reportService.getListByReportType("scraplist");
		String path = excelservice.createScrapExcel(serList);
		EmailDetails mail = new EmailDetails();
		mail.setMsgBody("Welcome to this sample mail!");
		mail.setSubject("testing mail");
		mail.setAttachment(path);
		emailService.sendMailWithAttachments(mail);
		return "Report";
	}

	@GetMapping("/dispatch_mrg")
	public String getDispatchReport1(org.springframework.ui.Model model) throws IOException {
		LocalDate today = LocalDate.now();
		LocalDate yeserday = today.minusDays(1);
		LocalTime frtime = LocalTime.of(16, 06, 00);
		LocalTime toTime = LocalTime.of(11, 29, 59);
		LocalDateTime fromdtTime = LocalDateTime.of(yeserday, frtime);
		LocalDateTime todtTime = LocalDateTime.of(today, toTime);

		String reportType = "dispatchlist";
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String formattedString = today.format(formatter);
//		String formattedString2 = yeserday.format(formatter);
		String msgbody = "Dear All, \n" + "Greetings!\n"
				+ "Kindly find the attached DispatchList Escalation Report for your reference and further proceedings";
//		logger.info("Report Type -->"+reportType);
//		String fdate = formattedString2.concat(" 16:06:00");
//		String ldate = formattedString.concat(" 11:29:59");
		List<String> catlist = emailService.getCatList(reportType);
		List<MailIdEntry> mailIdList = emailService.getMailList(reportType);
		// List<ServiceMaster> serList = reportService.getListByReportTypeandDate(fdate,
		// ldate, reportType);
		List<ServiceMaster> serList = reportService.getListByReportTypeandDate2(fromdtTime, todtTime, reportType);

		catlist.forEach(ele -> {
			logger.info("DepartMent -->" + ele);
			String path = null;
			if ("all".equals(ele)) {
				try {
					path = excelservice.createDispatchExcel(serList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				List<ServiceMaster> resultSerList = reportService.getListByDiv(serList, ele);
				try {
					path = excelservice.createDispatchExcel(resultSerList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String finalDate = today.format(formatter1);
			String sub = "DispatchList Escalation_'" + finalDate + "'";
			List<String> mailList = emailService.getMailList(mailIdList, ele);
			emailService.sendMail(msgbody, sub, mailList, path);
		});
		if (null != model) {
			model.addAttribute("message", "'" + reportType + "' Mail Sent Successfully!");
		}
		return "home";
	}

	@GetMapping("/dispatch_eve")
	public String getDispatchReport_eve(org.springframework.ui.Model model) throws IOException {
		LocalDate today = LocalDate.now();
		LocalDate yeserday = today.minusDays(1);
		LocalTime frtime = LocalTime.of(11, 30, 00);
		LocalTime toTime = LocalTime.of(16, 05, 59);
		LocalDateTime fromdtTime = LocalDateTime.of(yeserday, frtime);
		LocalDateTime todtTime = LocalDateTime.of(today, toTime);

		String reportType = "dispatchlist";
		logger.info("Report Type -->" + reportType);
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String formattedString = today.format(formatter);
//		String formattedString2 = yeserday.format(formatter);
		String msgbody = "Dear All, \n" + "Greetings!\n"
				+ "Kindly find the attached DispatchList Escalation Report for your reference and further proceedings";

//		String fdate = formattedString.concat(" 11:30:00");
//		String ldate = formattedString.concat(" 16:05:59");
		List<String> catlist = emailService.getCatList(reportType);
		List<MailIdEntry> mailIdList = emailService.getMailList(reportType);
		// List<ServiceMaster> serList = reportService.getListByReportTypeandDate(fdate,
		// ldate, reportType);
		List<ServiceMaster> serList = reportService.getListByReportTypeandDate2(fromdtTime, todtTime, reportType);

		catlist.forEach(ele -> {
			logger.info("DepartMent -->" + ele);
			String path = null;
			if ("all".equals(ele)) {
				try {
					path = excelservice.createDispatchExcel(serList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				List<ServiceMaster> resultSerList = reportService.getListByDiv(serList, ele);
				try {
					path = excelservice.createDispatchExcel(resultSerList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String finalDate = today.format(formatter1);
			String sub = "DispatchList Escalation_'" + finalDate + "'";
			List<String> mailList = emailService.getMailList(mailIdList, ele);
			emailService.sendMail(msgbody, sub, mailList, path);
		});
		if (null != model) {
			model.addAttribute("message", "'" + reportType + "' Mail Sent Successfully!");
		}
		return "home";
	}

	@GetMapping("/scrapreport1")
	public String getScrapReport1(org.springframework.ui.Model model) throws IOException {

		LocalDate today = LocalDate.now();
		String reportType = "scraplist";
		logger.info("Report Type -->" + reportType);
		String msgbody = "Dear All, \n" + "Greetings!\n"
				+ "Kindly find the attached ScrapLlist Escalation Report for your reference and further proceedings";
		LocalDate lastmonth = today.minusMonths(1);
		LocalDate startdate = lastmonth.withDayOfMonth(15);
		LocalDate enddate = lastmonth.withDayOfMonth(lastmonth.lengthOfMonth());
		LocalTime frtime = LocalTime.of(21, 00, 00);
		LocalTime toTime = LocalTime.of(20, 59, 59);
		LocalDateTime fromdtTime = LocalDateTime.of(startdate, frtime);
		LocalDateTime todtTime = LocalDateTime.of(enddate, toTime);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String formattedString1 = startdate.format(formatter);
		String formattedString2 = enddate.format(formatter);

//		String fdate1 = formattedString1.concat(" 21:00:00");
//		;
//		String ldate1 = formattedString2.concat(" 20:59:59");
		List<String> catlist = emailService.getCatList(reportType);
		List<MailIdEntry> mailIdList = emailService.getMailList(reportType);
		// List<ServiceMaster> serList =
		// reportService.getListByReportTypeandDate(fdate1, ldate1, reportType);
		List<ServiceMaster> serList = reportService.getListByReportTypeandDate2(fromdtTime, todtTime, reportType);
		catlist.forEach(ele -> {
			logger.info("DepartMent -->" + ele);
			String path = null;
			if ("all".equals(ele)) {
				try {
					path = excelservice.createScrapExcel(serList);

				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				List<ServiceMaster> resultSerList = reportService.getListByDiv(serList, ele);

				try {
					path = excelservice.createScrapExcel(resultSerList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String finalDate = today.format(formatter1);
			String sub = "ScrapList Escalation_'" + finalDate + "'";
			List<String> mailList = emailService.getMailList(mailIdList, ele);
			emailService.sendMail(msgbody, sub, mailList, path);
		});
		if (null != model) {
			model.addAttribute("message", "'" + reportType + "' Mail Sent Successfully!");
		}
		return "home";
	}

	@GetMapping("/scrapreport2")
	public String getScrapReport2(org.springframework.ui.Model model) throws IOException {
		String reportType = "scraplist";
		logger.info("Report Type -->" + reportType);
		String msgbody = "Dear All, \n" + "Greetings!\n"
				+ "Kindly find the attached ScrapLlist Escalation Report for your reference and further proceedings";
		LocalDate today = LocalDate.now();
		LocalDate lastMonth = today.minusMonths(1);
		LocalDate startDate = lastMonth.withDayOfMonth(lastMonth.lengthOfMonth());
		LocalDate enddate = today.withDayOfMonth(15);
		
		LocalTime frtime = LocalTime.of(21, 00, 00);
		LocalTime toTime = LocalTime.of(20, 59, 59);
		LocalDateTime fromdtTime = LocalDateTime.of(startDate, frtime);
		LocalDateTime todtTime = LocalDateTime.of(enddate, toTime);
		

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String formattedString1 = startDate.format(formatter);
//		String formattedString2 = enddate.format(formatter);

//		String fdate1 = formattedString1.concat(" 21:00:00");
//		;
//		String ldate1 = formattedString2.concat(" 20:59:59");
		List<String> catlist = emailService.getCatList(reportType);
		List<MailIdEntry> mailIdList = emailService.getMailList(reportType);
		//List<ServiceMaster> serList = reportService.getListByReportTypeandDate(fdate1, ldate1, reportType);
		List<ServiceMaster> serList = reportService.getListByReportTypeandDate2(fromdtTime, todtTime, reportType);

		catlist.forEach(ele -> {
			logger.info("DepartMent -->" + ele);
			String path = null;
			if ("all".equals(ele)) {
				try {
					path = excelservice.createScrapExcel(serList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				List<ServiceMaster> resultSerList = reportService.getListByDiv(serList, ele);
				try {
					path = excelservice.createScrapExcel(resultSerList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String finalDate = today.format(formatter1);
			String sub = "ScrapList Escalation_'" + finalDate + "'";
			List<String> mailList = emailService.getMailList(mailIdList, ele);
			emailService.sendMail(msgbody, sub, mailList, path);
		});
		if (null != model) {
			model.addAttribute("message", "'" + reportType + "' Mail Sent Successfully!");
		}
		return "home";
	}

	@GetMapping("/getTestingReport")
	public String getTestingReport1() throws IOException {
		// getDispatchReport1();
		return "home";
	}

	@GetMapping("/stocklist")
	public String getStockReport_eve(org.springframework.ui.Model model) throws IOException {
		LocalDate today = LocalDate.now();
		LocalDate yeserday = today.minusDays(1);
		
		LocalTime frtime = LocalTime.of(20, 00, 00);
		LocalTime toTime = LocalTime.of(19, 59, 59);
		LocalDateTime fromdtTime = LocalDateTime.of(today, frtime);
		LocalDateTime todtTime = LocalDateTime.of(yeserday, toTime);
		
		String reporttype = "stocklist";
		logger.info("Report Type -->" + reporttype);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedString = today.format(formatter);
		String formattedString2 = yeserday.format(formatter);
		String msgbody = "Dear All, \n" + "Greetings!\n"
				+ "Kindly find the attached Stocklist Escalation Report for your reference and further proceedings";

		String fdate = formattedString2.concat(" 20:00:00");
		String ldate = formattedString.concat(" 19:59:59");
		List<String> catlist = emailService.getCatList(reporttype);
		List<MailIdEntry> mailIdList = emailService.getMailList(reporttype);
		//List<ServiceMaster> serList = reportService.getListByReportTypeandDate(fdate, ldate, reporttype);
		
		List<ServiceMaster> serList = reportService.getListByReportTypeandDate2(fromdtTime, todtTime, reporttype);

		catlist.forEach(ele -> {
			logger.info("DepartMent -->" + ele);
			String path = null;
			if ("all".equals(ele)) {
				try {
					path = stockservice.createStockExcel(serList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				List<ServiceMaster> resultSerList = reportService.getListByDiv(serList, ele);
				try {
					path = stockservice.createStockExcel(resultSerList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String formatdate = today.format(formatter2);
			String sub = "Stocklist Escalation_'" + formatdate + "'";
			List<String> mailList = emailService.getMailList(mailIdList, ele);
			emailService.sendMail(msgbody, sub, mailList, path);
		});
		if (null != model) {
			model.addAttribute("message", "'" + reporttype + "' Mail Sent Successfully!");
		}
		return "home";
	}

	@GetMapping("/getPendingFRN")
	public String getPendingFRNReport(org.springframework.ui.Model model) throws IOException {
		String reportType = "pendingfrn";
		logger.info("Report Type -->" + reportType);
		String msgbody = "Dear All, \n" + "Greetings!\n" + "Kindly find the attached '" + reportType
				+ "' Escalation Report for your reference and further proceedings";

		List<String> catlist = emailService.getCatList(reportType);
		List<MailIdEntry> mailIdList = emailService.getMailList(reportType);
		List<ServiceMaster> serList = reportService.getPFRNList();

		catlist.forEach(ele -> {
			logger.info("DepartMent -->" + ele);
			String path = null;
			if ("all".equals(ele)) {
				try {
					path = Pfrnservice.createPendingFrnExcel(serList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				List<ServiceMaster> resultSerList = reportService.getListByDiv(serList, ele);
				try {
					path = Pfrnservice.createPendingFrnExcel(resultSerList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			LocalDate ldt1 = LocalDate.now();
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String formaStr = ldt1.format(formatter2);
			String filename = "PendingFRN Esclation_ '" + formaStr + "'";
			String sub = filename;
			List<String> mailList = emailService.getMailList(mailIdList, ele);
			emailService.sendMail(msgbody, sub, mailList, path);
		});
		if (null != model) {
			model.addAttribute("message", "'" + reportType + "' Mail Sent Successfully!");
		}
		return "home";
	}

	@GetMapping("/getOBPending")
	public String getOBPendingReport(org.springframework.ui.Model model) throws IOException {
		String reportType = "ob_pending";
		logger.info("Report Type -->" + reportType);

		String msgbody = "Dear All, \n" + "Greetings!\n" + "Kindly find the attached '" + reportType
				+ "' Escalation Report for your reference and further proceedings";

		List<String> catlist = emailService.getCatList(reportType);
		List<MailIdEntry> mailIdList = emailService.getMailList(reportType);
		List<ServiceMaster> serList = reportService.getOBPendingList();

		catlist.forEach(ele -> {
			logger.info("DepartMent -->" + ele);
			String path = null;
			if ("all".equals(ele)) {
				try {
					path = observice.createOBPendingExcel(serList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				List<ServiceMaster> resultSerList = reportService.getListByDiv(serList, ele);
				try {
					path = observice.createOBPendingExcel(resultSerList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			LocalDate ldt1 = LocalDate.now();
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String formaStr = ldt1.format(formatter2);
			String filename = "OBPending Esclation_ '" + formaStr + "'";
			String sub = filename;
			List<String> mailList = emailService.getMailList(mailIdList, ele);
			emailService.sendMail(msgbody, sub, mailList, path);
		});
		if (null != model) {
			model.addAttribute("message", "'" + reportType + "' Mail Sent Successfully!");
		}
		return "home";
	}

	@GetMapping("/getUR")
	public String getURReport(org.springframework.ui.Model model) throws IOException {
		String reportType = "under_repair";
		logger.info("Report Type -->" + reportType);
		String msgbody = "Dear All, \n" + "Greetings!\n" + "Kindly find the attached '" + reportType
				+ "' Escalation Report for your reference and further proceedings";

		List<String> catlist = emailService.getCatList(reportType);
		List<MailIdEntry> mailIdList = emailService.getMailList(reportType);
		List<ServiceMaster> serList = reportService.getURList();

		catlist.forEach(ele -> {
			logger.info("DepartMent -->" + ele);
			String path = null;
			if ("all".equals(ele)) {
				try {
					path = URService.createURExcel(serList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				List<ServiceMaster> resultSerList = reportService.getListByDiv(serList, ele);
				try {
					path = URService.createURExcel(resultSerList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			LocalDate ldt1 = LocalDate.now();
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String formaStr = ldt1.format(formatter2);
			String filename = "Under_repair Esclation_ '" + formaStr + "'";
			String sub = filename;
			List<String> mailList = emailService.getMailList(mailIdList, ele);
			emailService.sendMail(msgbody, sub, mailList, path);
		});
		if (null != model) {
			model.addAttribute("message", "'" + reportType + "' Mail Sent Successfully!");
		}
		return "home";
	}

	@GetMapping("/getPrfObCompleted")
	public String getPRFOBCompletedList(org.springframework.ui.Model model) throws IOException {
		LocalDate today = LocalDate.now();
		LocalDate yeserday = today.minusDays(1);
		String reportType = "prf/ob_completed";
		String status = "Completed";
		logger.info("Report Type -->" + reportType);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedString = today.format(formatter);
		String formattedString2 = yeserday.format(formatter);
		String msgbody = "Dear All, \n" + "Greetings!\n" + "Kindly find the attached '" + reportType
				+ "' Escalation Report for your reference and further proceedings";

		String fdate = formattedString2.concat(" 18:30:00");
		String ldate = formattedString.concat(" 18:29:59");
		List<String> catlist = emailService.getCatList(reportType);
		List<MailIdEntry> mailIdList = emailService.getMailList(reportType);
		List<PrfObMaster> serList = reportService.getPRfObCompletedList(fdate, ldate, status);

		catlist.forEach(ele -> {
			logger.info("DepartMent -->" + ele);
			String path = null;
			if ("all".equals(ele)) {
				try {
					path = PrfObService.createPrfOBExcel(serList, status);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				List<PrfObMaster> resultSerList = reportService.getPrfobListByDiv(serList, ele);
				try {
					path = PrfObService.createPrfOBExcel(resultSerList, status);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			LocalDate ldt1 = LocalDate.now();
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String formaStr = ldt1.format(formatter2);
			String filename = "Prf/ob_completed Esclation_ '" + formaStr + "'";
			String sub = filename;
			List<String> mailList = emailService.getMailList(mailIdList, ele);
			emailService.sendMail(msgbody, sub, mailList, path);
		});
		if (null != model) {
			model.addAttribute("message", "'" + reportType + "' Mail Sent Successfully!");
		}
		return "home";
	}

	@GetMapping("/getPrfObPending")
	public String getPRFOBPendingList(org.springframework.ui.Model model) throws IOException {
		String reportType = "prf/ob_pending";
		String status = "Pending";
		logger.info("Report Type -->" + reportType);
		String msgbody = "Dear All, \n" + "Greetings!\n" + "Kindly find the attached '" + reportType
				+ "' Escalation Report for your reference and further proceedings";
		List<String> catlist = emailService.getCatList(reportType);
		List<MailIdEntry> mailIdList = emailService.getMailList(reportType);
		List<PrfObMaster> serList = reportService.getPRfObPendingList(status);

		catlist.forEach(ele -> {
			logger.info("DepartMent -->" + ele);
			String path = null;
			if ("all".equals(ele)) {
				try {
					path = PrfObService.createPrfOBExcel(serList, status);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				List<PrfObMaster> resultSerList = reportService.getPrfobListByDiv(serList, ele);
				try {
					path = PrfObService.createPrfOBExcel(resultSerList, status);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			LocalDate ldt1 = LocalDate.now();
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String formaStr = ldt1.format(formatter2);
			String filename = "PRFOB_Pending Esclation_ '" + formaStr + "'";
			String sub = filename;
			List<String> mailList = emailService.getMailList(mailIdList, ele);
			emailService.sendMail(msgbody, sub, mailList, path);
		});
		if (null != model) {
			model.addAttribute("message", "'" + reportType + "' Mail Sent Successfully!");
		}
		return "home";
	}

	@GetMapping("/getServiceReport")
	public String getService_ReportPage(org.springframework.ui.Model model) throws IOException {
		return "home";
	}

	@PostMapping("/getListReport")
	public String getService_Report(org.springframework.ui.Model model, @RequestParam("fdate") String fdate,
			@RequestParam("ldate") String ldate, HttpServletRequest req, HttpServletResponse response)
			throws IOException, ParseException {
		String fdate1 = fdate.concat(" 18:30:00");
		String ldate1 = ldate.concat(" 18:29:59");
		List<ServiceMaster> serlist1 = reportService.getListByDate(fdate1, ldate1);
		//List<ServiceMaster> serlist1 = reportService.getListByDate2(fdate1, ldate1);
		ByteArrayInputStream inputstr = excelservice.createServiceExcelReport(serlist1);
		if (inputstr != null) {
			response.setContentType("application/octat-stream");
			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=ServiceReport.xlsx";
			response.setHeader(headerKey, headerValue);
			IOUtils.copy(inputstr, response.getOutputStream());
			inputstr.close();
			return null;
		} else {
			model.addAttribute("error", "Report Not Generated!");
		}
		return "home";
	}
	
	@GetMapping("/getServiceReportAll")
	public String getService_Report__All(org.springframework.ui.Model model, 
			HttpServletRequest req,
			HttpServletResponse response)
			throws IOException, ParseException {
//		String fdate1 = fdate.concat(" 18:30:00");
//		String ldate1 = ldate.concat(" 18:29:59");
		List<ServiceMaster> serlist1 = reportService.getList();
		//List<ServiceMaster> serlist1 = reportService.getListByDate2(fdate1, ldate1);
		ByteArrayInputStream inputstr = excelservice.createServiceExcelReport(serlist1);
		if (inputstr != null) {
			response.setContentType("application/octat-stream");
			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=ServiceReport.xlsx";
			response.setHeader(headerKey, headerValue);
			IOUtils.copy(inputstr, response.getOutputStream());
			inputstr.close();
			return null;
		} else {
			model.addAttribute("error", "Report Not Generated!");
		}
		return "home";
	}

	@GetMapping("/dispatch_test")
	public String getDispatchReport_testing(org.springframework.ui.Model model) throws IOException {
		System.out.println("local  date" + LocalDateTime.now());
		System.out.println("local date 222" + LocalDateTime.of(2023, 06, 23, 16, 05, 59));
		System.out.println("local date 333" + LocalDateTime.of(2023, 06, 24, 11, 30, 00));
		LocalDate today = LocalDate.now();
		LocalDate yeserday = today.minusDays(1);
		String reportType = "dispatchlist";
		logger.info("Report Type -->" + reportType);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedString = today.format(formatter);
		String formattedString2 = yeserday.format(formatter);
		String msgbody = "Dear All, \n" + "Greetings!\n"
				+ "Kindly find the attached DispatchList Escalation Report for your reference and further proceedings";

		String fdate = formattedString.concat(" 11:30:00");
		String ldate = formattedString.concat(" 16:05:59");
		List<String> catlist = emailService.getCatList(reportType);
		List<MailIdEntry> mailIdList = emailService.getMailList(reportType);
		List<ServiceMaster> serList = reportService.getListByReportTypeandDate2(
				LocalDateTime.of(2023, 06, 23, 16, 05, 59), LocalDateTime.of(2023, 06, 24, 11, 30, 00), reportType);
		System.out.println("list sizeeen   ---->" + serList.size());
		catlist.forEach(ele -> {
			logger.info("DepartMent -->" + ele);
			String path = null;
			if ("all".equals(ele)) {
				try {
					path = excelservice.createDispatchExcel(serList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				List<ServiceMaster> resultSerList = reportService.getListByDiv(serList, ele);
				try {
					path = excelservice.createDispatchExcel(resultSerList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String finalDate = today.format(formatter1);
			String sub = "DispatchList Escalation_'" + finalDate + "'";
			List<String> mailList = emailService.getMailList(mailIdList, ele);

			// emailService.sendMail_Testing(msgbody, sub, mailList, path);
		});
		if (null != model) {
			model.addAttribute("message", "'" + reportType + "' Mail Sent Successfully!");
		}
		return "home";
	}

	@GetMapping("/dispatch_test2")
	public String getDispatchReport_testing2(org.springframework.ui.Model model) throws IOException {
		System.out.println("local  date" + LocalDateTime.now());
		System.out.println("local date 222" + LocalDateTime.of(2023, 06, 23, 16, 05, 59));
		System.out.println("local date 333" + LocalDateTime.of(2023, 06, 24, 11, 30, 00));
		LocalDate today = LocalDate.now();
		LocalDate yeserday = today.minusDays(1);
		LocalTime time = LocalTime.of(16, 05, 59);
		LocalDateTime localTime = LocalDateTime.of(yeserday, time);

		// LocalDate today = LocalDate.now();
		// LocalDate yeserday = today.minusDays(1);
		LocalTime frtime = LocalTime.of(16, 06, 00);
		LocalTime toTime = LocalTime.of(11, 29, 59);
		LocalDateTime fromdtTime = LocalDateTime.of(yeserday, frtime);
		LocalDateTime todtTime = LocalDateTime.of(today, toTime);

		System.out.println("local  date timee --->>" + fromdtTime + "   " + todtTime);
		String reportType = "stocklist";
		logger.info("Report Type -->" + reportType);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedString = today.format(formatter);
		String formattedString2 = yeserday.format(formatter);
		String msgbody = "Dear All, \n" + "Greetings!\n"
				+ "Kindly find the attached DispatchList Escalation Report for your reference and further proceedings";

		String fdate = formattedString.concat(" 11:30:00");
		String ldate = formattedString.concat(" 16:05:59");
		List<String> catlist = emailService.getCatList(reportType);
		List<MailIdEntry> mailIdList = emailService.getMailList(reportType);
		List<ServiceMaster> serList = reportService.getListByReportTypeandDate2(
				LocalDateTime.of(2023, 06, 12, 11, 30, 01), LocalDateTime.of(2023, 06, 16, 16, 04, 59), reportType);
		System.out.println("list sizeeen   ---->" + serList.size());

		serList.stream().forEach(ele -> System.out.println(ele.getDefGirNo()));

		return "home";
	}
	
	
	@GetMapping("/dispatch_mrg_test")
	public String getDispatchReport_test(org.springframework.ui.Model model) throws IOException {
		LocalDate today = LocalDate.now();
		LocalDate yeserday = today.minusDays(1);
		LocalTime frtime = LocalTime.of(16, 06, 00);
		LocalTime toTime = LocalTime.of(11, 29, 59);
		LocalDateTime fromdtTime = LocalDateTime.of(yeserday, frtime);
		LocalDateTime todtTime = LocalDateTime.of(today, toTime);

		String reportType = "dispatchlist";
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String formattedString = today.format(formatter);
//		String formattedString2 = yeserday.format(formatter);
		String msgbody = "Dear All, \n" + "Greetings!\n"
				+ "Kindly find the attached DispatchList Escalation Report for your reference and further proceedings";
//		logger.info("Report Type -->"+reportType);
//		String fdate = formattedString2.concat(" 16:06:00");
//		String ldate = formattedString.concat(" 11:29:59");
		List<String> catlist = emailService.getCatList(reportType);
		List<MailIdEntry> mailIdList = emailService.getMailList(reportType);
		// List<ServiceMaster> serList = reportService.getListByReportTypeandDate(fdate,
		// ldate, reportType);
		List<ServiceMaster> serList = reportService.getListByReportTypeandDate2(fromdtTime, todtTime, reportType);

		catlist.forEach(ele -> {
			logger.info("DepartMent -->" + ele);
			String path = null;
			if ("all".equals(ele)) {
				try {
					path = excelservice.createDispatchExcel(serList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				List<ServiceMaster> resultSerList = reportService.getListByDiv(serList, ele);
				try {
					path = excelservice.createDispatchExcel(resultSerList);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
//			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//			String finalDate = today.format(formatter1);
//			String sub = "DispatchList Escalation_'" + finalDate + "'";
//			List<String> mailList = emailService.getMailList(mailIdList, ele);
//			emailService.sendMail(msgbody, sub, mailList, path);
			
			
		
		});
//		ByteArrayInputStream inputstr = excelservice.createServiceExcelReport(resultSerList);
//		if (inputstr != null) {
//			response.setContentType("application/octat-stream");
//			String headerKey = "Content-Disposition";
//			String headerValue = "attachment; filename=ServiceReport.xlsx";
//			response.setHeader(headerKey, headerValue);
//			IOUtils.copy(inputstr, response.getOutputStream());
//			inputstr.close();
//			return null;
//		} else {
//			model.addAttribute("error", "Report Not Generated!");
//		}
		//return "home";
		if (null != model) {
			model.addAttribute("message", "'" + reportType + "' Mail Sent Successfully!");
		}
		return "home";
	}
	
	@GetMapping("/getListReport_test")
	public String getService_Report2(org.springframework.ui.Model model,  HttpServletRequest req, HttpServletResponse response)
			throws IOException, ParseException {
	//	String fdate1 = fdate.concat(" 18:30:00");
	//	String ldate1 = ldate.concat(" 18:29:59");
		
		LocalDateTime fdate1 = LocalDateTime.of(2023, 07, 01, 16, 06, 00);
		LocalDateTime ldate1 = LocalDateTime.of(2023, 07, 02, 11, 29, 59);
		List<ServiceMaster> serlist1 = reportService.getListByDate_new(fdate1, ldate1);
		//List<ServiceMaster> serlist1 = reportService.getListByDate2(fdate1, ldate1);
		ByteArrayInputStream inputstr = excelservice.createServiceExcelReport(serlist1);
		System.out.println(" sizee iss "+serlist1.size());
		if (inputstr != null) {
			response.setContentType("application/octat-stream");
			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=ServiceReport.xlsx";
			response.setHeader(headerKey, headerValue);
			IOUtils.copy(inputstr, response.getOutputStream());
			inputstr.close();
			return null;
		} else {
			model.addAttribute("error", "Report Not Generated!");
		}
		return "home";
	}


}
