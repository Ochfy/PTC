package fr.ptc.devoir.exception;
/**
 * 
 * @author sochfy
 *
 */
public class PartitionException extends BasicException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PartitionException(String message, int statusCode) {
		super(message, statusCode);
	}
}
