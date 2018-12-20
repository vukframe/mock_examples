package rs.edu.raf.mock_examples;

import rs.edu.raf.mock_examples.exceptions.InvalidDataException;
import rs.edu.raf.mock_examples.exceptions.InvalidTypeException;
import rs.edu.raf.mock_examples.exceptions.NegativeProteinIncreaseException;

import java.util.ArrayList;
import java.util.List;

public class ProteinTracker {
    private Double proteinCount;
    private List<ProteinEntry> proteinEntries;

    public ProteinTracker() {
        super();
        this.proteinCount = 0D;
        this.proteinEntries = new ArrayList<>();
    }

    // Metoda za dodavanje proteina. Negativna ili null vrednost ce baciti gresku.
    public void addProtein(Double amount) throws NegativeProteinIncreaseException, InvalidTypeException {
        if (amount == null) {
            throw new InvalidTypeException();
        }

        if (amount < 0) {
            throw new NegativeProteinIncreaseException();
        }

        proteinEntries.add(new ProteinEntry(amount));
        proteinCount += amount;
    }

    // Metoda za smanjivanje proteina. Pozitivna ili null vrednost ce baciti gresku.
    public void reduceProtein(Double amount) throws InvalidTypeException {
        if (amount == null) {
            throw new InvalidTypeException();
        }

        if (amount < 0) {
            throw new NegativeProteinIncreaseException();
        }

        if (getProteinCount() - amount < 0) {
            throw new InvalidDataException("Kolicina proteina pada ispod nule!");
        }

        proteinEntries.add(new ProteinEntry(-amount));
        proteinCount -= amount;
    }

    // Ukupna trenutna suma proteina
    public Double getProteinCount() {
        return proteinCount;
    }

    // Istorija svih izmena
    public List<ProteinEntry> getHistory() {
        return proteinEntries;
    }

    public void longRunningMethod(Long milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

}
