package com.briquedeckard.library.category.dto;

public class CategoryDTO implements Comparable<CategoryDTO> {
	public CategoryDTO() {
	}

	public CategoryDTO(String code, String label) {
		super();
		this.code = code;
		this.label = label;
	}

	private String code;

	private String label;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public int compareTo(CategoryDTO o) {
		return label.compareToIgnoreCase(o.label);
	}

}
