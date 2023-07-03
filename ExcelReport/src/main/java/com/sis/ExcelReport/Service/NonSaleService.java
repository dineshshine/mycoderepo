package com.sis.ExcelReport.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NonSaleService {

	@Autowired
	ExcelService excelservice;
	
	
	public String createNonSale_PenExcel(List<ServiceMaster> serList) throws IOException {
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
        rowhead.createCell(2).setCellValue("UNIT DETAILS");
        rowhead.createCell(3).setCellValue("FQC INWARD DATE");
        rowhead.createCell(4).setCellValue("BRANCH");
        rowhead.createCell(5).setCellValue("ENGINEER");
        rowhead.createCell(6).setCellValue("SUPPLIER");
        rowhead.createCell(7).setCellValue("MODEL");
        rowhead.createCell(8).setCellValue("MODEL S/N");
        rowhead.createCell(9).setCellValue("UNIT CONFIGURATION");
        rowhead.createCell(10).setCellValue("CUSTOMER NAME");
        rowhead.createCell(11).setCellValue("REPORTED PROBLEM");
        rowhead.createCell(12).setCellValue("DEFECTIVE UNIT RECEIVED DATE");
        rowhead.createCell(13).setCellValue("FQC OBSERVATION");
        rowhead.createCell(14).setCellValue("SC INWARD DATE");
        rowhead.createCell(15).setCellValue("SC ENGINEER");
        rowhead.createCell(16).setCellValue("SC OBSERVATION");
        rowhead.createCell(17).setCellValue("REQUIRED PARTS");
        rowhead.createCell(18).setCellValue("SC ACTION PLAN");
        rowhead.createCell(19).setCellValue("TENTATIVE DATE");
        rowhead.createCell(20).setCellValue("FINAL STATUS");
        rowhead.createCell(21).setCellValue("TIMESTAMP");
		
		for (int j = 1; j < serList.size(); j++) {
			ServiceMaster ele = serList.get(j);
			Row row = sheet.createRow(j);
//            row.createCell(0).setCellValue(ele.getDivisionName());
//            row.createCell(1).setCellValue(ele.getEntryDate());
//            row.createCell(2).setCellValue(ele.unit);
//            row.createCell(3).setCellValue(rs.getString(5));  
//          //  row.createCell(4).setCellValue(rs.getString(6));
//            String branch=BranchDao.getbName(rs.getString(7));
//            row.createCell(4).setCellValue(branch);
//             String emname=EmployeeDao.geteName(rs.getString(8));
//            row.createCell(5).setCellValue(emname);
//       //     String dealer=DealerDao.getdName(rs.getString(9));
//       //     row.createCell(7).setCellValue(dealer);
//            row.createCell(6).setCellValue(rs.getString(10));
//            String model=ModelDao.getModelname(rs.getString(11));
//            row.createCell(7).setCellValue(model);
//            row.createCell(8).setCellValue(rs.getString(12));
//            row.createCell(9).setCellValue(rs.getString(13));
//            row.createCell(10).setCellValue(rs.getString(14));
//            row.createCell(11).setCellValue(rs.getString(15));
//         //   row.createCell(14).setCellValue(rs.getString(16));
//         //    row.createCell(15).setCellValue(rs.getString(17));
//             row.createCell(12).setCellValue(rs.getString(18));
//             row.createCell(13).setCellValue(rs.getString(19));
//             row.createCell(14).setCellValue(rs.getString(20));
//            String engg=EmployeeDao.getname(rs.getString(21));
//             row.createCell(15).setCellValue(engg);
//             row.createCell(16).setCellValue(rs.getString(22));
//             row.createCell(17).setCellValue(rs.getString(23));
//        //     row.createCell(22).setCellValue(rs.getString(24));
//             row.createCell(18).setCellValue(rs.getString(25));
//             row.createCell(19).setCellValue(rs.getString(26));
//       //      row.createCell(25).setCellValue(rs.getString(27));
//       //      row.createCell(26).setCellValue(rs.getString(28));
//             row.createCell(20).setCellValue(rs.getString(29));
//             row.createCell(21).setCellValue(rs.getString(30));
             
// 			dataRow.createCell(0).setCellValue(ele.getDivisionName());
// 			dataRow.createCell(1).setCellValue(excelservice.getEmpName(ele.getScEngnr()));
// 			dataRow.createCell(2).setCellValue(ele.getFrnNo());
// 			dataRow.createCell(3).setCellValue(ele.getSupplierName());
// 			dataRow.createCell(4).setCellValue(excelservice.getmodelName(ele.getProductModel()));
// 			dataRow.createCell(5).setCellValue(ele.getDefModBrdName());
// 			dataRow.createCell(6).setCellValue(excelservice.getddvalue(ele.getDefType()));
// 			dataRow.createCell(7).setCellValue(ele.getDefGirNo());
// 			dataRow.createCell(8).setCellValue(ele.getFinalRemarks());
// 			dataRow.createCell(9).setCellValue(excelservice.getddvalue(ele.getTypeOfWork()));
// 			dataRow.createCell(10).setCellValue(ele.getCurrentDate().toString());
 			
			
		}
		
		for (int j = 0; j < rowhead.getPhysicalNumberOfCells(); j++) {
			sheet.autoSizeColumn(j);
		}
		LocalDate ldt1=LocalDate.now();
		////System.out.println("today date issss");
    	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedString = ldt1.format(formatter);
		String filename="Stocklist'"+formattedString+"'.xlsx";
		FileOutputStream out = new FileOutputStream(new File(filename));
		wb.write(out);
		wb.close();
		out.close();
       return filename;
	}
	
}
