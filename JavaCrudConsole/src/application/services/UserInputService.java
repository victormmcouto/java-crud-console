package application.services;

import java.util.Scanner;

import application.enums.MenuOptions;

public class UserInputService {
	
	public Scanner sc;
	
	public UserInputService(Scanner sc) {
		this.sc = sc;
	}
	
	public MenuOptions getOption() {
		MenuOptions option = null;
		try {
			System.out.print("Insira uma opção: ");
			option = MenuOptions.valueOf(sc.next().toUpperCase());
		} catch (IllegalArgumentException e) {
			System.out.println("Insira uma opção válida!");
		}
		return option;
	}
	
	public void closeService() {
		sc.close();
	}
}
