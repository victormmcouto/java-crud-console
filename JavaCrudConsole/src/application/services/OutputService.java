package application.services;

public interface OutputService {
	public void printMessage(String message);
	public void printError(String message);
	public <E extends Enum<E>> void printEnum(Class<E> enumToShow, Boolean transpose);
}
