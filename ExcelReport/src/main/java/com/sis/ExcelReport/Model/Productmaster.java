package com.sis.ExcelReport.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productmaster")
public class Productmaster {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "prod_id")
	    private Integer prodId;
	   // @Size(max = 100)
	    @Column(name = "prod_name")
	    private String prodName;
	   // @Size(max = 100)
	    @Column(name = "prod_description")
	    private String prodDescription;
	    
		public Integer getProdId() {
			return prodId;
		}
		public void setProdId(Integer prodId) {
			this.prodId = prodId;
		}
		public String getProdName() {
			return prodName;
		}
		public void setProdName(String prodName) {
			this.prodName = prodName;
		}
		public String getProdDescription() {
			return prodDescription;
		}
		public void setProdDescription(String prodDescription) {
			this.prodDescription = prodDescription;
		}
		@Override
		public String toString() {
			return "Productmaster [prodId=" + prodId + ", prodName=" + prodName + ", prodDescription=" + prodDescription
					+ "]";
		}
	    
		
		
	    
}
