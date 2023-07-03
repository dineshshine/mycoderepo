package com.sis.ExcelReport.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnderRepairService {


	   
	@Autowired
	ExcelService excelservice;
	
	@Autowired
	ReportService reportservice;
	
	 Logger logger = LoggerFactory.getLogger(OB_PendingService.class);
	
	public String createURExcel(List<ServiceMaster> serList) throws IOException {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();

		Row rowhead = sheet.createRow(0);
		
//		for(int i=0;i<headerMap.size();i++) {
//			headerRow.createCell(i).setCellValue(headerMap.get(i));
//		}
//		
//		for (int j = 1; j < data.size(); j++) {
//			Row dataRow = sheet.createRow(j);
//			List<String> rowData = data.get(j);
//			dataRow.createCell(j).setCellValue(ele.getDivisionName());
//		}
          
		 rowhead.createCell(0).setCellValue("DIVISION");
         rowhead.createCell(1).setCellValue("ENTRY DATE");
         rowhead.createCell(2).setCellValue("SC_REF_NO");
         rowhead.createCell(3).setCellValue("SC_ENGINEER");
         rowhead.createCell(4).setCellValue("RA_ENGINEER");
        rowhead.createCell(5).setCellValue("FRN_NO");
        rowhead.createCell(6).setCellValue("FRN_DATE");
     //   rowhead.createCell(7).setCellValue("SER_COMM_INWARD_DATE");
        rowhead.createCell(7).setCellValue("SER_CENTRE_RECEIVED_DATE");
      rowhead.createCell(8).setCellValue("STK_CUST");
      rowhead.createCell(9).setCellValue("REGION");
      rowhead.createCell(10).setCellValue("BRANCH");
     // rowhead.createCell(12).setCellValue("ENGINEER_ID");
      rowhead.createCell(11).setCellValue("DEALER_NAME");
      rowhead.createCell(12).setCellValue("CUST_NAME");
      rowhead.createCell(13).setCellValue("SUPPLIER_NAME");
      rowhead.createCell(14).setCellValue("PRODUCT_MODEL");
      rowhead.createCell(15).setCellValue("UNIT_SLNO");
      rowhead.createCell(16).setCellValue("UNIT_STATUS");
      rowhead.createCell(17).setCellValue("MOD_BRD_NAME");
      rowhead.createCell(18).setCellValue("DEF_MOD_BRD_NAME");
      rowhead.createCell(19).setCellValue("DEF_TYPE");
      rowhead.createCell(20).setCellValue("TYPE_OF_ACC");
      rowhead.createCell(21).setCellValue("DEF_GIR_NO");
      rowhead.createCell(22).setCellValue("DEF_UNIT_GIR_NO");
      rowhead.createCell(23).setCellValue("FIELD_REMARKS");
      rowhead.createCell(24).setCellValue("TECHNICAL_REMARKS");
      rowhead.createCell(25).setCellValue("FINAL_REMARKS");
      rowhead.createCell(26).setCellValue("PENDING DAYS ");
      rowhead.createCell(27).setCellValue("TIMESTAMP");

		
		
		for (int j = 1; j < serList.size(); j++) {
			ServiceMaster ele = serList.get(j);
			Row dataRow = sheet.createRow(j);
			dataRow.createCell(0).setCellValue(ele.getDivisionName());
			dataRow.createCell(1).setCellValue(ele.getEntryDate());
			dataRow.createCell(2).setCellValue(ele.getScRefNo());
			dataRow.createCell(3).setCellValue(excelservice.getEmpName(ele.getScEngnr()));
			dataRow.createCell(4).setCellValue(excelservice.getEmpName(ele.getRaEngnr()));
			dataRow.createCell(5).setCellValue(ele.getFrnNo());
			dataRow.createCell(6).setCellValue(ele.getFrnDate());
		//	dataRow.createCell(7).setCellValue(ele.getSerCommInwardDate());
			dataRow.createCell(7).setCellValue(ele.getSerCentreReceivedDate());
			String stk_cust=excelservice.getddvalue(ele.getStkCust()); 
			dataRow.createCell(8).setCellValue(stk_cust);
			dataRow.createCell(9).setCellValue(ele.getCurrentDate().toString());
			dataRow.createCell(10).setCellValue(ele.getRegion());
		//	dataRow.createCell(12).setCellValue(excelservice.getbranchName(ele.getBranch()));
			dataRow.createCell(11).setCellValue(excelservice.getEmpName(ele.getEngineerId()));
			dataRow.createCell(12).setCellValue(ele.getCustName());
			dataRow.createCell(13).setCellValue(ele.getSupplierName());
			dataRow.createCell(14).setCellValue(excelservice.getmodelName(ele.getProductModel()));
			dataRow.createCell(15).setCellValue(ele.getUnitSlno());
			dataRow.createCell(16).setCellValue(excelservice.getddvalue(ele.getUnitStatus()));
			dataRow.createCell(17).setCellValue(ele.getModBrdName());
			dataRow.createCell(18).setCellValue(ele.getDefModBrdName());
			dataRow.createCell(19).setCellValue(excelservice.getddvalue(ele.getDefType()));
			
			dataRow.createCell(20).setCellValue(excelservice.getddvalue(ele.getTypeOfAcc()));
			dataRow.createCell(21).setCellValue(ele.getDefGirNo());
			dataRow.createCell(22).setCellValue(ele.getDefUnitGirNo());
			dataRow.createCell(23).setCellValue(ele.getFieldRemarks());
			dataRow.createCell(24).setCellValue(ele.getTechnicalRemarks());
			dataRow.createCell(25).setCellValue(ele.getFinalRemarks());
			try {
				dataRow.createCell(26).setCellValue(reportservice.getDiffDays(ele.getSerCentreReceivedDate()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				logger.error("Error in parsing date!..");
				logger.error(e.getMessage());
				//e.printStackTrace();
			}
			dataRow.createCell(27).setCellValue(ele.getCurrentDate().toString());
			
		}
		
		for (int j = 0; j < rowhead.getPhysicalNumberOfCells(); j++) {
			sheet.autoSizeColumn(j);
		}
		
		String filename="Under_Repair.xlsx";
		FileOutputStream out = new FileOutputStream(new File(filename));
		wb.write(out);
		wb.close();
		out.close();
       return filename;
	}
	
	
//	public float getDiffDays(String date_from_serCenter) throws ParseException {
//		float diff = 0;
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
//		LocalDateTime current = LocalDateTime.now();
//		LocalDate date1 = LocalDate.parse(date_from_serCenter, dtf);
//		long daysBetween = Duration.between(current, date1).toDays();
//		System.out.println ("Days: " + daysBetween);
//		diff = (daysBetween / (1000*60*60*24));
//		return diff;
//	}


}
