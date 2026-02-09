package application.ui;

import application.enums.MenuOptions;
import application.services.OutputService;

public class MenuHandler {
	
	private OutputService output;
	
	public MenuHandler(OutputService output) {
		this.output = output;
	}
	
	public void showMenu() {
		output.printMessage(" ".repeat(13) + "MENU" + " ".repeat(13));
		output.printEnum(MenuOptions.class, false);
	}
	
	public void showHeader(String header) {
		output.printMessage(header.toUpperCase());
	}
}
