package com.sis.ExcelReport.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockReportService {

	@Autowired
	ExcelService excelservice;

	public String createStockExcel(List<ServiceMaster> serList) throws IOException {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		int rowIndex = 0;
		Row headerRow = sheet.createRow(rowIndex);

//		for(int i=0;i<headerMap.size();i++) {
//			headerRow.createCell(i).setCellValue(headerMap.get(i));
//		}
//		
//		for (int j = 1; j < data.size(); j++) {
//			Row dataRow = sheet.createRow(j);
//			List<String> rowData = data.get(j);
//			dataRow.createCell(j).setCellValue(ele.getDivisionName());
//		}

		headerRow.createCell(0).setCellValue("DIVISION NAME");
		headerRow.createCell(1).setCellValue("SC_ENGINEER");
		headerRow.createCell(2).setCellValue("FRN_NO");
		headerRow.createCell(3).setCellValue("SUPPLIER_NAME");
		headerRow.createCell(4).setCellValue("PRODUCT_MODEL");
		headerRow.createCell(5).setCellValue("DEF_MOD_BRD_NAME");
		headerRow.createCell(6).setCellValue("DEF_TYPE");
		headerRow.createCell(7).setCellValue("DEF_GIR_NO");
		headerRow.createCell(8).setCellValue("FINAL_REMARKS");
		headerRow.createCell(9).setCellValue("TYPE_OF_WORK");
		headerRow.createCell(10).setCellValue("TIMESTAMP");
		rowIndex++;

		Iterator<ServiceMaster> itrtr = serList.iterator();

		while (itrtr.hasNext()) {
			ServiceMaster ele = itrtr.next();
			Row dataRow = sheet.createRow(rowIndex);
			dataRow.createCell(0).setCellValue(ele.getDivisionName());
			dataRow.createCell(1).setCellValue(excelservice.getEmpName(ele.getScEngnr()));
			dataRow.createCell(2).setCellValue(ele.getFrnNo());
			dataRow.createCell(3).setCellValue(ele.getSupplierName());
			dataRow.createCell(4).setCellValue(excelservice.getmodelName(ele.getProductModel()));
			dataRow.createCell(5).setCellValue(ele.getDefModBrdName());
			dataRow.createCell(6).setCellValue(excelservice.getddvalue(ele.getDefType()));
			dataRow.createCell(7).setCellValue(ele.getDefGirNo());
			dataRow.createCell(8).setCellValue(ele.getFinalRemarks());
			dataRow.createCell(9).setCellValue(excelservice.getddvalue(ele.getTypeOfWork()));
			dataRow.createCell(10).setCellValue(ele.getCurrentDate().toString());
			rowIndex++;
		}

		for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
			sheet.autoSizeColumn(j);
		}

		String filename = "Stocklist.xlsx";
		FileOutputStream out = new FileOutputStream(new File(filename));
		wb.write(out);
		wb.close();
		out.close();
		return filename;
	}
}
