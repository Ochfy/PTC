package fr.ptc.devoir.exception;

 

import java.util.List;

/**
 * @author Sochfy
 *
 */
public abstract class BasicException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String message;
	protected int statusCode;
	protected Throwable cause;

	public interface ErrorCode {

		public int statusCode();

		public String message();
	}

	public static BasicException of(ErrorCode errorCode) {
		return null;
	}

	public static BasicException of(ErrorCode errorCode, List<ErrorCode> errors) {
		return null;
	}

	public BasicException(String message) {
		super(message);
	}

	public BasicException(String message, int statusCode) {
		super(message);
		this.message = message;
		this.statusCode = statusCode;
	}

	public BasicException(int statusCode, Throwable cause) {
		super(cause.getMessage(), cause);
		this.cause = cause;
		this.message = cause.getMessage();
		this.statusCode = statusCode;
	}

}

