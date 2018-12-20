package rs.edu.raf.mock_examples.unit;

import org.junit.Assert;
import org.junit.Test;
import rs.edu.raf.mock_examples.ProteinEntry;

import java.time.LocalDateTime;


public class ProteinEntryTest {

    @Test
    public void constructorTest() {
        LocalDateTime timeStampNow = LocalDateTime.now();
        ProteinEntry proteinEntry = new ProteinEntry(10D);

        Assert.assertNotNull(proteinEntry.getAmount());
        Assert.assertNotNull(proteinEntry.getTimestamp());

        Assert.assertEquals(new Double(10), proteinEntry.getAmount());
        Assert.assertTrue(proteinEntry.getTimestamp().isAfter(timeStampNow));
        Assert.assertTrue(proteinEntry.getTimestamp().isBefore(LocalDateTime.now().plusSeconds(1)));
    }
}
