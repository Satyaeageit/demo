package com.eageit.util;

import java.util.Arrays;

public class QueryValidationResponse {
	private Integer[] randomNumL;
	private Integer result;
	
	public QueryValidationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QueryValidationResponse(Integer[] randomNumL, Integer result) {
		super();
		this.randomNumL = randomNumL;
		this.result = result;
	}

	@Override
	public String toString() {
		return "QueryValidationResponse [randomNumL=" + Arrays.toString(randomNumL) + ", result=" + result + "]";
	}

	public Integer[] getRandomNumL() {
		return randomNumL;
	}

	public void setRandomNumL(Integer[] randomNumL) {
		this.randomNumL = randomNumL;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}


}
