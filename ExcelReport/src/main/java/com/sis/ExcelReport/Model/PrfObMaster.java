package com.sis.ExcelReport.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prfobmaster")
public class PrfObMaster {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
   //@Size(max = 100)
    @Column(name = "division")
    private String division;
   //@Size(max = 100)
    @Column(name = "entry_date")
    private String entryDate;
   //@Size(max = 100)
    @Column(name = "sc_engg")
    private String scEngg;
   //@Size(max = 100)
    @Column(name = "work_type")
    private String workType;
   //@Size(max = 100)
    @Column(name = "raised_date")
    private String raisedDate;
   //@Size(max = 100)
    @Column(name = "received_date")
    private String receivedDate;
   //@Size(max = 100)
    @Column(name = "region")
    private String region;
   //@Size(max = 100)
    @Column(name = "branch")
    private String branch;
   //@Size(max = 100)
    @Column(name = "engineer")
    private String engineer;
   //@Size(max = 100)
    @Column(name = "dealer")
    private String dealer;
   //@Size(max = 100)
    @Column(name = "model")
    private String model;
   //@Size(max = 100)
    @Column(name = "warrenty_status")
    private String warrentyStatus;
   //@Size(max = 100)
    @Column(name = "prfob_ref_no")
    private String prfobRefNo;
   //@Size(max = 100)
    @Column(name = "crm_ref_no")
    private String crmRefNo;
   //@Size(max = 100)
    @Column(name = "remarks")
    private String remarks;
   //@Size(max = 100)
    @Column(name = "status_type")
    private String statusType;
   //@Size(max = 100)
    @Column(name = "executed_date")
    private String executedDate;
   //@Size(max = 100)
    @Column(name = "rec_dt_frm_sc")
    private String receive_date_from_sc;
   //@Size(max = 100)
    @Column(name = "part_type")
    private String partType;
   //@Size(max = 100)
    @Column(name = "part_description")
    private String partDescription;

   //@Size(max = 100)
    @Column(name = "supplier")
    private String supplier;
    
  //@Size(max = 100)
    @Column(name = "currentdate_time")
    private Date currentDate;
    
    

    public PrfObMaster() {
    }

    public PrfObMaster(Integer id) {
        this.id = id;
    }

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

    public String getScEngg() {
        return scEngg;
    }

    public void setScEngg(String scEngg) {
        this.scEngg = scEngg;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getRaisedDate() {
        return raisedDate;
    }

    public void setRaisedDate(String raisedDate) {
        this.raisedDate = raisedDate;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
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

    public String getEngineer() {
        return engineer;
    }

    public void setEngineer(String engineer) {
        this.engineer = engineer;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getWarrentyStatus() {
        return warrentyStatus;
    }

    public void setWarrentyStatus(String warrentyStatus) {
        this.warrentyStatus = warrentyStatus;
    }

    public String getPrfobRefNo() {
        return prfobRefNo;
    }

    public void setPrfobRefNo(String prfobRefNo) {
        this.prfobRefNo = prfobRefNo;
    }

    public String getCrmRefNo() {
        return crmRefNo;
    }

    public void setCrmRefNo(String crmRefNo) {
        this.crmRefNo = crmRefNo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public String getExecutedDate() {
        return executedDate;
    }

    public void setExecutedDate(String executedDate) {
        this.executedDate = executedDate;
    }

    
    public String getReceive_date_from_sc() {
		return receive_date_from_sc;
	}

	public void setReceive_date_from_sc(String receive_date_from_sc) {
		this.receive_date_from_sc = receive_date_from_sc;
	}

	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    
    
}
