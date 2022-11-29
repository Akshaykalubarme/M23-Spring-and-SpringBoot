package com.cg.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.entity.ProductMasterEntity;

public interface ProductMasterRepository extends JpaRepository<ProductMasterEntity,Long>{
	
	 @Query("SELECT d FROM ProductMasterEntity d WHERE d.name LIKE CONCAT('%',:q,'%')")
	 Page<ProductMasterEntity> getForListing(Pageable pagingRequest, String q);

	 @Query("SELECT b FROM ProductMasterEntity b ")
	 List<ProductMasterEntity> listProduct();
	 
}
