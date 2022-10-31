package com.tikifake.model;

public interface IProduct {
	public Long getId();

	public String getName();

	public String getDescription();

	public double getPrice();
	
	public String getImage();
	
	public String getModel();
	
	public String getBrand();
	
	public String getOrigin();
	
	public String getMadeBy();

	public Long getCategoryId();
}
