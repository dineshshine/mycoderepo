package com.sis.ExcelReport.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
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

import com.sis.ExcelReport.Model.PrfObMaster;

@Service
public class PRFOBService {
	@Autowired
	ExcelService excelservice;
	
	 Logger logger = LoggerFactory.getLogger(PRFOBService.class);
	
	public String createPrfOBExcel(List<PrfObMaster> serList,String status) throws IOException {
		
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();

		Row rowhead = sheet.createRow(0);
		

		  rowhead.createCell(0).setCellValue("ENTRY DATE");
          rowhead.createCell(1).setCellValue("SC_ENGINEER");
          rowhead.createCell(2).setCellValue("TYPE");
          rowhead.createCell(3).setCellValue("RAISED DATE");
          rowhead.createCell(4).setCellValue("RECEIVED DATE FROM SC");
          rowhead.createCell(5).setCellValue("REGION");
          rowhead.createCell(6).setCellValue("BRANCH");
          rowhead.createCell(7).setCellValue("ENGINEER");
          rowhead.createCell(8).setCellValue("DEALER");
          rowhead.createCell(9).setCellValue("MODEL");
          rowhead.createCell(10).setCellValue("SUPPLIER");
          rowhead.createCell(11).setCellValue("WARRENTY STATUS");
          rowhead.createCell(12).setCellValue("PRF/OB REF NO.");
          rowhead.createCell(13).setCellValue("CRM REF NO.");
          rowhead.createCell(14).setCellValue("PART TYPE");
          rowhead.createCell(15).setCellValue("PART DESCRIPTION");
          rowhead.createCell(16).setCellValue("REMARKS");
          rowhead.createCell(17).setCellValue("STATUS");
          rowhead.createCell(18).setCellValue("EXECUTED DATE");
          rowhead.createCell(19).setCellValue("TIMESTAMP");
          rowhead.createCell(20).setCellValue("SPARES RECEIVED DATE AT SVC");

		
		
		for (int j = 1; j < serList.size(); j++) {
			PrfObMaster ele = serList.get(j);
			Row dataRow = sheet.createRow(j);
			dataRow.createCell(0).setCellValue(ele.getEntryDate());
			dataRow.createCell(1).setCellValue(excelservice.getEmpName(Integer.parseInt(("").equals(ele.getScEngg())? "0":ele.getScEngg())));
			dataRow.createCell(2).setCellValue(ele.getWorkType());
			dataRow.createCell(3).setCellValue(ele.getRaisedDate());
			dataRow.createCell(4).setCellValue(ele.getReceivedDate());
			dataRow.createCell(5).setCellValue(ele.getRegion());
			dataRow.createCell(6).setCellValue(excelservice.getbranchName(ele.getBranch()));
			dataRow.createCell(7).setCellValue(excelservice.getEmpName(Integer.parseInt(ele.getEngineer())));
			dataRow.createCell(8).setCellValue(excelservice.getDealerName(ele.getDealer()));
			//String stk_cust=excelservice.getddvalue(excelservice.getpro); 
			dataRow.createCell(9).setCellValue(ele.getModel());
			dataRow.createCell(10).setCellValue(ele.getSupplier());
			dataRow.createCell(11).setCellValue(ele.getWarrentyStatus());
			dataRow.createCell(12).setCellValue(ele.getPrfobRefNo());
			dataRow.createCell(13).setCellValue(ele.getCrmRefNo());
			dataRow.createCell(14).setCellValue(ele.getPartType());
			dataRow.createCell(15).setCellValue(ele.getPartDescription());
			dataRow.createCell(16).setCellValue(ele.getRemarks());
			dataRow.createCell(17).setCellValue(ele.getStatusType());
			dataRow.createCell(18).setCellValue(ele.getExecutedDate());
			dataRow.createCell(19).setCellValue(ele.getCurrentDate().toString());
			dataRow.createCell(20).setCellValue(ele.getReceive_date_from_sc());
			
		}
		
		for (int j = 0; j < rowhead.getPhysicalNumberOfCells(); j++) {
			sheet.autoSizeColumn(j);
		}
		
		String filename="PRFOB_'"+status+"'.xlsx";
		FileOutputStream out = new FileOutputStream(new File(filename));
		wb.write(out);
		wb.close();
		out.close();
       return filename;
	}
}
