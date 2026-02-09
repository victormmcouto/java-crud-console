package model.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
				if (line.isEmpty() || line.isBlank()) break; 
				
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
		} catch (IllegalArgumentException | IOException e) {
			System.out.println("Não foi possível executar a leitura dos dados do arquivo " + filePath);
			System.out.println("Arquivo mal formatado ou não existe!");
			System.out.println(e.getMessage());
			return null;
		} 
		
		return inventory;
	}
	
	public void saveData(Inventory inventory) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
			bw.write(inventory.toString());
		} catch (IOException e) {
			System.out.println("Não foi possível realizar a escrita dos dados no arquivo " + filePath);
			System.out.println(e.getMessage());
		}
	}
}
