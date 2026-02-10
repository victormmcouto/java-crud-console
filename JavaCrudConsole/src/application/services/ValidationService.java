package application.services;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ValidationService {
	public <T extends Number> T validateNumber(String value, Class<T> type) {
		try {
			if (type == Integer.class) {
				return type.cast(Integer.valueOf(value));
			} else if (type == Double.class) {
				return type.cast(Double.valueOf(value));
			} else if (type == Long.class) {
				return type.cast(Long.valueOf(value));
			} else if (type == BigDecimal.class) {
				return type.cast(new BigDecimal(value));
			} else if (type == BigInteger.class) {
				return type.cast(new BigInteger(value));
			} 
			throw new IllegalArgumentException("Valor inválido!");
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Valor inválido!");	
		}
	}
	
	public String validateString(String value) {
		if (value == null || value.isEmpty()|| value.isBlank()) {
			throw new IllegalArgumentException("Valor inválido!");	
		}
		return value;
	}
	
	public <E extends Enum<E>> E validateEnum(String value, Class<E> tipo) {
		for (E enum_ : tipo.getEnumConstants()) {
			if (enum_.name().equalsIgnoreCase(value)) {
				return enum_;
			}
		}
		
		throw new IllegalArgumentException("Valor inválido!");
	}
}
