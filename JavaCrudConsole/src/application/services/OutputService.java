package application.services;

public class OutputService {
	public void printMessage(String message) {
		printLine("-", 30);
		System.out.print(message);
		printLine("-", 30);
	}
	
	public void printLine(String toRepeat, Integer times) {
		System.out.println(toRepeat.repeat(times));
	}
	
	public <E extends Enum<E>> void printEnum(Boolean transpose, Class<E> enumToShow) {
		printLine("-", 30);
		for (E enumItem : enumToShow.getEnumConstants()) {
			if (transpose) {
				System.out.print("|" + enumItem + "|");
			} else {
				System.out.println(enumItem);
			}
		}
		printLine("-", 30);
	}
}
