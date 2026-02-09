package application.ui;

import application.enums.MenuOptions;
import application.services.OutputService;

public class MenuHandler {
	
	private OutputService output;
	
	public MenuHandler(OutputService output) {
		this.output = output;
	}
	
	public void showMenu() {
		output.printMessage(" ".repeat(16) + "MENU" + " ".repeat(16));
		output.printEnum(MenuOptions.class);
	}
	
	public void showHeader(String header) {
		output.printMessage(header.toUpperCase());
	}
}
