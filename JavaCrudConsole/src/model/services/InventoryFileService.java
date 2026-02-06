package model.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

import model.entities.Inventory;
import model.entities.Product;
import model.entities.ProductItem;
import model.enums.ProductCategory;

public class InventoryFileService {
	private String filePath;
	
	public InventoryFileService(String filePath) {
		this.filePath = filePath;
	}
	
	public Inventory loadData() {
		Inventory inventory = new Inventory();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line = br.readLine();
					
			while(line != null) {
				String[] record = line.split(",");
				
				Integer id = Integer.parseInt(record[0]);
				String name = record[1];
				ProductCategory category = ProductCategory.valueOf(record[2]);
				Double price = Double.valueOf(record[3]);
				Integer quantity = Integer.valueOf(record[4]);
				LocalDateTime timeModified = LocalDateTime.parse(record[5]);
				
				Product product = new Product(name, category, price);
				ProductItem productItem = new ProductItem(id, product, quantity, timeModified);
				
				inventory.addNewProductItem(productItem);
				
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Não foi possível executar a leitura dos dados do arquivo " + filePath);
		}
		
		return inventory;
	}
	
	public void saveData(Inventory inventory) {
		
	}
}
