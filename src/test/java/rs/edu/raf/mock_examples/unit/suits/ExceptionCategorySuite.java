package rs.edu.raf.mock_examples.unit.suits;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import rs.edu.raf.mock_examples.unit.GeneralniPrimeriTest;
import rs.edu.raf.mock_examples.unit.ProteinEntryTest;
import rs.edu.raf.mock_examples.unit.ProteinTrackerTest;
import rs.edu.raf.mock_examples.unit.categories.ExceptionCategory;

// Kategorije nasledjuju suite
@RunWith(Categories.class)
@Categories.IncludeCategory(ExceptionCategory.class)
@Suite.SuiteClasses({GeneralniPrimeriTest.class, ProteinEntryTest.class, ProteinTrackerTest.class})
public class ExceptionCategorySuite {
}
