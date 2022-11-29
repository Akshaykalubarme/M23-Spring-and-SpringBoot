package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cg.repository.ProductRepository;

@Entity
@Table(name = "product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String name;
	private String productType;
	private String category;
	private double basePrice;
	private double discount;
	private double gst;
	private double deliveryCharges;

	public ProductEntity(long productId, String name, String productType, String category, double basePrice,
			double discount, double gst, double deliveryCharges) {
		this.productId = productId;
		this.name = name;
		this.productType = productType;
		this.category = category;
		this.basePrice = basePrice;
		this.discount = discount;
		this.gst = gst;
		this.deliveryCharges = deliveryCharges;
	}

	public ProductEntity(ProductEntity dto, ProductEntity productEntity) {
	}

	public ProductEntity(ProductRepository dto) {
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productEntity) {
		this.productType = productEntity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public double getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", name=" + name + ", productType=" + productType
				+ ", category=" + category + ", basePrice=" + basePrice + ", discount=" + discount + ", gst=" + gst
				+ ", deliveryCharges=" + deliveryCharges + "]";
	}

}
