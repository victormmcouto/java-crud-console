package application.services;

import java.util.Scanner;

import application.enums.MenuOptions;
import model.entities.Product;
import model.enums.ProductCategory;

public class UserInputService {
	
	private Scanner sc;
	private InputValidationService validator;
	
	public UserInputService(Scanner sc) {
		this.sc = sc;
	}
	
	public MenuOptions getOption() {
		while (true) {
			System.out.print("Insira uma opção: ");			
			try {
				MenuOptions option = MenuOptions.valueOf(sc.next().toUpperCase());
				return option;
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
	
	public void closeService() {
		sc.close();
	}
}
