package excepciones;

public class StackVacioException extends Exception{

	private String message;

	public StackVacioException(String message) {
		super(message);
		
	}

	public String getMessage() {
		return message;
	} 
}