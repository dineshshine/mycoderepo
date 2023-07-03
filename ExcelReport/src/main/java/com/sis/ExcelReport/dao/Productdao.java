package com.sis.ExcelReport.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sis.ExcelReport.Model.Productmaster;

@Repository
public interface Productdao extends JpaRepository<Productmaster,Integer>{
	@Query(value = "SELECT prod_name FROM productmaster WHERE prod_id = ?",nativeQuery = true)
    public String findProdName(Integer id);
}
