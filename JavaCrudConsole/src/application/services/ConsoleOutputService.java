package application.services;

public class OutputService {
	public void printMessage(String message) {
		printLine();
		System.out.println(message);
		printLine();
	}
	
	public void printLine() {
		System.out.println("-".repeat(30));
	}
	
	public <E extends Enum<E>> void printEnum(Class<E> enumToShow, Boolean transpose) {
		printLine();
		for (E enumItem : enumToShow.getEnumConstants()) {
			if (transpose) {
				System.out.print("|" + enumItem + "|");
			} else {
				System.out.println(enumItem);
			}
		}
		printLine();
	}
}
