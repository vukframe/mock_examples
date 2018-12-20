package rs.edu.raf.mock_examples;

import java.util.List;

public class ReportGenerator {

    public String generateReport(ProteinTracker proteinTracker) throws InterruptedException {
        StringBuilder report = new StringBuilder();
        List<ProteinEntry> proteinEntryList = proteinTracker.getHistory();

        for (ProteinEntry p : proteinEntryList) {
            report.append(String.format("%s - %s \n", p.getTimestamp(), p.getAmount()));
        }

        proteinTracker.longRunningMethod(200L);

        return report.toString();
    }
}
