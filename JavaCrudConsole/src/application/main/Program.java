package application.main;

import java.util.Locale;
import java.util.Scanner;

import application.enums.MenuOptions;
import application.services.UserInputService;
import application.ui.MenuHandler;
import model.entities.Inventory;
import model.entities.ProductItem;
import model.services.InventoryFileService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		MenuHandler mh = new MenuHandler();
		UserInputService inputService = new UserInputService(new Scanner(System.in));
		InventoryFileService ifs = new InventoryFileService("C:\\Temp\\invenotry.csv");
		Inventory inventory = ifs.loadData();
		
		Boolean leave = false;
		
		if (inventory != null) {
			mh.showHeader("Sistema de gerenciamento de estoque de produtos");
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
						Integer id = inputService.getProductItemId();
						inventory.removeProductItem(id);
						break;
					} case ADICIONAR: {
						Integer id = inputService.getProductItemId();
						Integer quantity = inputService.getQuantity();
						inventory.stockIn(id, quantity);
						break;
					} case RETIRAR: {
						Integer id = inputService.getProductItemId();
						Integer quantity = inputService.getQuantity();
						inventory.stockOut(id, quantity);
						break;
					} case SAIR: {
						ifs.saveData(inventory);
						inputService.closeService();
						leave = true;
						break;
					}
				}
			}
		}
	}
}
