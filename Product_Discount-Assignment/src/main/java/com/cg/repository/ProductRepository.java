package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

 

}
