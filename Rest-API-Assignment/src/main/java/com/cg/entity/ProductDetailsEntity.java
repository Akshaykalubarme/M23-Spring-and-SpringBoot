package com.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.dto.ProductDetailsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_details")
public class ProductDetailsEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String description;
	
	private boolean isActive;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="product_master_id")
	private ProductMasterEntity ProductMasterEntity;
	
	public ProductDetailsEntity(ProductDetailsDto productDetails, ProductMasterEntity productMasterEntity) {
		super();
		this.id = productDetails.getId();
		this.description = productDetails.getDescription();
		this.isActive = productDetails.isActive();
		this.ProductMasterEntity = productMasterEntity;
	}

}
