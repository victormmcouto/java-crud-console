package application.services;

import java.util.Scanner;

import application.enums.MenuOptions;

public class UserInputService {
	
	public Scanner sc;
	
	public UserInputService(Scanner sc) {
		this.sc = sc;
	}
	
	public MenuOptions getOption() {
		while (true) {
			System.out.print("Insira uma opção: ");
			
			try {
				MenuOptions option = MenuOptions.valueOf(sc.next().toUpperCase());
				return option;
			} catch (IllegalArgumentException e) {
				System.out.println("Insira uma opção válida!");
			}
		}
	}
	
	public void closeService() {
		sc.close();
	}
}
