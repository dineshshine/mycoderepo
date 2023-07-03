package com.sis.ExcelReport.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "birmaster")
public class BirMaster {

	
	
	    private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    //@Basic(optional = false)
	    @Column(name = "id")
	    private Integer id;
	    //@Size(max = 100)
	    @Column(name = "division")
	    private String division;
	    //@Size(max = 100)
	    @Column(name = "entry_date")
	    private String entryDate;
	    //@Size(max = 100)
	    @Column(name = "fqc_in_date")
	    private String fqcInDate;
	    //@Size(max = 100)
	    @Column(name = "model")
	    private String model;
	    //@Size(max = 100)
	    @Column(name = "configuration")
	    private String configuration;
	    //@Size(max = 100)
	    @Column(name = "received_qty")
	    private String receivedQty;
	    //@Size(max = 100)
	    @Column(name = "unit_serial_no")
	    private String unitSerialNo;
	    //@Size(max = 100)
	    @Column(name = "invoice_no")
	    private String invoiceNo;
	    //@Size(max = 100)
	    @Column(name = "invoice_date")
	    private String invoiceDate;
	    //@Size(max = 100)
	    @Column(name = "softwr_changes")
	    private String softwrChanges;
	    //@Size(max = 100)
	    @Column(name = "softwr_version")
	    private String softwrVersion;
	    //@Size(max = 100)
	    @Column(name = "hardwr_changes")
	    private String hardwrChanges;
	    //@Size(max = 100)
	    @Column(name = "hardware_details")
	    private String hardwareDetails;
	    //@Size(max = 100)
	    @Column(name = "accesory_changes")
	    private String accesoryChanges;
	    //@Size(max = 100)
	    @Column(name = "accesory_details")
	    private String accesoryDetails;
	    //@Size(max = 100)
	    @Column(name = "user_manual_update")
	    private String userManualUpdate;
	    //@Size(max = 100)
	    @Column(name = "service_manual_update")
	    private String serviceManualUpdate;
	    //@Size(max = 100)
	    @Column(name = "fqc_remarks")
	    private String fqcRemarks;
	    //@Size(max = 100)
	    @Column(name = "cnr_ref_no")
	    private String cnrRefNo;
	    //@Size(max = 100)
	    @Column(name = "ts_team_verification_date")
	    private String tsTeamRemark;
	    //@Size(max = 100)
	    @Column(name = "ps_team_verification_date")
	    private String psTeamRemark;
	    //@Size(max = 100)
	    @Column(name = "final_status")
	    private String finalStatus;
	   // @Basic(optional = false)
	    // @NotNull
	    //@Size(min = 1, max = 100)
	    @Column(name = "closed_date")
	    private String closedDate;
	   // @Basic(optional = false)
	    // @NotNull
	    //@Size(min = 1, max = 100)
	    @Column(name = "acces_chng_remark")
	    private String accesChngRemark;
	   // @Basic(optional = false)
	    // @NotNull
	    //@Size(min = 1, max = 100)
	    @Column(name = "hrdwr_chang_remark")
	    private String hrdwrChangRemark;
	   // @Basic(optional = false)
	    // @NotNull
	    //@Size(min = 1, max = 100)
	    @Column(name = "sftwr_chng_remark")
	    private String sftwrChngRemark;
	   // @Basic(optional = false)
	    // @NotNull
	    //@Size(min = 1, max = 100)
	    @Column(name = "cnr_relese_date")
	    private String cnrReleseDate;
	   // @Basic(optional = false)
	    // @NotNull
	    //@Size(min = 1, max = 100)
	    @Column(name = "bir_ref_no")
	    private String birRefNo;
	   // @Basic(optional = false)
	    // @NotNull
	    //@Size(min = 1, max = 100)
	    @Column(name = "supplier")
	    private String supplier;
	   // @Basic(optional = false)
	    // @NotNull
	    //@Size(min = 1, max = 100)
	    @Column(name = "sc_engg")
	    private String scEngg;
	   // @Basic(optional = false)
	    // @NotNull
	    //@Size(min = 1, max = 100)
	    @Column(name = "ps_engg")
	    private String psEngg;
	   // @Basic(optional = false)
	    // @NotNull
	    //@Size(min = 1, max = 100)
	    @Column(name = "approved_date")
	    private String approvedDate;
	   // @Basic(optional = false)
	    // @NotNull
	    //@Size(min = 1, max = 100)
	    @Column(name = "cnr_tec_ref_num")
	    private String cnrTecRefNum;
	    //@Size(max = 100)
	    @Column(name = "unit_in_date")
	    private String unitInDate;
	    //@Size(max = 1000)
	    @Column(name = "tech_remarks")
	    private String techRemarks;
	    //@Size(max = 100)
	    @Column(name = "current_date")
	    private Date currentDate;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getDivision() {
			return division;
		}
		public void setDivision(String division) {
			this.division = division;
		}
		public String getEntryDate() {
			return entryDate;
		}
		public void setEntryDate(String entryDate) {
			this.entryDate = entryDate;
		}
		public String getFqcInDate() {
			return fqcInDate;
		}
		public void setFqcInDate(String fqcInDate) {
			this.fqcInDate = fqcInDate;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public String getConfiguration() {
			return configuration;
		}
		public void setConfiguration(String configuration) {
			this.configuration = configuration;
		}
		public String getReceivedQty() {
			return receivedQty;
		}
		public void setReceivedQty(String receivedQty) {
			this.receivedQty = receivedQty;
		}
		public String getUnitSerialNo() {
			return unitSerialNo;
		}
		public void setUnitSerialNo(String unitSerialNo) {
			this.unitSerialNo = unitSerialNo;
		}
		public String getInvoiceNo() {
			return invoiceNo;
		}
		public void setInvoiceNo(String invoiceNo) {
			this.invoiceNo = invoiceNo;
		}
		public String getInvoiceDate() {
			return invoiceDate;
		}
		public void setInvoiceDate(String invoiceDate) {
			this.invoiceDate = invoiceDate;
		}
		public String getSoftwrChanges() {
			return softwrChanges;
		}
		public void setSoftwrChanges(String softwrChanges) {
			this.softwrChanges = softwrChanges;
		}
		public String getSoftwrVersion() {
			return softwrVersion;
		}
		public void setSoftwrVersion(String softwrVersion) {
			this.softwrVersion = softwrVersion;
		}
		public String getHardwrChanges() {
			return hardwrChanges;
		}
		public void setHardwrChanges(String hardwrChanges) {
			this.hardwrChanges = hardwrChanges;
		}
		public String getHardwareDetails() {
			return hardwareDetails;
		}
		public void setHardwareDetails(String hardwareDetails) {
			this.hardwareDetails = hardwareDetails;
		}
		public String getAccesoryChanges() {
			return accesoryChanges;
		}
		public void setAccesoryChanges(String accesoryChanges) {
			this.accesoryChanges = accesoryChanges;
		}
		public String getAccesoryDetails() {
			return accesoryDetails;
		}
		public void setAccesoryDetails(String accesoryDetails) {
			this.accesoryDetails = accesoryDetails;
		}
		public String getUserManualUpdate() {
			return userManualUpdate;
		}
		public void setUserManualUpdate(String userManualUpdate) {
			this.userManualUpdate = userManualUpdate;
		}
		public String getServiceManualUpdate() {
			return serviceManualUpdate;
		}
		public void setServiceManualUpdate(String serviceManualUpdate) {
			this.serviceManualUpdate = serviceManualUpdate;
		}
		public String getFqcRemarks() {
			return fqcRemarks;
		}
		public void setFqcRemarks(String fqcRemarks) {
			this.fqcRemarks = fqcRemarks;
		}
		public String getCnrRefNo() {
			return cnrRefNo;
		}
		public void setCnrRefNo(String cnrRefNo) {
			this.cnrRefNo = cnrRefNo;
		}
		public String getTsTeamRemark() {
			return tsTeamRemark;
		}
		public void setTsTeamRemark(String tsTeamRemark) {
			this.tsTeamRemark = tsTeamRemark;
		}
		public String getPsTeamRemark() {
			return psTeamRemark;
		}
		public void setPsTeamRemark(String psTeamRemark) {
			this.psTeamRemark = psTeamRemark;
		}
		public String getFinalStatus() {
			return finalStatus;
		}
		public void setFinalStatus(String finalStatus) {
			this.finalStatus = finalStatus;
		}
		public String getClosedDate() {
			return closedDate;
		}
		public void setClosedDate(String closedDate) {
			this.closedDate = closedDate;
		}
		public String getAccesChngRemark() {
			return accesChngRemark;
		}
		public void setAccesChngRemark(String accesChngRemark) {
			this.accesChngRemark = accesChngRemark;
		}
		public String getHrdwrChangRemark() {
			return hrdwrChangRemark;
		}
		public void setHrdwrChangRemark(String hrdwrChangRemark) {
			this.hrdwrChangRemark = hrdwrChangRemark;
		}
		public String getSftwrChngRemark() {
			return sftwrChngRemark;
		}
		public void setSftwrChngRemark(String sftwrChngRemark) {
			this.sftwrChngRemark = sftwrChngRemark;
		}
		public String getCnrReleseDate() {
			return cnrReleseDate;
		}
		public void setCnrReleseDate(String cnrReleseDate) {
			this.cnrReleseDate = cnrReleseDate;
		}
		public String getBirRefNo() {
			return birRefNo;
		}
		public void setBirRefNo(String birRefNo) {
			this.birRefNo = birRefNo;
		}
		public String getSupplier() {
			return supplier;
		}
		public void setSupplier(String supplier) {
			this.supplier = supplier;
		}
		public String getScEngg() {
			return scEngg;
		}
		public void setScEngg(String scEngg) {
			this.scEngg = scEngg;
		}
		public String getPsEngg() {
			return psEngg;
		}
		public void setPsEngg(String psEngg) {
			this.psEngg = psEngg;
		}
		public String getApprovedDate() {
			return approvedDate;
		}
		public void setApprovedDate(String approvedDate) {
			this.approvedDate = approvedDate;
		}
		public String getCnrTecRefNum() {
			return cnrTecRefNum;
		}
		public void setCnrTecRefNum(String cnrTecRefNum) {
			this.cnrTecRefNum = cnrTecRefNum;
		}
		public String getUnitInDate() {
			return unitInDate;
		}
		public void setUnitInDate(String unitInDate) {
			this.unitInDate = unitInDate;
		}
		public String getTechRemarks() {
			return techRemarks;
		}
		public void setTechRemarks(String techRemarks) {
			this.techRemarks = techRemarks;
		}
		public Date getCurrentDate() {
			return currentDate;
		}
		public void setCurrentDate(Date currentDate) {
			this.currentDate = currentDate;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		@Override
		public String toString() {
			return "BirMaster [id=" + id + ", division=" + division + ", entryDate=" + entryDate + ", fqcInDate="
					+ fqcInDate + ", model=" + model + ", configuration=" + configuration + ", receivedQty="
					+ receivedQty + ", unitSerialNo=" + unitSerialNo + ", invoiceNo=" + invoiceNo + ", invoiceDate="
					+ invoiceDate + ", softwrChanges=" + softwrChanges + ", softwrVersion=" + softwrVersion
					+ ", hardwrChanges=" + hardwrChanges + ", hardwareDetails=" + hardwareDetails + ", accesoryChanges="
					+ accesoryChanges + ", accesoryDetails=" + accesoryDetails + ", userManualUpdate="
					+ userManualUpdate + ", serviceManualUpdate=" + serviceManualUpdate + ", fqcRemarks=" + fqcRemarks
					+ ", cnrRefNo=" + cnrRefNo + ", tsTeamRemark=" + tsTeamRemark + ", psTeamRemark=" + psTeamRemark
					+ ", finalStatus=" + finalStatus + ", closedDate=" + closedDate + ", accesChngRemark="
					+ accesChngRemark + ", hrdwrChangRemark=" + hrdwrChangRemark + ", sftwrChngRemark="
					+ sftwrChngRemark + ", cnrReleseDate=" + cnrReleseDate + ", birRefNo=" + birRefNo + ", supplier="
					+ supplier + ", scEngg=" + scEngg + ", psEngg=" + psEngg + ", approvedDate=" + approvedDate
					+ ", cnrTecRefNum=" + cnrTecRefNum + ", unitInDate=" + unitInDate + ", techRemarks=" + techRemarks
					+ ", currentDate=" + currentDate + "]";
		}
	    
	    
	  

}
