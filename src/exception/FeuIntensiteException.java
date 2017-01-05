package exception;

public class FeuIntensiteException extends Exception {
	
	public FeuIntensiteException() {
		super("Mauvaise intensité pour ce feu, les intensités possibles sont 1, 2 ou 3");
		// TODO Stub du constructeur généré automatiquement
	}

	public FeuIntensiteException(String message) {
		super(message);
		// TODO Stub du constructeur généré automatiquement
	}

}
