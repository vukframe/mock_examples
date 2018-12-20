package rs.edu.raf.mock_examples.unit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import rs.edu.raf.mock_examples.ProteinEntry;
import rs.edu.raf.mock_examples.ProteinTracker;
import rs.edu.raf.mock_examples.ReportGenerator;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReportGeneratorTest {

    @InjectMocks
    public ReportGenerator reportGenerator;

    @Mock
    private ProteinTracker proteinTracker;

    @Mock
    private ProteinEntry proteinEntry;

    @Test
    public void generateReportTest() throws Exception {
        // Pri pozivanju metode getAmount na klasi ProteinTracker presrecemo poziv i umecemo svoj odgovor
        when(proteinEntry.getAmount()).thenReturn(20D);
        when(proteinEntry.getTimestamp()).thenReturn(LocalDateTime.of(1993, 11, 15, 0,0,0));
        when(proteinTracker.getHistory()).thenReturn(Collections.singletonList(proteinEntry));

        // Presrecemo poziv metode longRunningMethod sa bilo kojim ulaznim parametrom i samo ignorismo
        doNothing().when(proteinTracker).longRunningMethod(anyLong());

        String report = reportGenerator.generateReport(proteinTracker);

        //Proveravamo da se u rezultatu nalaze oba stringa
        Assert.assertThat(report, allOf(containsString("1993-11-15T00:00"), containsString("20.0")));

        //Proveravamo da se longRunningMethod metoda pozvala tacno jedan put sa parametrom 200L
        verify(proteinTracker, times(1)).longRunningMethod(200L);

        // Ispis u konzolu
        System.out.println(report);
    }
}
