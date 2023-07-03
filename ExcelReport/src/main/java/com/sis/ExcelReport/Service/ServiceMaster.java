package com.sis.ExcelReport.Service;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_master")
public class ServiceMaster {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ser_id")
	    private Integer serId;
	    @Column(name = "division")
	    private Integer division;
	    @Column(name = "entry_date")
	    private String entryDate;
	   //@Size(max = 100)
	    @Column(name = "sc_ref_no")
	    private String scRefNo;
	    @Column(name = "sc_engnr")
	    private Integer scEngnr;
	    @Column(name = "ra_engnr")
	    private Integer raEngnr;
	   //@Size(max = 100)
	    @Column(name = "frn_no")
	    private String frnNo;
	   //@Size(max = 50)
	    @Column(name = "frn_date")
	    private String frnDate;
	   //@Size(max = 100)
	    @Column(name = "docket_no")
	    private String docketNo;
	   //@Size(max = 50)
	    @Column(name = "despatch_date")
	    private String despatchDate;
	   //@Size(max = 50)
	    @Column(name = "ser_comm_inward_date")
	    private String serCommInwardDate;
	   //@Size(max = 50)
	    @Column(name = "ser_centre_received_date")
	    private String serCentreReceivedDate;
	   //@Size(max = 100)
	    @Column(name = "stk_cust")
	    private String stkCust;
	   //@Size(max = 100)
	    @Column(name = "region")
	    private String region;
	   //@Size(max = 100)
	    @Column(name = "branch")
	    private String branch;
	    @Column(name = "engineer_id")
	    private Integer engineerId;
	   //@Size(max = 100)
	    @Column(name = "dealer_name")
	    private String dealerName;
	   //@Size(max = 100)
	    @Column(name = "cust_name")
	    private String custName;
	   //@Size(max = 100)
	    @Column(name = "supplier_name")
	    private String supplierName;
	   //@Size(max = 55)
	    @Column(name = "product_model")
	    private String productModel;
	   //@Size(max = 100)
	    @Column(name = "unit_slno")
	    private String unitSlno;
	   //@Size(max = 50)
	    @Column(name = "dod")
	    private String dod;
	   //@Size(max = 100)
	    @Column(name = "unit_status")
	    private String unitStatus;
	   //@Size(max = 100)
	    @Column(name = "mod_brd_name")
	    private String modBrdName;
	   //@Size(max = 100)
	    @Column(name = "def_mod_brd_name")
	    private String defModBrdName;
	   //@Size(max = 100)
	    @Column(name = "def_type")
	    private String defType;
	   //@Size(max = 100)
	    @Column(name = "type_of_acc")
	    private String typeOfAcc;
	   //@Size(max = 100)
	    @Column(name = "def_part_sn")
	    private String defPartSn;
	   //@Size(max = 100)
	    @Column(name = "def_gir_no")
	    private String defGirNo;
	   //@Size(max = 100)
	    @Column(name = "rep_type")
	    private String repType;
	   //@Size(max = 100)
	    @Column(name = "rep_gir_no")
	    private String repGirNo;
	   //@Size(max = 100)
	    @Column(name = "def_unit_gir_no")
	    private String defUnitGirNo;
	   //@Size(max = 100)
	    @Column(name = "field_remarks")
	    private String fieldRemarks;
	   //@Size(max = 100)
	    @Column(name = "technical_remarks")
	    private String technicalRemarks;
	   //@Size(max = 200)
	    @Column(name = "components_usedfor_repair")
	    private String componentsUsedforRepair;
	   //@Size(max = 50)
	    @Column(name = "repaired_brd_stk_date")
	    private String repairedBrdStkDate;
	   //@Size(max = 100)
	    @Column(name = "final_remarks")
	    private String finalRemarks;
	   //@Size(max = 100)
	    @Column(name = "type_of_work")
	    private String typeOfWork;
	   //@Size(max = 50)
	    @Column(name = "ship_dt_frm_ser_cntr")
	    private String shipDtFrmSerCntr;
	   //@Size(max = 100)
	    @Column(name = "disp_adv_no")
	    private String dispAdvNo;
	   //@Size(max = 50)
	    @Column(name = "ship_date_from_commercial")
	    private String shipDateFromCommercial;
	   //@Size(max = 100)
	    @Column(name = "dc_no")
	    private String dcNo;
	   //@Size(max = 100)
	    @Column(name = "comrcl_dtl_inv_rmrk")
	    private String comrclDtlInvRmrk;
	   //@Size(max = 100)
	    @Column(name = "division_name")
	    private String divisionName;
	   //@Size(max = 50)
	    @Column(name = "month")
	    private String month;
	   //@Size(max = 50)
	    @Column(name = "year")
	    private String year;
	   //@Size(max = 100)
	    @Column(name = "repaired_brd_adv_no")
	    private String repairedBrdAdvNo;
	   //@Size(max = 1000)
	    @Column(name = "model_config")
	    private String modelConfig;
	   //@Size(max = 1000)
	    @Column(name = "status")
	    private String status;
	    
	   //@Size(max = 100)
	    @Column(name = "part_number")
	    private String part_Number;
	   //@Size(max = 100)
	    @Column(name = "compatible_models")
	    private String compatibleModels;
	    @Column(name = "cost")
	    private double cost;
	    @Column(name = "currentDate")
	    private Date currentDate;
	   //@Size(max = 100)
	    @Column(name = "report_type")
	    private String report_type;
	   //@Size(max = 100)
	    @Column(name = "destination")
	    private String destination;
	   //@Size(max = 100)
	    @Column(name = "repair_status")
	    private String repair_status;
	    
	    
	    public ServiceMaster() {
	    }

	    public ServiceMaster(Integer serId) {
	        this.serId = serId;
	    }

	    public Integer getSerId() {
	        return serId;
	    }

	    public void setSerId(Integer serId) {
	        this.serId = serId;
	    }

	    public Integer getDivision() {
	        return division;
	    }

	    public void setDivision(Integer division) {
	        this.division = division;
	    }

	    public String getEntryDate() {
	        return entryDate;
	    }

	    public void setEntryDate(String entryDate) {
	        this.entryDate = entryDate;
	    }

	    public String getScRefNo() {
	        return scRefNo;
	    }

	    public void setScRefNo(String scRefNo) {
	        this.scRefNo = scRefNo;
	    }

	    public Integer getScEngnr() {
	        return scEngnr;
	    }

	    public void setScEngnr(Integer scEngnr) {
	        this.scEngnr = scEngnr;
	    }

	    public Integer getRaEngnr() {
	        return raEngnr;
	    }

	    public void setRaEngnr(Integer raEngnr) {
	        this.raEngnr = raEngnr;
	    }

	    public String getFrnNo() {
	        return frnNo;
	    }

	    public void setFrnNo(String frnNo) {
	        this.frnNo = frnNo;
	    }

	    public String getFrnDate() {
	        return frnDate;
	    }

	    public void setFrnDate(String frnDate) {
	        this.frnDate = frnDate;
	    }

	    public String getDocketNo() {
	        return docketNo;
	    }

	    public void setDocketNo(String docketNo) {
	        this.docketNo = docketNo;
	    }

	    public String getDespatchDate() {
	        return despatchDate;
	    }

	    public void setDespatchDate(String despatchDate) {
	        this.despatchDate = despatchDate;
	    }

	    public String getSerCommInwardDate() {
	        return serCommInwardDate;
	    }

	    public void setSerCommInwardDate(String serCommInwardDate) {
	        this.serCommInwardDate = serCommInwardDate;
	    }

	    public String getSerCentreReceivedDate() {
	        return serCentreReceivedDate;
	    }

	    public void setSerCentreReceivedDate(String serCentreReceivedDate) {
	        this.serCentreReceivedDate = serCentreReceivedDate;
	    }

	    public String getStkCust() {
	        return stkCust;
	    }

	    public void setStkCust(String stkCust) {
	        this.stkCust = stkCust;
	    }

	    public String getRegion() {
	        return region;
	    }

	    public void setRegion(String region) {
	        this.region = region;
	    }

	    public String getBranch() {
	        return branch;
	    }

	    public void setBranch(String branch) {
	        this.branch = branch;
	    }

	    public Integer getEngineerId() {
	        return engineerId;
	    }

	    public void setEngineerId(Integer engineerId) {
	        this.engineerId = engineerId;
	    }

	    public String getDealerName() {
	        return dealerName;
	    }

	    public void setDealerName(String dealerName) {
	        this.dealerName = dealerName;
	    }

	    public String getCustName() {
	        return custName;
	    }

	    public void setCustName(String custName) {
	        this.custName = custName;
	    }

	    public String getSupplierName() {
	        return supplierName;
	    }

	    public void setSupplierName(String supplierName) {
	        this.supplierName = supplierName;
	    }

	    public String getProductModel() {
	        return productModel;
	    }

	    public void setProductModel(String productModel) {
	        this.productModel = productModel;
	    }

	    public String getUnitSlno() {
	        return unitSlno;
	    }

	    public void setUnitSlno(String unitSlno) {
	        this.unitSlno = unitSlno;
	    }

	    public String getDod() {
	        return dod;
	    }

	    public void setDod(String dod) {
	        this.dod = dod;
	    }

	    public String getUnitStatus() {
	        return unitStatus;
	    }

	    public void setUnitStatus(String unitStatus) {
	        this.unitStatus = unitStatus;
	    }

	    public String getModBrdName() {
	        return modBrdName;
	    }

	    public void setModBrdName(String modBrdName) {
	        this.modBrdName = modBrdName;
	    }

	    public String getDefModBrdName() {
	        return defModBrdName;
	    }

	    public void setDefModBrdName(String defModBrdName) {
	        this.defModBrdName = defModBrdName;
	    }

	    public String getDefType() {
	        return defType;
	    }

	    public void setDefType(String defType) {
	        this.defType = defType;
	    }

	    public String getTypeOfAcc() {
	        return typeOfAcc;
	    }

	    public void setTypeOfAcc(String typeOfAcc) {
	        this.typeOfAcc = typeOfAcc;
	    }

	    public String getDefPartSn() {
	        return defPartSn;
	    }

	    public void setDefPartSn(String defPartSn) {
	        this.defPartSn = defPartSn;
	    }

	    public String getDefGirNo() {
	        return defGirNo;
	    }

	    public void setDefGirNo(String defGirNo) {
	        this.defGirNo = defGirNo;
	    }

	    public String getRepType() {
	        return repType;
	    }

	    public void setRepType(String repType) {
	        this.repType = repType;
	    }

	    public String getRepGirNo() {
	        return repGirNo;
	    }

	    public void setRepGirNo(String repGirNo) {
	        this.repGirNo = repGirNo;
	    }

	    public String getDefUnitGirNo() {
	        return defUnitGirNo;
	    }

	    public void setDefUnitGirNo(String defUnitGirNo) {
	        this.defUnitGirNo = defUnitGirNo;
	    }

	    public String getFieldRemarks() {
	        return fieldRemarks;
	    }

	    public void setFieldRemarks(String fieldRemarks) {
	        this.fieldRemarks = fieldRemarks;
	    }

	    public String getTechnicalRemarks() {
	        return technicalRemarks;
	    }

	    public void setTechnicalRemarks(String technicalRemarks) {
	        this.technicalRemarks = technicalRemarks;
	    }

	    public String getComponentsUsedforRepair() {
	        return componentsUsedforRepair;
	    }

	    public void setComponentsUsedforRepair(String componentsUsedforRepair) {
	        this.componentsUsedforRepair = componentsUsedforRepair;
	    }

	    public String getRepairedBrdStkDate() {
	        return repairedBrdStkDate;
	    }

	    public void setRepairedBrdStkDate(String repairedBrdStkDate) {
	        this.repairedBrdStkDate = repairedBrdStkDate;
	    }

	    public String getFinalRemarks() {
	        return finalRemarks;
	    }

	    public void setFinalRemarks(String finalRemarks) {
	        this.finalRemarks = finalRemarks;
	    }

	    public String getTypeOfWork() {
	        return typeOfWork;
	    }

	    public void setTypeOfWork(String typeOfWork) {
	        this.typeOfWork = typeOfWork;
	    }

	    public String getShipDtFrmSerCntr() {
	        return shipDtFrmSerCntr;
	    }

	    public void setShipDtFrmSerCntr(String shipDtFrmSerCntr) {
	        this.shipDtFrmSerCntr = shipDtFrmSerCntr;
	    }

	    public String getDispAdvNo() {
	        return dispAdvNo;
	    }

	    public void setDispAdvNo(String dispAdvNo) {
	        this.dispAdvNo = dispAdvNo;
	    }

	    public String getShipDateFromCommercial() {
	        return shipDateFromCommercial;
	    }

	    public void setShipDateFromCommercial(String shipDateFromCommercial) {
	        this.shipDateFromCommercial = shipDateFromCommercial;
	    }

	    public String getDcNo() {
	        return dcNo;
	    }

	    public void setDcNo(String dcNo) {
	        this.dcNo = dcNo;
	    }

	    public String getComrclDtlInvRmrk() {
	        return comrclDtlInvRmrk;
	    }

	    public void setComrclDtlInvRmrk(String comrclDtlInvRmrk) {
	        this.comrclDtlInvRmrk = comrclDtlInvRmrk;
	    }

	    public String getDivisionName() {
	        return divisionName;
	    }

	    public void setDivisionName(String divisionName) {
	        this.divisionName = divisionName;
	    }

	    public String getMonth() {
	        return month;
	    }

	    public void setMonth(String month) {
	        this.month = month;
	    }

	    public String getYear() {
	        return year;
	    }

	    public void setYear(String year) {
	        this.year = year;
	    }

	    public String getRepairedBrdAdvNo() {
	        return repairedBrdAdvNo;
	    }

	    public void setRepairedBrdAdvNo(String repairedBrdAdvNo) {
	        this.repairedBrdAdvNo = repairedBrdAdvNo;
	    }

	    public String getModelConfig() {
	        return modelConfig;
	    }

	    public void setModelConfig(String modelConfig) {
	        this.modelConfig = modelConfig;
	    }
	    
	    
	    

	    public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
		

		public String getPart_Number() {
			return part_Number;
		}

		public void setPart_Number(String part_Number) {
			this.part_Number = part_Number;
		}

		public String getCompatibleModels() {
			return compatibleModels;
		}

		public void setCompatibleModels(String compatibleModels) {
			this.compatibleModels = compatibleModels;
		}

		public double getCost() {
			return cost;
		}

		public void setCost(double cost) {
			this.cost = cost;
		}
		
		
		
		
		
		
		

		public Date getCurrentDate() {
			return currentDate;
		}

		public void setCurrentDate(Date currentdate) {
			this.currentDate = currentdate;
		}

		
		
		
		
		
		
		
		
		
		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		public String getReport_type() {
			return report_type;
		}

		public void setReport_type(String report_type) {
			this.report_type = report_type;
		}
		
		

		public String getRepair_status() {
			return repair_status;
		}

		public void setRepair_status(String repair_status) {
			this.repair_status = repair_status;
		}

		@Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (serId != null ? serId.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof ServiceMaster)) {
	            return false;
	        }
	        ServiceMaster other = (ServiceMaster) object;
	        if ((this.serId == null && other.serId != null) || (this.serId != null && !this.serId.equals(other.serId))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "com.schillerindiaservices.bean.service_master[ serId=" + serId + " ]";
	    }
	
}
