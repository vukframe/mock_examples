package rs.edu.raf.mock_examples.unit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import rs.edu.raf.mock_examples.ProteinEntry;
import rs.edu.raf.mock_examples.ProteinTracker;
import rs.edu.raf.mock_examples.exceptions.InvalidDataException;
import rs.edu.raf.mock_examples.exceptions.InvalidTypeException;
import rs.edu.raf.mock_examples.exceptions.NegativeProteinIncreaseException;
import rs.edu.raf.mock_examples.unit.categories.ExceptionCategory;

import java.util.List;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;


public class ProteinTrackerTest {

    private ProteinTracker proteinTracker;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    ProteinEntry proteinEntry;

    // Izvrsava se pre svakog testa.
    @Before
    public void setUp() {
        proteinTracker = new ProteinTracker();
    }

    // Izvrsava se posle svakog testa.
    @After
    public void tearDown() {
        proteinTracker = null;
    }

    @Test
    public void constructorTest() {
        Assert.assertNotNull(proteinTracker.getProteinCount());
        Assert.assertNotNull(proteinTracker.getHistory());

        Assert.assertEquals(new Double(0), proteinTracker.getProteinCount());
        Assert.assertEquals(0, proteinTracker.getHistory().size());
    }

    // Imenujemo testove kao i metode koje testiramo jer ih onda lakse pronalazimo.
    @Test
    public void addProteinTest() throws Exception {
        Double expected = 10D;
        proteinTracker.addProtein(expected);

        Double actual = proteinTracker.getProteinCount();
        Assert.assertEquals("Kolicina proteina posle unosa nije ocekivana!", expected, actual);

        List<ProteinEntry> proteinEntries = proteinTracker.getHistory();
        Assert.assertEquals("Broj istorijskih unosa nije ocekivan!", 1, proteinEntries.size());
        Assert.assertEquals(expected, proteinEntries.get(0).getAmount());
    }

    @Test
    @Category({ExceptionCategory.class})
    public void addProteinTestWithNegativeValue() throws Exception {
        thrown.expect(NegativeProteinIncreaseException.class);
        thrown.expectMessage("Negativna vrednost je uneta za povecanje kolicine proteina!");

        proteinTracker.addProtein(-10D);
    }

    @Test
    @Category({ExceptionCategory.class})
    public void addProteinTestWithNullValue() throws Exception {
        thrown.expect(InvalidTypeException.class);
        thrown.expectMessage("Tip parametra nije prihvatljiv!");

        proteinTracker.addProtein(null);
    }

    // Imenujemo testove kao i metode koje testiramo jer ih onda lakse pronalazimo.
    @Test
    public void reduceProtein() throws Exception {
        Double expected = 0D;
        proteinTracker.addProtein(10D);
        proteinTracker.reduceProtein(10D);

        Double actual = proteinTracker.getProteinCount();
        Assert.assertEquals( "Kolicina proteina posle unosa nije ocekivana!", expected, actual);

        List<ProteinEntry> proteinEntries = proteinTracker.getHistory();
        Assert.assertEquals( "Broj istorijskih unosa nije ocekivan!",2,  proteinEntries.size());
        Assert.assertEquals(new Double(10), proteinEntries.get(0).getAmount());
        Assert.assertEquals(new Double(-10), proteinEntries.get(1).getAmount());
    }

    @Test
    @Category({ExceptionCategory.class})
    public void reduceProteinWithNegativeValue() throws Exception {
        thrown.expect(NegativeProteinIncreaseException.class);
        thrown.expectMessage("Negativna vrednost je uneta za povecanje kolicine proteina!");

        proteinTracker.reduceProtein(-10D);
    }

    @Test
    @Category({ExceptionCategory.class})
    public void reduceProteinTestWithNullValue() throws Exception {
        thrown.expect(InvalidTypeException.class);
        thrown.expectMessage("Tip parametra nije prihvatljiv!");

        proteinTracker.addProtein(null);
    }

    @Test
    @Category({ExceptionCategory.class})
    public void reduceProteinTestWithLowerThanZeroCount() throws Exception {
        thrown.expect(InvalidDataException.class);
        thrown.expectMessage("Kolicina proteina pada ispod nule!");

        proteinTracker.reduceProtein(30D);
    }

    @Test
    public void getProteinCountTest() throws Exception {
        Double expected = 5D;
        proteinTracker.addProtein(20D);
        proteinTracker.reduceProtein(15D);

        Assert.assertEquals(proteinTracker.getProteinCount(), expected);
    }

    // Ovaj test je primer prihvatljive devijacije
    @Test
    public void getProteinCountTestWithDelta() throws Exception {
        Double expected = 5.01;
        proteinTracker.addProtein(10D);
        proteinTracker.reduceProtein(5D);

        Assert.assertEquals(expected, proteinTracker.getProteinCount(), 0.01);
    }

    @Test
    public void getHistoryTest() throws Exception {
        proteinTracker.addProtein(10D);
        proteinTracker.reduceProtein(5D);

        Assert.assertEquals(2, proteinTracker.getHistory().size());
    }

    @Test(timeout = 300)
    public void longRunningMethodTest() throws Exception {
        proteinTracker.addProtein(10D);
        proteinTracker.reduceProtein(5D);

        proteinTracker.longRunningMethod(200L);
    }
}
