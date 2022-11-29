package com.cg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDetailsDto {
	 private long id;
	 private long productMasterId;
	 private String description;
	 private boolean isActive;
}

