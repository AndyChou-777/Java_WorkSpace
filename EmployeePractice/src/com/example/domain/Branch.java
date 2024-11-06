package com.example.domain;

public enum Branch {

	Taipei("NT$"), London("£"), Paris("€"), Tokyo("¥");

	private String currency;

	private Branch(String currency) {
		this.currency = currency;
	}

	public String getCurrency() {
		return currency;
	}

}
