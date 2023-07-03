package com.sis.ExcelReport.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dropdownmaster")
public class DropDownMaster {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    //@Size(max = 255)
    @Column(name = "ddname")
    private String ddname;
   // @Size(max = 255)
    @Column(name = "ddvalue")
    private String ddvalue;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDdname() {
		return ddname;
	}
	public void setDdname(String ddname) {
		this.ddname = ddname;
	}
	public String getDdvalue() {
		return ddvalue;
	}
	public void setDdvalue(String ddvalue) {
		this.ddvalue = ddvalue;
	}
	@Override
	public String toString() {
		return "DropDownMaster [id=" + id + ", ddname=" + ddname + ", ddvalue=" + ddvalue + "]";
	}
	
	
    
    
    
	
}
