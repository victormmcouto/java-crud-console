package application.ui;

import application.enums.MenuOptions;

public class MenuHandler {
	public void showMenu() {
		System.out.println("MENU");
		drawLine('-', 50);
		for (MenuOptions options : MenuOptions.values()) {
			System.err.println(options);
		}
		drawLine('-', 50);
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
