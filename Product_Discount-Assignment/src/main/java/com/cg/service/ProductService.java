package com.cg.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cg.dto.APIResponse;
import com.cg.dto.ProductEntityDto;
import com.cg.entity.ProductEntity;
import com.cg.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public APIResponse addProduct(ProductRepository dto) {
		APIResponse result = new APIResponse();
		try {
			ProductEntity product = productRepository.save(new ProductEntity(dto));
			result.setData(product);
			result.setMessage("Product Saved Successfully");
			result.setStatus(HttpStatus.OK);
		} catch (Exception e) {
			result.setMessage("Error while saving product: " + e.getMessage());
			result.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;

	}
	
	public APIResponse updateProduct(ProductEntityDto dto) {
		APIResponse result = new APIResponse();
		Optional<ProductEntity> product = ProductRepository.findById();
		if(product.isPresent()) {
			if(product.get().getProductDetailsEntity()!=null) {
				product.get().getProductDetailsEntity().setActive(status);
				ProductRepository.save(product.get());
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

   	public APIResponse delete (long id) {
		APIResponse result = new APIResponse();
		Optional<ProductEntity> dbEntity = productRepository.findById(id);
	
		productRepository.delete(dbEntity.get());
		result.setMessage("Document type deleted successfully");
		result.setStatus(HttpStatus.OK);
		return result;
	}
	
}
