package com.sis.ExcelReport.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mail_id_entry")
public class MailIdEntry {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "mail_id_entry_id")
	    private Integer mail_id_entry_id;
	   
	   // @Size(max = 255)
	    @Column(name = "mail_id")
	    private String mail_id;
	   // @Size(max = 255)
	    @Column(name = "report_type")
	    private String report_type;
	  //  @Size(max = 150)
	    @Column(name = "temp1")
	    private String temp1;
	   // @Size(max = 255)
	    @Column(name = "temp2")
	    private String temp2;
	    
	    
		public Integer getMail_id_entry_id() {
			return mail_id_entry_id;
		}
		public void setMail_id_entry_id(Integer mail_id_entry_id) {
			this.mail_id_entry_id = mail_id_entry_id;
		}
		public String getMail_id() {
			return mail_id;
		}
		public void setMail_id(String mail_id) {
			this.mail_id = mail_id;
		}
		public String getReport_type() {
			return report_type;
		}
		public void setReport_type(String report_type) {
			this.report_type = report_type;
		}
		public String getTemp1() {
			return temp1;
		}
		public void setTemp1(String temp1) {
			this.temp1 = temp1;
		}
		public String getTemp2() {
			return temp2;
		}
		public void setTemp2(String temp2) {
			this.temp2 = temp2;
		}
		
		
		@Override
		public String toString() {
			return "MailIdEntry [mail_id_entry_id=" + mail_id_entry_id + ", mail_id=" + mail_id + ", report_type="
					+ report_type + ", temp1=" + temp1 + ", temp2=" + temp2 + "]";
		}
		
		
		
	    
	    
}
