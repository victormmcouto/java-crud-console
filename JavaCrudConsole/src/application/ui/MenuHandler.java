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
		drawLine('-', 0);
		System.out.println(header.toUpperCase());
		drawLine('-', 50);
	}

	private void drawLine(Character character, int repet) {
		for (int i=0; i < repet; i++) {
			System.out.print(character);
		}
		System.out.println();
	}
}
