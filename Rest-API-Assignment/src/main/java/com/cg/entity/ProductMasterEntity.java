package com.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.dto.ProductMasterDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_master")
public class ProductMasterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private double price;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="product_details_id")
	private ProductDetailsEntity productDetailsEntity;
	
	public ProductMasterEntity(ProductMasterDto dto) {
		super();
		this.id = dto.getId();
		this.name = dto.getName();
		this.price = dto.getPrice();
	}		
}
