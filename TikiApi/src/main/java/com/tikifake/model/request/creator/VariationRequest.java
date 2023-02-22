package com.tikifake.model.request.creator;

import java.util.List;

public class VariationRequest {
	
	private String variationName;
	
	private List<VariationValueRequest> values;

	public String getVariationName() {
		return variationName;
	}

	public List<VariationValueRequest> getValues() {
		return values;
	}
}
