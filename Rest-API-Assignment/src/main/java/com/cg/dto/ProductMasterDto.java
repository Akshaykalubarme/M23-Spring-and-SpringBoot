package com.cg.dto;

import com.cg.entity.ProductMasterEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductMasterDto {

	 private long id;
	 private String name;
	 private double price;

	 public ProductMasterDto(ProductMasterEntity entity) {
	        this.id = entity.getId();
	        this.name = entity.getName();
	        this.price = entity.getPrice();
	    } 
}

