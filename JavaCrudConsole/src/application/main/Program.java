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
		InventoryFileService ifs = new InventoryFileService("C:\\Users\\victor.couto\\OneDrive - ALS Limited\\Desktop");
		Inventory inventory = ifs.loadData();
		
		System.out.println("Sistema de gerenciamento de estoque de produtos");
		
		while(true) {
			mh.showMenu();
			MenuOptions option = inputService.getOption();
			
			switch (option) {
				case LISTAR: {
					System.out.println(inventory);
				} case CADASTRAR: {
					ProductItem newProductItem = inputService.getProductItem();
					inventory.addNewProductItem(newProductItem);
				} case DELETAR: {
					Integer id = inputService.getProductItemId();
					inventory.removeProductItem(id);
				} case ADICIONAR: {
					Integer id = inputService.getProductItemId();
					Integer quantity = inputService.getQuantity();
					inventory.stockIn(id, quantity);
				} case RETIRAR: {
					Integer id = inputService.getProductItemId();
					Integer quantity = inputService.getQuantity();
					inventory.stockOut(id, quantity);
				} case SAIR: {
					ifs.saveData(inventory);
					inputService.closeService();
					break;
				}
			}
		}
	}
}
