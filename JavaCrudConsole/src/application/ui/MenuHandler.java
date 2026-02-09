package application.ui;

import application.enums.MenuOptions;
import application.services.OutputService;

public class MenuHandler {
	
	private OutputService outService = new OutputService();
	
	public void showMenu() {
		outService.printMessage(" ".repeat(13) + "MENU" + " ".repeat(13) + "\n");
		outService.printEnum(MenuOptions.class, false);
	}
	
	public void showHeader(String header) {
		outService.printMessage(header.toUpperCase());
	}
}
