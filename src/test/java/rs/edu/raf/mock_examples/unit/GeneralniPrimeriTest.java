package rs.edu.raf.mock_examples.unit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import rs.edu.raf.mock_examples.ProteinTracker;
import rs.edu.raf.mock_examples.unit.categories.ExceptionCategory;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;

public class GeneralniPrimeriTest {
    private ProteinTracker proteinTracker;

    // Ovde definisemo prazan rule za exception-e u testovima
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // Izvrsava se pre svakog testa
    @Before
    public void setUp(){
        System.out.println("Pre svakog testa!");
    }

    // Izvrsava se posle svakog testa
    @After
    public void tearDown(){
        System.out.println("Posle svakog testa!");
    }

    // Izvrsava se na pocetku svakog case-a
    @BeforeClass
    public static void beforeAll(){
        System.out.println("Na pocetku izvrsavanja case-a!");
    }

    // Izvrsava se na kraju svakog case-a
    @AfterClass
    public static void afterAll(){
        System.out.println("Na kraju izvrsavanja case-a!");
    }

    // Ova vrsta testa je korisna da se obelezi da neki test nije zavrsen do kraja ili da naznaci da se neki exception nije desio
    @Test
    public void failingTest() {
        System.out.println("Padajuci test!");
        fail("Ovaj test je namenjen da padne");
    }

    @Test
    @Ignore("U svrhe demonstracije")
    public void skippedTest() {
        // not executed
    }

    // Testiramo da ce kod izbaciti odredjeni tip exception-a. (provera samo po tipu)
    // Takodje smo kategorisali ovaj test da bi kasnije pokrenuli sve testove koji testiraju exception-e.
    @Category({ExceptionCategory.class})
    @Test(expected = IndexOutOfBoundsException.class)
    public void exceptionByTypeTest() {
        throw new IndexOutOfBoundsException();
    }

    // Testiramo tip i poruku exception-a tako sto podesavamo kontekst testa pomocu rule-a.
    @Category({ExceptionCategory.class})
    @Test
    public void exceptionTypeAndMessageTest() {
        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");

        new ArrayList<Object>().get(0);
    }

    // Na ovaj nacin mozemo da testiramo mnogo vise od poruke i tipa exception-a.
    @Test
    @Category({ExceptionCategory.class})
    public void testExceptionInDepth() {
        try {
            new ArrayList<Object>().get(0);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
            Assert.assertThat(anIndexOutOfBoundsException.getMessage(), is("Index: 0, Size: 0"));
        }
    }
}
