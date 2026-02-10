package model.entities;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import application.services.OutputService;


public class Inventory {
	private Map<String, ProductItem> productItems = new HashMap<>();
	
	private OutputService output;
	
	public Inventory(OutputService output) {
		this.output = output;
	}
	
	public Map<String, ProductItem> getInventory() {
		return productItems;
	}
	
	public void addNewProductItem(ProductItem productItem) {
		productItems.put(productItem.getId(), productItem);
	}
	
	public void removeProductItem(String productId) {
		if (productItems.remove(productId) == null) {
			output.printError("O produto de id " + String.format("00000000", productId) + " não existe!");
		} else {
			output.printError("Produto Removido!");
		}
	}
	
	public void erase() {
		productItems.clear();
	}
	
	public void stockIn(String productId, Integer quantity) {
		if (idExists(productId)) {
			ProductItem productItem = productItems.get(productId);
			
			productItem.productsIn(quantity);
			
			output.printMessage("Unidades acrescentadas!");
			output.printMessage(productItem.getProductItemInfo());
		} else {
			output.printError("O produto de id " + String.format("00000000", productId) + " não existe!");
		}
	}
	
	public void stockOut(String productId, Integer quantity) {
		if (idExists(productId)) {
			ProductItem productItem = productItems.get(productId);
			
			try {
				productItem.productsOut(quantity);
				output.printMessage("Unidades retiradas!");
				output.printMessage(productItem.getProductItemInfo());
			} catch (InvalidParameterException e) {
				output.printMessage("Número de itens disponíveis insuficiente!\n" + 
									"Qauntidade disponível: " + productItem.getQuantity());
			}
		} else {
			output.printError("O produto de id " + String.format("00000000", productId) + " não existe!");
		}
	}
	
	public void showInventory() {
		for (ProductItem productItem : productItems.values()) {
			output.printMessage(productItem.getProductItemInfo());
		}
	}
	
	public Boolean idExists(String id) {
		return productItems.containsKey(id);
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
