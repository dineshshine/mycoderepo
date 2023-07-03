package com.sis.ExcelReport.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sis.ExcelReport.dao.Branchdao;
import com.sis.ExcelReport.dao.Dealerdao;
import com.sis.ExcelReport.dao.DropDownDao;
import com.sis.ExcelReport.dao.EmployeeDao;
@Service
public class ExcelService {
	@Autowired
	EmployeeDao empdao;
	
	@Autowired
	DropDownDao dropDao;
	
	@Autowired
	Modeldao modeldao;
	
	@Autowired
	Branchdao branchdao;
	
	@Autowired
	Dealerdao dealerdao;

	public String createScrapExcel(List<ServiceMaster> serList) throws IOException {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();	
        int rowIndex = 0;
		Row headerRow = sheet.createRow(rowIndex);
         
		headerRow.createCell(0).setCellValue("DIVISION NAME");
		headerRow.createCell(1).setCellValue("ENTRY DATE");
		headerRow.createCell(2).setCellValue("SC_REF_NO");
		headerRow.createCell(3).setCellValue("SC_ENGINEER");
		headerRow.createCell(4).setCellValue("RA_ENGINEER");
		headerRow.createCell(5).setCellValue("FRN_NO");
		headerRow.createCell(6).setCellValue("SUPPLIER_NAME");
		headerRow.createCell(7).setCellValue("PRODUCT_MODEL");
		headerRow.createCell(8).setCellValue("DEF_MOD_BRD_NAME");
		headerRow.createCell(9).setCellValue("DEF_TYPE");
		headerRow.createCell(10).setCellValue("TYPE_OF_ACC");
		headerRow.createCell(11).setCellValue("DEF_GIR_NO");
		headerRow.createCell(12).setCellValue("TECHNICAL_REMARKS");
		headerRow.createCell(13).setCellValue("FINAL_REMARKS");
		headerRow.createCell(14).setCellValue("TIMESTAMP");
		rowIndex++;
		
		   Iterator<ServiceMaster> itrtr = serList.iterator();
			
			while(itrtr.hasNext()) {
				ServiceMaster ele = itrtr.next();
			Row dataRow = sheet.createRow(rowIndex);
			dataRow.createCell(0).setCellValue(ele.getDivisionName());
			dataRow.createCell(1).setCellValue(ele.getEntryDate());
			dataRow.createCell(2).setCellValue(ele.getScRefNo());
			dataRow.createCell(3).setCellValue(getEmpName(ele.getScEngnr()));
			dataRow.createCell(4).setCellValue(getEmpName(ele.getRaEngnr()));
			dataRow.createCell(5).setCellValue(ele.getFrnNo());
			dataRow.createCell(6).setCellValue(ele.getSupplierName());
			dataRow.createCell(7).setCellValue(getmodelName(ele.getProductModel()));
			dataRow.createCell(8).setCellValue(ele.getDefModBrdName());
			dataRow.createCell(9).setCellValue(getddvalue(ele.getDefType()));
			dataRow.createCell(10).setCellValue(getddvalue(ele.getTypeOfAcc()));
			dataRow.createCell(11).setCellValue(ele.getDefGirNo());
			dataRow.createCell(12).setCellValue(ele.getTechnicalRemarks());
			dataRow.createCell(13).setCellValue(ele.getFinalRemarks());
			dataRow.createCell(14).setCellValue(ele.getCurrentDate().toString());
			rowIndex++;
		}
		
		for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
			sheet.autoSizeColumn(j);
		}
	
    	
		
		String filename="ScrapList.xlsx";
		FileOutputStream out = new FileOutputStream(new File(filename));
		wb.write(out);
		wb.close();
		out.close();
       return filename;
	}
	
	public String createScrapListExcel(List<ServiceMaster> serList) throws IOException {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();

		Row headerRow = sheet.createRow(0);

		headerRow.createCell(0).setCellValue("DIVISION NAME");
		headerRow.createCell(1).setCellValue("ENTRY DATE");
		headerRow.createCell(2).setCellValue("SC_REF_NO");
		headerRow.createCell(3).setCellValue("SC_ENGINEER");
		headerRow.createCell(4).setCellValue("RA_ENGINEER");
		headerRow.createCell(5).setCellValue("FRN_NO");
		headerRow.createCell(6).setCellValue("SUPPLIER_NAME");
		headerRow.createCell(7).setCellValue("PRODUCT_MODEL");
		headerRow.createCell(8).setCellValue("DEF_MOD_BRD_NAME");
		headerRow.createCell(9).setCellValue("DEF_TYPE");
		headerRow.createCell(10).setCellValue("TYPE_OF_ACC");
		headerRow.createCell(11).setCellValue("DEF_GIR_NO");
		headerRow.createCell(12).setCellValue("TECHNICAL_REMARKS");
		headerRow.createCell(13).setCellValue("FINAL_REMARKS");
		headerRow.createCell(14).setCellValue("TIMESTAMP");
		
		
		for (int j = 1; j < serList.size(); j++) {
			ServiceMaster ele = serList.get(j);
			Row dataRow = sheet.createRow(j);
			dataRow.createCell(0).setCellValue(ele.getDivisionName());
			dataRow.createCell(1).setCellValue(ele.getEntryDate());
			dataRow.createCell(2).setCellValue(ele.getScRefNo());
			dataRow.createCell(3).setCellValue(getEmpName(ele.getScEngnr()));
			dataRow.createCell(4).setCellValue(getEmpName(ele.getRaEngnr()));
			dataRow.createCell(5).setCellValue(ele.getFrnNo());
			dataRow.createCell(6).setCellValue(ele.getSupplierName());
			dataRow.createCell(7).setCellValue(getmodelName(ele.getProductModel()));
			dataRow.createCell(8).setCellValue(ele.getDefModBrdName());
			dataRow.createCell(9).setCellValue(getddvalue(ele.getDefType()));
			dataRow.createCell(10).setCellValue(getddvalue(ele.getTypeOfAcc()));
			dataRow.createCell(11).setCellValue(ele.getDefGirNo());
			dataRow.createCell(12).setCellValue(ele.getTechnicalRemarks());
			dataRow.createCell(13).setCellValue(ele.getFinalRemarks());
			dataRow.createCell(14).setCellValue(ele.getCurrentDate().toString());
		}
		
		for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
			sheet.autoSizeColumn(j);
		}
		LocalDate ldt1=LocalDate.now();
		////System.out.println("today date issss");
    	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedString = ldt1.format(formatter);
		String filename="docfile'"+formattedString+"'.xlsx";
		FileOutputStream out = new FileOutputStream(new File(filename));
		wb.write(out);
		wb.close();
		out.close();
       return filename;
	}
	
	
	
	public String createDispatchExcel(List<ServiceMaster> serList) throws IOException {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
        int rowCount = 0;
		Row headerRow = sheet.createRow(rowCount);

		headerRow.createCell(0).setCellValue("SC_ENGINEER");
		headerRow.createCell(1).setCellValue("FRN_NO");
		headerRow.createCell(2).setCellValue("BRANCH");
		headerRow.createCell(3).setCellValue("ENGINEER_ID");
		headerRow.createCell(4).setCellValue("CUST_NAME");
		headerRow.createCell(5).setCellValue("PRODUCT_MODEL");
		headerRow.createCell(6).setCellValue("UNIT_STATUS");
		headerRow.createCell(7).setCellValue("DEF_MOD_BRD_NAME");
		headerRow.createCell(8).setCellValue("DEF_GIR_NO");
		headerRow.createCell(9).setCellValue("REP_GIR_NO");
		headerRow.createCell(10).setCellValue("DEF_UNIT_GIR_NO");
		headerRow.createCell(11).setCellValue("FINAL_REMARKS");
		headerRow.createCell(12).setCellValue("DESTINATION");
		headerRow.createCell(13).setCellValue("SHIPMENT REF NUMBER");
		headerRow.createCell(14).setCellValue("REF DATE");
		rowCount++;
		
        Iterator<ServiceMaster> itrtr = serList.iterator();
		
		while(itrtr.hasNext()) {
			ServiceMaster ele = itrtr.next();
			Row dataRow = sheet.createRow(rowCount);
			dataRow.createCell(0).setCellValue(getEmpName(ele.getScEngnr()));
			dataRow.createCell(1).setCellValue(ele.getFrnNo());
			dataRow.createCell(2).setCellValue(branchdao.findbranchName(Integer.parseInt(ele.getBranch())));
			dataRow.createCell(3).setCellValue(getEmpName(ele.getEngineerId()));
			dataRow.createCell(4).setCellValue(ele.getCustName());
			dataRow.createCell(5).setCellValue(getmodelName(ele.getProductModel()));
			dataRow.createCell(6).setCellValue(getddvalue(ele.getUnitStatus()));
			dataRow.createCell(7).setCellValue(ele.getDefModBrdName());
			dataRow.createCell(8).setCellValue(ele.getDefGirNo());
			dataRow.createCell(9).setCellValue(ele.getRepGirNo());
			dataRow.createCell(10).setCellValue(ele.getDefUnitGirNo());
			dataRow.createCell(11).setCellValue(ele.getFinalRemarks());
			dataRow.createCell(12).setCellValue(ele.getDestination());
			dataRow.createCell(13).setCellValue(ele.getScRefNo());
			dataRow.createCell(14).setCellValue(ele.getCurrentDate().toString());
			rowCount++;
		}
		
		for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
			sheet.autoSizeColumn(j);
		}
		
		String filename="Dispatchlist.xlsx";
		FileOutputStream out = new FileOutputStream(new File(filename));
		wb.write(out);
		wb.close();
		out.close();
       return filename;
	}
	
	public ByteArrayInputStream createServiceExcelReport(List<ServiceMaster> serList) throws IOException, ParseException {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		int rowcount = 0;
		Row rowhead = sheet.createRow(rowcount);

		rowhead.createCell(0).setCellValue("DIVISION");
		rowhead.createCell(1).setCellValue("ENTRY DATE");
		rowhead.createCell(2).setCellValue("SC_REF_NO");
		rowhead.createCell(3).setCellValue("SC_ENGINEER");
		rowhead.createCell(4).setCellValue("RA_ENGINEER");
		rowhead.createCell(5).setCellValue("FRN_NO");
		rowhead.createCell(6).setCellValue("FRN_DATE");
		/*
		 * rowhead.createCell(8).setCellValue("DOCKET_NO");
		 * rowhead.createCell(9).setCellValue("DESPATCH_DATE");
		 */
		rowhead.createCell(7).setCellValue("SER_COMM_INWARD_DATE");
		rowhead.createCell(8).setCellValue("SER_CENTRE_RECEIVED_DATE");
		rowhead.createCell(9).setCellValue("STK_CUST");
		rowhead.createCell(10).setCellValue("REGION");
		rowhead.createCell(11).setCellValue("BRANCH");
		rowhead.createCell(12).setCellValue("ENGINEER");
		rowhead.createCell(13).setCellValue("DEALER_NAME");
		rowhead.createCell(14).setCellValue("CUST_NAME");
		rowhead.createCell(15).setCellValue("SUPPLIER_NAME");
		rowhead.createCell(16).setCellValue("PRODUCT_MODEL");
		rowhead.createCell(17).setCellValue("UNIT_SLNO");
		rowhead.createCell(18).setCellValue("DOD");
		rowhead.createCell(19).setCellValue("UNIT_STATUS");
		rowhead.createCell(20).setCellValue("MOD_BRD_NAME");
		rowhead.createCell(21).setCellValue("DEF_MOD_BRD_NAME");
		rowhead.createCell(22).setCellValue("DEF_TYPE");
		rowhead.createCell(23).setCellValue("TYPE_OF_ACC");
		rowhead.createCell(24).setCellValue("DEF_PART_SN");
		rowhead.createCell(25).setCellValue("DEF_GIR_NO");
		rowhead.createCell(26).setCellValue("REP_TYPE");
		rowhead.createCell(27).setCellValue("REP_GIR_NO");
		rowhead.createCell(28).setCellValue("DEF_UNIT_GIR_NO");
		rowhead.createCell(29).setCellValue("FIELD_REMARKS");
		rowhead.createCell(30).setCellValue("TECHNICAL_REMARKS");
		rowhead.createCell(31).setCellValue("COMPONENTS_USEDFOR_REPAIR");
		rowhead.createCell(32).setCellValue("REPAIRED_BRD_STK_DATE");
		rowhead.createCell(33).setCellValue("FINAL_REMARKS");
		rowhead.createCell(34).setCellValue("TYPE_OF_WORK");
		rowhead.createCell(35).setCellValue("SHIP_DT_FRM_SER_CNTR");
		rowhead.createCell(36).setCellValue("DISP_ADV_NO");
		rowhead.createCell(37).setCellValue("SHIP_DATE_FROM_COMMERCIAL");
		rowhead.createCell(38).setCellValue("DC_NO");
		rowhead.createCell(39).setCellValue("COMRCL_DTL_INV_RMRK");
		rowhead.createCell(40).setCellValue("PENDING DAYS(PFRN)");
		rowhead.createCell(41).setCellValue("PENDING DAYS(OBP)");
		rowhead.createCell(42).setCellValue("PENDING DAYS(URP)");
		rowhead.createCell(43).setCellValue("PENDING DAYS(SCC)");
		rowhead.createCell(44).setCellValue("STATUS");
		rowhead.createCell(45).setCellValue("PART_NUMBER");
		rowhead.createCell(46).setCellValue("COMPATIBLE_MODELS");
		rowhead.createCell(47).setCellValue("COST");
		rowhead.createCell(48).setCellValue("REPORT_TYPE");
		rowhead.createCell(49).setCellValue("CURRENT DATE");
		rowhead.createCell(50).setCellValue("DESTINATION");
		rowhead.createCell(51).setCellValue("MODEL_CONFIG");
		rowcount++;
		Iterator<ServiceMaster> itrtr = serList.iterator();
		
		while(itrtr.hasNext()) {
			ServiceMaster ele = itrtr.next();
			Row dataRow = sheet.createRow(rowcount);
			dataRow.createCell(0).setCellValue(ele.getDivisionName());
			dataRow.createCell(1).setCellValue(ele.getEntryDate());
			// branchdao.findbranchName(Integer.parseInt(ele.getBranch()))
			dataRow.createCell(2).setCellValue(ele.getScRefNo());
			dataRow.createCell(3).setCellValue(getEmpName(ele.getScEngnr()));
			dataRow.createCell(4).setCellValue(getEmpName(ele.getRaEngnr()));
			dataRow.createCell(5).setCellValue(ele.getFrnNo());
			dataRow.createCell(6).setCellValue(ele.getFrnDate());
			dataRow.createCell(7).setCellValue(ele.getSerCommInwardDate());
			dataRow.createCell(8).setCellValue(ele.getSerCentreReceivedDate());
			dataRow.createCell(9).setCellValue(getddvalue(ele.getStkCust()));
			dataRow.createCell(10).setCellValue(ele.getRegion());
			dataRow.createCell(11).setCellValue(branchdao.findbranchName(Integer.parseInt(ele.getBranch())));
			dataRow.createCell(12).setCellValue(getEmpName(ele.getEngineerId()));
			dataRow.createCell(13).setCellValue(getDealerName(ele.getDealerName()));
			dataRow.createCell(14).setCellValue(ele.getCustName());
			dataRow.createCell(15).setCellValue(ele.getSupplierName());
			dataRow.createCell(16).setCellValue(getmodelName(ele.getProductModel()));
			dataRow.createCell(17).setCellValue(ele.getUnitSlno());
			dataRow.createCell(18).setCellValue(ele.getDod());
			dataRow.createCell(19).setCellValue(getddvalue(ele.getUnitStatus()));
			dataRow.createCell(20).setCellValue(ele.getModBrdName());
			dataRow.createCell(21).setCellValue(ele.getDefModBrdName());
			dataRow.createCell(22).setCellValue(ele.getDefType());
			dataRow.createCell(23).setCellValue(getddvalue(ele.getTypeOfAcc()));
			dataRow.createCell(24).setCellValue(ele.getDefPartSn());
			dataRow.createCell(25).setCellValue(ele.getDefGirNo());
			dataRow.createCell(26).setCellValue(getddvalue(ele.getRepType()));
			dataRow.createCell(27).setCellValue(ele.getRepGirNo());
			dataRow.createCell(28).setCellValue(ele.getDefUnitGirNo());
			dataRow.createCell(29).setCellValue(ele.getFieldRemarks());
			dataRow.createCell(30).setCellValue(ele.getTechnicalRemarks());
			dataRow.createCell(31).setCellValue(ele.getComponentsUsedforRepair());
			dataRow.createCell(32).setCellValue(ele.getRepairedBrdStkDate());
			dataRow.createCell(33).setCellValue(ele.getFinalRemarks());
			dataRow.createCell(34).setCellValue(getddvalue(ele.getTypeOfWork()));
			dataRow.createCell(35).setCellValue(ele.getShipDtFrmSerCntr());
			dataRow.createCell(36).setCellValue(ele.getDispAdvNo());
			dataRow.createCell(37).setCellValue(ele.getShipDateFromCommercial());
			dataRow.createCell(38).setCellValue(ele.getDcNo());
			dataRow.createCell(39).setCellValue(ele.getComrclDtlInvRmrk());
			dataRow.createCell(40).setCellValue(getDiffDays(ele.getSerCentreReceivedDate(),ele.getShipDtFrmSerCntr())+" PFR");
			dataRow.createCell(41).setCellValue(getDiffDays(ele.getSerCentreReceivedDate(),ele.getShipDtFrmSerCntr())+" OB");
			dataRow.createCell(42).setCellValue(getDiffDays(ele.getSerCentreReceivedDate(),ele.getRepairedBrdStkDate())+" UR");
			dataRow.createCell(43).setCellValue(getDiffDays(ele.getSerCentreReceivedDate(),ele.getRepairedBrdStkDate())+" SC");
			dataRow.createCell(44).setCellValue(ele.getStatus());
			dataRow.createCell(45).setCellValue(ele.getPart_Number());
			dataRow.createCell(46).setCellValue(ele.getCompatibleModels());
			dataRow.createCell(47).setCellValue(ele.getCost());
			dataRow.createCell(48).setCellValue(ele.getReport_type());
			dataRow.createCell(49).setCellValue(ele.getCurrentDate().toString());
			dataRow.createCell(50).setCellValue(ele.getDestination());
			dataRow.createCell(51).setCellValue(ele.getModelConfig());
		 rowcount++;
		}

		for (int j = 0; j < rowhead.getPhysicalNumberOfCells(); j++) {
			sheet.autoSizeColumn(j);
		}
		
		String filename="ServiceReport.xlsx";
		FileOutputStream out = new FileOutputStream(new File(filename));
		wb.write(out);
		out.close();
		
		ByteArrayOutputStream opstream = new ByteArrayOutputStream();
		wb.write(opstream);
       return new ByteArrayInputStream(opstream.toByteArray());
	}
	
	public long getDiffDays(String serCntrRecDt,String shipdtFrmSerCntr) throws ParseException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");	
		LocalDate current = null;
		LocalDate date1 = null;
		
		if(null == shipdtFrmSerCntr || shipdtFrmSerCntr.isEmpty()){
			current = LocalDate.now();
			date1 = LocalDate.parse(serCntrRecDt, dtf);
		}else {
			current = LocalDate.parse(shipdtFrmSerCntr,dtf);
			date1 = LocalDate.parse(serCntrRecDt, dtf);
		}
		
		long daysBetween = Duration.between(date1.atStartOfDay(),current.atStartOfDay()).toDays();
		return daysBetween;
	}
	
	
	public String getEmpName(Integer id) {
		return empdao.findEmpName(id);
	}
	
	public String getddvalue(String id) {
		if(id != null)
		return dropDao.findDDName(Integer.parseInt(id));
		else
			return "";	
	}
	
	public String getmodelName(String name) {
		
		return modeldao.findModelName(Integer.parseInt(name));
	}
	
   public String getbranchName(String name) {
		
		return branchdao.findbranchName(Integer.parseInt(name));
	}
   
   public String getDealerName(String name) {
		
		return dealerdao.findDealerName(Integer.parseInt(name));
	}
}
