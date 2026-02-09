package application.services;

public class ConsoleOutputService implements OutputService {
	@Override
	public void printMessage(String message) {
		printLine();
		System.out.println(message);
		printLine();
	}
	
	@Override
	public <E extends Enum<E>> void printEnum(Class<E> enumToShow) {
		printLine();
		for (E enumItem : enumToShow.getEnumConstants()) {
				System.out.println(enumItem);
		}
		printLine();
	}
	
	@Override
	public void printError(String message) {
		printLine();
		System.err.println("Erro: " + message);
		printLine();
	}
	
	@Override
	public void printInputMessage(String message) {
		System.err.print(message);
	}
	
	private void printLine() {
		System.out.println("-".repeat(36));
	}
}
