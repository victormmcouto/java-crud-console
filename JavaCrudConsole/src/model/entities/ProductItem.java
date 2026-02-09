package model.entities;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ProductItem implements Comparable<ProductItem> {
	private Integer id;
	private Product product;
	private Integer quantity;
	private LocalDateTime timeModified;
	
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

	public ProductItem(Integer id) {
		this.id = id;
		timeModified = LocalDateTime.now();
	}
	
	public ProductItem(Integer id, Product product, Integer quantity) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		timeModified = LocalDateTime.now();
	}
	
	public ProductItem(Integer id, Product product, Integer quantity, LocalDateTime timeModified) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.timeModified = timeModified;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
		timeModified = LocalDateTime.now();
	}

	public Integer getQuantity() {
		return quantity;
	}

	public LocalDateTime getTimeModified() {
		return timeModified;
	}
	
	public Double totalValue() {
		return product.getPrice() * quantity;
	}
	
	public void productsOut(Integer quantity) {
		if (quantity <= this.quantity) {
			throw new InvalidParameterException();
		}
		this.quantity -= quantity;
		timeModified = LocalDateTime.now();
	}
	
	public void productsIn(Integer quantity) {
		this.quantity += quantity;
		timeModified = LocalDateTime.now();
	}
	
	public String getProductItemInfo() {
		return "\nID: "  + id + 
				product.getProductInfo() +
				"\nQuantidade: " + quantity + 
				"\nÚltima modificação: " + timeModified.format(format);
	}
	
	@Override
	public String toString() {
		return id + "," + product + "," + quantity + "," + timeModified;
	}

	@Override
	public int compareTo(ProductItem other) {
		return id.compareTo(other.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductItem other = (ProductItem) obj;
		return Objects.equals(id, other.id);
	}
}
