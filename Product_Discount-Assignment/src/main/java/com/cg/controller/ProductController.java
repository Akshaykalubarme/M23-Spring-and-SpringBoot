package com.cg.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.ProductEntity;
import com.cg.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product")
    public void add(@RequestBody ProductEntity productEntity)
    {
	    productService.save(productEntity);
    }
	
	//deletion
    @DeleteMapping("/product/{id}")
    public void remove(@PathVariable Long id)
    {
        productService.delete(id);
    }
    
    @PutMapping("/product/{id}")
    public ResponseEntity<ProductEntity>update(@RequestBody ProductEntity productEntity, @PathVariable Integer id)
    {
        try {
            @SuppressWarnings("unused")
            ProductEntity s1=productService.retrieve(id);
            productService.create(productEntity);
            return new ResponseEntity<ProductEntity>(s,HttpStatus.OK);
        }
        catch(NoSuchElementException e)
        {
            return new ResponseEntity<ProductEntity>(HttpStatus.NOT_FOUND);
        }
    }

}
