package com.tikifake.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tikifake.entity.VariationValue;

public interface VariationValueRepository extends JpaRepository<VariationValue, Long>{

	public VariationValue findByValue(String value);
}
