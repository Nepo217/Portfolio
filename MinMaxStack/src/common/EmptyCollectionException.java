package common;

public class EmptyCollectionException extends RuntimeException {

	private static final long serialVersionUID = -4041845599883567731L;

	public EmptyCollectionException() {
		super();
	}

	public EmptyCollectionException(String message) {
		super(message);
	}
}
