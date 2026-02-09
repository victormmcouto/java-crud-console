package application.services;

public class ConsoleOutputService implements OutputService {
	private static final class AnsiColors {
		public static final String RESET = "\u001B[0m";

	    public static final String RED = "\u001B[31m";
	    public static final String GREEN = "\u001B[32m";
	    public static final String YELLOW = "\u001B[33m";
	    public static final String CYAN = "\u001B[36m";
	}
	
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
				System.out.println(AnsiColors.YELLOW + enumItem + AnsiColors.RESET);
		}
		printLine();
	}
	
	@Override
	public void printError(String message) {
		printLine();
		System.out.println(AnsiColors.RED + "Erro: " + message + AnsiColors.RESET);
		printLine();
	}
	
	@Override
	public void printInputMessage(String message) {
		System.out.print(AnsiColors.GREEN + message + AnsiColors.RESET);
		System.out.flush();
	}
	
	private void printLine() {
		System.out.println(AnsiColors.CYAN  + "-".repeat(36) + AnsiColors.RESET);
	}
}
