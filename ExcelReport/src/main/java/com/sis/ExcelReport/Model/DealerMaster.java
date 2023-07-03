package com.sis.ExcelReport.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dealermaster")
public class DealerMaster {
	
	   private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "dealer_id")
	    private Integer dealerId;
	    //@Size(max = 50)
	    @Column(name = "dealer_name")
	    private String dealerName;
	    //@Size(max = 100)
	    @Column(name = "dealer_address")
	    private String dealerAddress;
	    //@Size(max = 50)
	    @Column(name = "dealer_mail")
	    private String dealerMail;
	    //@Size(max = 20)
	    @Column(name = "dealer_phone")
	    private String dealerPhone;
	    @Column(name = "dealer_region")
	    private Integer dealerRegion;
		public Integer getDealerId() {
			return dealerId;
		}
		public void setDealerId(Integer dealerId) {
			this.dealerId = dealerId;
		}
		public String getDealerName() {
			return dealerName;
		}
		public void setDealerName(String dealerName) {
			this.dealerName = dealerName;
		}
		public String getDealerAddress() {
			return dealerAddress;
		}
		public void setDealerAddress(String dealerAddress) {
			this.dealerAddress = dealerAddress;
		}
		public String getDealerMail() {
			return dealerMail;
		}
		public void setDealerMail(String dealerMail) {
			this.dealerMail = dealerMail;
		}
		public String getDealerPhone() {
			return dealerPhone;
		}
		public void setDealerPhone(String dealerPhone) {
			this.dealerPhone = dealerPhone;
		}
		public Integer getDealerRegion() {
			return dealerRegion;
		}
		public void setDealerRegion(Integer dealerRegion) {
			this.dealerRegion = dealerRegion;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		@Override
		public String toString() {
			return "DealerMaster [dealerId=" + dealerId + ", dealerName=" + dealerName + ", dealerAddress="
					+ dealerAddress + ", dealerMail=" + dealerMail + ", dealerPhone=" + dealerPhone + ", dealerRegion="
					+ dealerRegion + "]";
		}
	    
	    
	    
	    

}
