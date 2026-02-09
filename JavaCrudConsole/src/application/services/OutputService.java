package application.services;

public class OutputService {
	public void printMessage(String message) {
		System.out.print(message);
	}
	
	public void printLine(String toRepeat, Integer times) {
		System.out.println(toRepeat.repeat(times));
	}
	
	public <E extends Enum<E>> void printEnum(Boolean transpose, Class<E> enumToShow) {
		for (E enumItem : enumToShow.getEnumConstants()) {
			if (transpose) {
				System.out.print("|" + enumItem + "|");
			} else {
				System.out.println(enumItem);
			}
		}
	}
}
