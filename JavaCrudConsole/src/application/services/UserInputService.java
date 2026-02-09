package application.services;

import java.util.Scanner;

import application.enums.MenuOptions;
import model.entities.Product;
import model.entities.ProductItem;
import model.enums.ProductCategory;

public class UserInputService {
	
	private Scanner sc;
	private InputValidationService validator = new InputValidationService();
	
	public UserInputService(Scanner sc) {
		this.sc = sc;
	}
	
	public MenuOptions getOption() {
		while (true) {
			System.out.print("Insira uma opção: ");			
			try {
				return validator.validateEnum(sc.next(), MenuOptions.class);
			} catch (IllegalArgumentException e) {
				System.out.println("Insira uma opção válida!");
			}
		}
	}
	
	public Product getProduct() {
		while (true) {
			try {
				String name = validator.validateString(sc.next());
				ProductCategory category = validator.validateEnum(sc.next(), ProductCategory.class);
				Double price = validator.validateNumber(sc.next(), Double.class);
				
				return new Product(name, category, price);
			} catch (IllegalArgumentException e) {
				System.out.println("Valor inválido!!");
			}
		}
	}
	
	public ProductItem getProductItem() {
		while (true) {
			try {
				Integer id = validator.validateNumber(sc.next(), Integer.class);
				Product product = getProduct();
				Integer quantity = validator.validateNumber(sc.next(), Integer.class);
				
				return new ProductItem(id, product, quantity);
			} catch (IllegalArgumentException e) {
				System.out.println("Valor inválido!!");
			}
		}
	}
	
	public Integer getProductItemId() {
		while (true) {
			try {
				return validator.validateNumber(sc.next(), Integer.class);
			} catch (IllegalArgumentException e) {
				System.out.println("Valor inválido!!");
			}
		}
	}
	
	public Integer getQuantity() {
		while (true) {
			try {
				return validator.validateNumber(sc.next(), Integer.class);
			} catch (IllegalArgumentException e) {
				System.out.println("Valor inválido!!");
			}
		}
	}
	
	public void closeService() {
		sc.close();
	}
}
