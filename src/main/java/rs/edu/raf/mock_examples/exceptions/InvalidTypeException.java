package rs.edu.raf.mock_examples.exceptions;

public class InvalidTypeException extends Exception{
    public InvalidTypeException() {
        super("Tip parametra nije prihvatljiv!");
    }
}
