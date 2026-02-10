package application.services;

import java.util.Scanner;

import application.enums.MenuOptions;
import model.entities.Product;
import model.entities.ProductItem;
import model.enums.ProductCategory;

public class UserInputService {
	
	private Scanner sc;
	private OutputService output;
	private ValidationService validator;
	
	public UserInputService(Scanner sc, OutputService output) {
		this.sc = sc;
		this.output = output;
		this.validator =  new ValidationService(output);
	}
	
	public MenuOptions getOption() {
		while (true) {		
			try {
				return validator.validateEnum(getInput("Insira uma opção: "), MenuOptions.class);
			} catch (IllegalArgumentException e) {
				output.printMessage("Insira uma opção válida!");
			}
		}
	}
	
	public Product getProduct() {
		while (true) {
			try {
				String name = validator.validateString(getInput("Nome do produto: "));

				output.printMessage("CATEGORIAS -> ");
				output.printEnum(ProductCategory.class);
				ProductCategory category = validator.validateEnum(getInput("Categoria do produto: "), ProductCategory.class);

				Double price = validator.validateNumber(getInput("Preço: "), Double.class);
				
				return new Product(name, category, price);
			} catch (IllegalArgumentException e) {
				output.printError("Valor inválido!!");
			}
		}
	}
	
	public ProductItem getProductItem() {
		while (true) {
			try {
				Integer id = validator.validateNumber(getInput("ID do produto: "), Integer.class);
				Product product = getProduct();
				Integer quantity = validator.validateNumber(getInput("Quantidade: "), Integer.class);
				
				return new ProductItem(id, product, quantity);
			} catch (IllegalArgumentException e) {
				output.printMessage("Valor inválido!!");
			}
		}
	}
	
	public Integer getProductItemId() {
		while (true) {
			try {
				return validator.validateNumber(getInput("ID do produto: "), Integer.class);
			} catch (IllegalArgumentException e) {
				output.printMessage("Valor inválido! Deve ser um número inteiro!");
			}
		}
	}
	
	public Integer getQuantity() {
		while (true) {
			try {
				return validator.validateNumber(getInput("Quantidaade: "), Integer.class);
			} catch (IllegalArgumentException e) {
				output.printMessage("Valor inválido! Deve ser um número inteiro!");
			}
		}
	}
	
	public void closeService() {
		sc.close();
	}
	
	public String getInput(String inputMessage) {
		sc.nextLine();
		output.printInputMessage(inputMessage);
		return sc.nextLine();
	}
	
	public void waitNextInput() {
		sc.nextLine(); //Consome quebra de linha do input anterior
		sc.nextLine();
	}
}
