package application.services;

import java.util.Scanner;

import application.enums.MenuOptions;
import model.entities.Product;
import model.entities.ProductItem;
import model.enums.ProductCategory;

public class UserInputService {
	
	private Scanner sc;
	private OutputService output;
	private InputValidationService validator = new InputValidationService();
	
	public UserInputService(Scanner sc, OutputService output) {
		this.sc = sc;
		this.output = output;
	}
	
	public MenuOptions getOption() {
		while (true) {
			output.printInputMessage("Insira uma opção: ");			
			try {
				return validator.validateEnum(sc.next(), MenuOptions.class);
			} catch (IllegalArgumentException e) {
				output.printMessage("Insira uma opção válida!");
			}
		}
	}
	
	public Product getProduct() {
		while (true) {
			try {
				output.printInputMessage("Nome do produto: ");
				String name = validator.validateString(sc.next());

				output.printInputMessage("CATEGORIAS -> ");
				output.printEnum(ProductCategory.class, true);
				output.printInputMessage("Categoria do produto: ");
				ProductCategory category = validator.validateEnum(sc.next(), ProductCategory.class);

				output.printInputMessage("Preço: ");
				Double price = validator.validateNumber(sc.next(), Double.class);
				
				return new Product(name, category, price);
			} catch (IllegalArgumentException e) {
				output.printError("Valor inválido!!");
			}
		}
	}
	
	public ProductItem getProductItem() {
		while (true) {
			try {
				output.printInputMessage("ID do produto: ");
				Integer id = validator.validateNumber(sc.next(), Integer.class);
				
				Product product = getProduct();
				
				output.printInputMessage("Quantidade: ");
				Integer quantity = validator.validateNumber(sc.next(), Integer.class);
				
				return new ProductItem(id, product, quantity);
			} catch (IllegalArgumentException e) {
				output.printMessage("Valor inválido!!");
			}
		}
	}
	
	public Integer getProductItemId() {
		while (true) {
			try {
				output.printInputMessage("ID do produto: ");
				return validator.validateNumber(sc.next(), Integer.class);
			} catch (IllegalArgumentException e) {
				output.printMessage("Valor inválido! Deve ser um número inteiro!");
			}
		}
	}
	
	public Integer getQuantity() {
		while (true) {
			try {
				output.printInputMessage("Quantidaade: ");
				return validator.validateNumber(sc.next(), Integer.class);
			} catch (IllegalArgumentException e) {
				output.printMessage("Valor inválido! Deve ser um número inteiro!");
			}
		}
	}
	
	public void closeService() {
		sc.close();
	}
	
	public void waitNextInput() {
		sc.nextLine(); //Consome quebra de linha do input anterior
		sc.nextLine();
	}
}
