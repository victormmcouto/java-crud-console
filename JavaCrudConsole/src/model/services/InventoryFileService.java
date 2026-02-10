package model.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import application.services.OutputService;
import model.entities.Inventory;
import model.entities.Product;
import model.entities.ProductItem;
import model.enums.ProductCategory;

public class InventoryFileService {
	private String filePath;
	private OutputService output;
	
	public InventoryFileService(String filePath, OutputService output) {
		this.filePath = filePath;
		this.output = output;
	}
	
	public Inventory loadData() {
		Map<String, ProductItem> productItems = new HashMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line = br.readLine();
			while(line != null) {
				if (line.isEmpty() || line.isBlank()) break; 
				
				String[] record = line.split(",");
				
				String id = record[0];
				String name = record[1];
				ProductCategory category = ProductCategory.valueOf(record[2]);
				Double price = Double.valueOf(record[3]);
				Integer quantity = Integer.valueOf(record[4]);
				LocalDateTime timeModified = LocalDateTime.parse(record[5]);
				
				Product product = new Product(name, category, price);
				ProductItem productItem = new ProductItem(id, product, quantity, timeModified);
				
				productItems.put(id, productItem);
				
				line = br.readLine();
			}
		} catch (IllegalArgumentException | IOException e) {
			output.printError("Não foi possível executar a leitura dos dados do arquivo " + filePath + "\n" +
							   "Arquivo mal formatado ou não existe!\n" +
						   	   e.getMessage());
			return null;
		} 
		
		return new Inventory(productItems, output);
	}
	
	public void saveData(Inventory inventory) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
			if (!inventory.getInventory().isEmpty()) {
				bw.write(inventory.toString());
			} else {
				bw.write("");
			}
		} catch (IOException e) {
			output.printError("Não foi possível realizar a escrita dos dados no arquivo " + filePath + "\n" +
							  e.getMessage());
		}
	}
}
