package com.sis.ExcelReport.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branch")
public class BranchMaster {
	
	


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branchid")
    private Integer branchid;
    @Column(name = "companyid")
    private Integer companyid;
    @Column(name = "regionid")
    private Integer regionid;
   //@Size(max = 30)
    @Column(name = "branchname")
    private String branchname;
   //@Size(max = 30)
    @Column(name = "branchlocation")
    private String branchlocation;
   //@Size(max = 150)
    @Column(name = "branchaddress")
    private String branchaddress;
   //@Size(max = 20)
    @Column(name = "branchphone")
    private String branchphone;

    public BranchMaster() {
    }

    public BranchMaster(Integer branchid) {
        this.branchid = branchid;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getRegionid() {
        return regionid;
    }

    public void setRegionid(Integer regionid) {
        this.regionid = regionid;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getBranchlocation() {
        return branchlocation;
    }

    public void setBranchlocation(String branchlocation) {
        this.branchlocation = branchlocation;
    }

    public String getBranchaddress() {
        return branchaddress;
    }

    public void setBranchaddress(String branchaddress) {
        this.branchaddress = branchaddress;
    }

    public String getBranchphone() {
        return branchphone;
    }

    public void setBranchphone(String branchphone) {
        this.branchphone = branchphone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchid != null ? branchid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BranchMaster)) {
            return false;
        }
        BranchMaster other = (BranchMaster) object;
        if ((this.branchid == null && other.branchid != null) || (this.branchid != null && !this.branchid.equals(other.branchid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.schillerindiaservices.bean.Branch[ branchid=" + branchid + " ]";
    }

}
