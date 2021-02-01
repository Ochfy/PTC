package fr.ptc.devoir.exception;
 

public enum PartitionErrorCode  implements BasicException.ErrorCode {

	GENERIC(500, "An error occurred"
	),
	API_NOT_FOUND(//
			404, "Api could not be found"//
	), //
	SIZE_UNSUPPORTED(//
			500, "la taille doit être supérieur à 0"//
	), //
	EMPTY_ELEMENT(//
			500, "la liste à partionner ne doit pas être vide" //
	);

	private int statusCode;

	private String message;

	/**
	 * Basic constructor.
	 * 
	 * @param statusCode
	 *            the code status.
	 * @param code
	 *            the code.
	 * @param defaultMessage
	 *            the message
	 */
	PartitionErrorCode(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;	}

	public int statusCode() {
		return statusCode;
	}

	public String message() {
		return message;
	}
	 
 

}
