package exception;

public class FeuIntensiteException extends Exception {
	
	public FeuIntensiteException() {
		super("Mauvaise intensit� pour ce feu, les intensit�s possibles sont 1, 2 ou 3");
		// TODO Stub du constructeur g�n�r� automatiquement
	}

	public FeuIntensiteException(String message) {
		super(message);
		// TODO Stub du constructeur g�n�r� automatiquement
	}

}
