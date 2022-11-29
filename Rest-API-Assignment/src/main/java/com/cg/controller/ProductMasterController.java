package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.APIResponse;
import com.cg.dto.ProductDetailsDto;
import com.cg.dto.ProductMasterDto;
import com.cg.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductMasterController {

	@Autowired
	private ProductService ProductService;
	
	/*
	 * Save product (Product Master)
	 * */
	@PostMapping("")
	public APIResponse saveProduct(@RequestBody ProductMasterDto entity) {
		return ProductService.saveProduct(entity); 
    }
	
	/*
	 * Update product (Product Details)
	 * */
	@PutMapping("")
	public APIResponse updateProductDetails(@RequestBody ProductDetailsDto entity) {
		return ProductService.update(entity); 
    }
	
	/*
	 * Change product status
	 * */
	@PatchMapping("")
	public APIResponse updateProductStatus(@RequestParam long productId, @RequestParam boolean status) {
		return ProductService.updateProductStatus(productId,status); 
    }
	
	/*
	 * get product listing with search
	 * */
	@GetMapping("/listing")
	public APIResponse get(Pageable pageable, @RequestParam String search) {
		return ProductService.getAll(pageable,search); 
    }

}
