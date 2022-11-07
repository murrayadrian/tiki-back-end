package com.tikifake.model;

import java.time.LocalDateTime;

public interface IProduct {
	
	public Long getId();

	public String getName();

	public String getDescription();

	public double getPrice();
	
	public String getImage();
	
	public String getBrand();
	
	public String getMadeIn();
	
	public LocalDateTime getCreatedDate();

	public Long getCategorySubId();
}
