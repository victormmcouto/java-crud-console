package application.services;

import java.util.Scanner;
import java.util.function.Supplier;

import application.enums.MenuOptions;
import model.entities.Product;
import model.entities.ProductItem;
import model.enums.ProductCategory;

public class UserInputService {
	
	private Scanner sc;
	private OutputService output;
	private ValidationService validator =  new ValidationService();
	
	public UserInputService(Scanner sc, OutputService output) {
		this.sc = sc;
		this.output = output;
	}
	
	public MenuOptions getOption() {
		return getValidatedEnumValue(getInput("Insira uma opção: "), MenuOptions.class);
	}
	
	public Product getProduct() {
		String name = getValidadtedString(getInput("Nome do produto: "));

		output.printMessage("CATEGORIAS -> ");
		output.printEnum(ProductCategory.class);
		ProductCategory category = getValidatedEnumValue(getInput("Categoria do produto: "), ProductCategory.class);

		Double price = getValidatedNumber(getInput("Preço: "), Double.class);
		
		return new Product(name, category, price);
	}
	
	public ProductItem getProductItem() {
		Integer id = getId();
		Product product = getProduct();
		Integer quantity = getQuantity();
		
		return new ProductItem(id, product, quantity);
	}
	
	public Integer getId() {
		return getValidatedNumber(getInput("ID do produto: "), Integer.class);
	}
	
	public Integer getQuantity() {
		return getValidatedNumber(getInput("Quantidade: "), Integer.class);
	}
	
	public <N extends Number> N getValidatedNumber(String inputMessage, Class<N> numClass) {
		return loop(() -> validator.validateNumber(getInput(inputMessage), numClass));
	}
	
	public String getValidadtedString(String inputString) {
		return loop(() -> validator.validateString(inputString));
	}
	
	public <E extends Enum<E>> E getValidatedEnumValue(String inputMessage, Class<E> enumClass) {
		return loop(() -> validator.validateEnum(getInput(inputMessage), enumClass));
	}
	
	public String getInput(String inputMessage) {
		sc.nextLine();
		output.printInputMessage(inputMessage);
		return sc.nextLine();
	}
	
	public <T> T loop(Supplier<T> action) {
		while (true) {
			try {
				action.get();
			} catch(IllegalArgumentException e) {
				output.printError(e.getMessage());
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
