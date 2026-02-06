package model.entities;

import model.enums.ProductCategory;

public class Product {
	private String name;
	private ProductCategory category;
	private Double price;
	
	public Product() {
	}

	public Product(String name, ProductCategory category, Double price) {
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getProductInfo() {
		return "Nome: " + name + "| Categoria: " + category + "| Preço: " + String.format("%.2f", price) 
	}
	
	@Override
	public String toString() {
		return name + "," + category + "," + String.format("%.2f", price);
	}
}
