package com.tikifake.model.response.list;

public interface ICategoryList {
	
	public Long getId();

	public String getName();
	
	public int getLevel();
	
	public String getUrlKey();
	
	public boolean isLeaf();
}
