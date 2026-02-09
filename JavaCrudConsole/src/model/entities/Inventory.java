package model.entities;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import application.services.OutputService;


public class Inventory {
	private Map<Integer, ProductItem> productItems = new HashMap<>();
	
	private OutputService output;
	
	public Inventory(OutputService output) {
		this.output = output;
	}
	
	public Map<Integer, ProductItem> getInventory() {
		return productItems;
	}
	
	public void addNewProductItem(ProductItem productItem) {
		if (!productItems.containsKey(productItem.getId())) {
			productItems.put(productItem.getId(), productItem);
		} else {
			output.printMessage("O produto de id " + String.format("0000", productItem.getId()) + " já existe!");
		}
	}
	
	public void removeProductItem(Integer productId) {
		if (productItems.remove(productId) == null) {
			output.printMessage("O produto de id " + String.format("0000", productId) + " não existe!");
		}
	}
	
	public void erase() {
		productItems.clear();
	}
	
	public void stockIn(Integer productId, Integer quantity) {
		if (productItems.containsKey(productId)) {
			ProductItem productItem = productItems.get(productId);
			
			productItem.productsIn(quantity);
			
			output.printMessage("Unidades acrescentadas!");
			output.printMessage(productItem.getProductItemInfo());
		}
	}
	
	public void stockOut(Integer productId, Integer quantity) {
		if (productItems.containsKey(productId)) {
			ProductItem productItem = productItems.get(productId);
			
			try {
				productItem.productsOut(quantity);
				output.printMessage("Unidades retiradas!");
				output.printMessage(productItem.getProductItemInfo());
			} catch (InvalidParameterException e) {
				output.printMessage("Número de itens disponíveis insuficiente!\n" + 
									"Qauntidade disponível: " + productItem.getQuantity());
			}
		}
	}
	
	public void showInventory() {
		for (ProductItem productItem : productItems.values()) {
			output.printMessage(productItem.getProductItemInfo());
		}
	}
	
	@Override
	public String toString() {
		if (productItems.isEmpty()) return "Inventório vazio!";
		
		String inventoryList = "";
		
		for (ProductItem productItem : productItems.values()) {
			inventoryList += productItem.toString() + System.lineSeparator();
		}
		return inventoryList;
	}
}
