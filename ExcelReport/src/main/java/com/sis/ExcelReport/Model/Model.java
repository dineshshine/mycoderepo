package com.sis.ExcelReport.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "model")
public class Model {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "model_id")
    private Integer modelId;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "sup_id")
    private Integer supId;
    //@Size(max = 100)
    @Column(name = "model_name")
    private String modelName;
   // @Size(max = 250)
    @Column(name = "model_desc")
    private String modelDesc;
   // @Size(max = 100)
    @Column(name = "sup_name")
    private String supName;
	public Integer getModelId() {
		return modelId;
	}
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getSupId() {
		return supId;
	}
	public void setSupId(Integer supId) {
		this.supId = supId;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModelDesc() {
		return modelDesc;
	}
	public void setModelDesc(String modelDesc) {
		this.modelDesc = modelDesc;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	@Override
	public String toString() {
		return "Model [modelId=" + modelId + ", productId=" + productId + ", supId=" + supId + ", modelName="
				+ modelName + ", modelDesc=" + modelDesc + ", supName=" + supName + "]";
	}
    
    
}
