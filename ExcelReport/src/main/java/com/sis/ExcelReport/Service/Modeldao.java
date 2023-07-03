package com.sis.ExcelReport.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sis.ExcelReport.Model.Model;

@Repository
public interface Modeldao extends JpaRepository<Model,Integer>{
	@Query(value = "SELECT model_name FROM model WHERE model_id = ?",nativeQuery = true)
    public String findModelName(Integer id);
}
