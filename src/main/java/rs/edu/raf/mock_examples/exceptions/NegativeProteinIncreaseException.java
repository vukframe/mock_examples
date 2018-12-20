package rs.edu.raf.mock_examples.exceptions;

public class NegativeProteinIncreaseException extends RuntimeException{

    public NegativeProteinIncreaseException() {
        super("Negativna vrednost je uneta za povecanje kolicine proteina!");
    }
}
