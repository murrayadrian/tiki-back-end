package com.tikifake.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tikifake.entity.ProductConfiguration;
import com.tikifake.entity.embeddedid.ConfigurationId;

public interface ProductConfigRepository extends JpaRepository<ProductConfiguration, ConfigurationId>{

}
