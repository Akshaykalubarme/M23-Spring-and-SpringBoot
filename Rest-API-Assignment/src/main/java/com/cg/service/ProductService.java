package com.cg.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cg.dto.APIResponse;
import com.cg.dto.ProductDetailsDto;
import com.cg.dto.ProductMasterDto;
import com.cg.entity.ProductDetailsEntity;
import com.cg.entity.ProductMasterEntity;
import com.cg.repository.ProductMasterRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductMasterRepository productMasterRepository;
	
	public ProductService() {
		super();
	}
	
	public APIResponse saveProduct(ProductMasterDto dto) {
        APIResponse result = new APIResponse();
        try {
        	ProductMasterEntity product = productMasterRepository.save(new ProductMasterEntity(dto));
        	result.setData(product);
        	result.setMessage("Product Saved Successfully");
        	result.setStatus(HttpStatus.OK);
		} catch (Exception e) {
			result.setMessage("Error while saving product: "+e.getMessage());
        	result.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
        return result;
        
	}
	
	public APIResponse update(ProductDetailsDto dto) {
		 APIResponse result = new APIResponse();
		 try {
			 Optional<ProductMasterEntity> product = productMasterRepository.findById(dto.getProductMasterId());
			 if(product.isPresent()) {
				product.get().setProductDetailsEntity(new ProductDetailsEntity(dto,product.get()));
				productMasterRepository.save(product.get());
				result.setData(product);
	        	result.setMessage("Product details updated Successfully");
	        	result.setStatus(HttpStatus.OK);
			 }else {
				result.setMessage("Product not found");
		        result.setStatus(HttpStatus.BAD_REQUEST);
			 }
			
		} catch (Exception e) {
			result.setMessage("Error while saving product details: "+e.getMessage());
        	result.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 return result;
	}
	
	public APIResponse getAll(Pageable pageable, String q) {
        APIResponse result = new APIResponse();
        Page<ProductMasterEntity> listingData =productMasterRepository.getForListing(pageable,q);
        result.setMessage("Products");
        result.setData(listingData);
        result.setStatus(HttpStatus.OK);
        return result;
    }

	public APIResponse updateProductStatus(long productId, boolean status) {
		 APIResponse result = new APIResponse();
		 Optional<ProductMasterEntity> product = productMasterRepository.findById(productId);
		 if(product.isPresent()) {
			 if(product.get().getProductDetailsEntity()!=null) {
				 product.get().getProductDetailsEntity().setActive(status);
				 productMasterRepository.save(product.get());
				 result.setMessage("Product status updated successfully");
				 result.setStatus(HttpStatus.OK);
				 
			 }else {
				 result.setMessage("Product details entity not set");
				 result.setStatus(HttpStatus.BAD_REQUEST);
			 }
		 }else {
			 result.setMessage("Invalid product Id");
			 result.setStatus(HttpStatus.BAD_REQUEST);
		 }
		 return result;
	}
	
}
