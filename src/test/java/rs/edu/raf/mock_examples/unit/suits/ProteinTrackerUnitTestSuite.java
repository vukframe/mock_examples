package rs.edu.raf.mock_examples.unit.suits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import rs.edu.raf.mock_examples.unit.ProteinEntryTest;
import rs.edu.raf.mock_examples.unit.ProteinTrackerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ProteinEntryTest.class,
        ProteinTrackerTest.class
})
public class ProteinTrackerUnitTestSuite {
}
