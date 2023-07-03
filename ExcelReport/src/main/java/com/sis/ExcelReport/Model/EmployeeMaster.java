package com.sis.ExcelReport.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emploeemaster")
public class EmployeeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "emp_id")
    private Integer empId;
    //@Size(max = 100)
    @Column(name = "emp_name")
    private String empName;
    //@Size(max = 100)
    @Column(name = "emp_address")
    private String empAddress;
    //@Size(max = 100)
    @Column(name = "emp_email")
    private String empEmail;
    //@Size(max = 100)
    @Column(name = "emp_password")
    private String empPassword;
    //@Size(max = 100)
    @Column(name = "emp_mobile")
    private String empMobile;
    //@Size(max = 100)
    @Column(name = "emp_role")
    private String empRole;
    //@Size(max = 50)
    @Column(name = "emp_active")
    private String empActive;
    //@Size(max = 100)
    @Column(name = "emp_branch")
    private String empBranch;
    //@Size(max = 100)
    @Column(name = "emp_dept")
    private String empDept;
    //@Size(max = 100)
    @Column(name = "emp_division")
    private String empDivision;
    //@Size(max = 11)
    @Column(name = "refId")
    private String refId;
    
    
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public String getEmpMobile() {
		return empMobile;
	}
	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}
	public String getEmpRole() {
		return empRole;
	}
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}
	public String getEmpActive() {
		return empActive;
	}
	public void setEmpActive(String empActive) {
		this.empActive = empActive;
	}
	public String getEmpBranch() {
		return empBranch;
	}
	public void setEmpBranch(String empBranch) {
		this.empBranch = empBranch;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public String getEmpDivision() {
		return empDivision;
	}
	public void setEmpDivision(String empDivision) {
		this.empDivision = empDivision;
	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	@Override
	public String toString() {
		return "EmployeeMaster [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empEmail="
				+ empEmail + ", empPassword=" + empPassword + ", empMobile=" + empMobile + ", empRole=" + empRole
				+ ", empActive=" + empActive + ", empBranch=" + empBranch + ", empDept=" + empDept + ", empDivision="
				+ empDivision + ", refId=" + refId + "]";
	}
    
    

}
