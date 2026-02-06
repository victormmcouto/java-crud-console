package application.ui;

import application.enums.MenuOptions;

public class MenuHandler {
	public void showMenu() {
		drawLine('-', 50);
		drawLine('-', 50);
		System.out.println("MENU");
		drawLine('-', 50);
		drawLine('-', 50);
		for (MenuOptions options : MenuOptions.values()) {
			System.err.println(options);
		}
		drawLine('-', 50);
		drawLine('-', 50);
	}
	
	private void drawLine(Character character, int repet) {
		for (int i=0; i < repet; i++) {
			System.err.print(character);
		}
		System.out.println();
	}
}
