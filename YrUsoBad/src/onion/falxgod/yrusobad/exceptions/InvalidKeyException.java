package onion.falxgod.yrusobad.exceptions;

public class InvalidKeyException extends Exception {
	private static final long serialVersionUID = 6067093865179491811L;
	
	public InvalidKeyException(String key) {
		super("Invalid Key in JSON; " + key + "expacted.");
	}
	
	public InvalidKeyException() {
		super("Invalid Key in JSON");
	}
}
