package exception;

public class ClientException extends RuntimeException {
	public ClientException() {}
	
	public ClientException(String msg) {super(msg);}
}
