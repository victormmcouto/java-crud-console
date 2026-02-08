package model.entities;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;


public class Inventory {
	private Map<Integer, ProductItem> productItems = new HashMap<>();
	
	public void addNewProductItem(ProductItem productItem) {
		if (!productItems.containsKey(productItem.getId())) {
			productItems.put(productItem.getId(), productItem);
		} else {
			System.out.println("O produto de id " + String.format("0000", productItem.getId()) + " já existe!");
		}
	}
	
	public void removeProductItem(Integer productId) {
		if (productItems.remove(productId) == null) {
			System.out.println("O produto de id " + String.format("0000", productId) + " não existe!");
		}
	}
	
	public void erase() {
		productItems.clear();
	}
	
	public void stockIn(Integer productId, Integer quantity) {
		if (productItems.containsKey(productId)) {
			ProductItem productItem = productItems.get(productId);
			
			productItem.productsIn(quantity);
			
			System.out.println("Unidades acrescentadas!");
			System.out.println(productItem);
		}
	}
	
	public void stockOut(Integer productId, Integer quantity) {
		if (productItems.containsKey(productId)) {
			ProductItem productItem = productItems.get(productId);
			
			try {
				productItem.productsOut(quantity);
				System.out.println("Unidades retiradas!");
				System.out.println(productItem);
			} catch (InvalidParameterException e) {
				System.out.println("Número de itens disponíveis insuficiente!");
				System.out.println("Qauntidade disponível: " + productItem.getQuantity());
			}
		}
	}
	
	public Map<Integer, ProductItem> getInventory() {
		return productItems;
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
