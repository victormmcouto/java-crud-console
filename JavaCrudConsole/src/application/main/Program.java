package application.main;

import java.util.Locale;
import java.util.Scanner;

import application.enums.MenuOptions;
import application.services.ConsoleOutputService;
import application.services.OutputService;
import application.services.UserInputService;
import application.ui.MenuHandler;
import model.entities.Inventory;
import model.entities.ProductItem;
import model.services.InventoryFileService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		OutputService output = new ConsoleOutputService();
		
		MenuHandler mh = new MenuHandler(output);
		UserInputService inputService = new UserInputService(new Scanner(System.in), output);
		InventoryFileService file = new InventoryFileService("C:\\Temp\\invenotry.csv", output);
		Inventory inventory = file.loadData();
		
		Boolean leave = false;
		
		if (inventory != null) {
			mh.showHeader("Gerenciamento de estoque de produtos");
			while(!leave) {
				mh.showMenu();
				MenuOptions option = inputService.getOption();
				
				switch (option) {
					case LISTAR: {
						inventory.showInventory();
						break;
					} case CADASTRAR: {
						ProductItem newProductItem = inputService.getProductItem();
						inventory.addNewProductItem(newProductItem);
						break;
					} case DELETAR: {
						Integer id = inputService.getId();
						inventory.removeProductItem(id);
						break;
					} case ADICIONAR: {
						Integer id = inputService.getId();
						Integer quantity = inputService.getQuantity();
						inventory.stockIn(id, quantity);
						break;
					} case RETIRAR: {
						Integer id = inputService.getId();
						Integer quantity = inputService.getQuantity();
						inventory.stockOut(id, quantity);
						break;
					} case SAIR: {
						file.saveData(inventory);
						output.printMessage("Fim do processo!");
						leave = true;
						break;
					}
				}
			
				if (!leave) inputService.waitNextInput(); else inputService.closeService();
			}
		}
	}
}
