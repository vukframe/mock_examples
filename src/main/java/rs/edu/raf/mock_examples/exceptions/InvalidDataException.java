package rs.edu.raf.mock_examples.exceptions;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException(String message) {
        super(message);
    }
}
