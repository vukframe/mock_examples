package rs.edu.raf.mock_examples;

import java.time.LocalDateTime;

public class ProteinEntry {
	private Double amount;
	private LocalDateTime timestamp;

	public ProteinEntry(Double amount) {
		super();
		this.amount = amount;
		this.timestamp = LocalDateTime.now();
	}

	public Double getAmount() {
		return amount;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}
