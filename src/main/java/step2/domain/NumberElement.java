package step2.domain;

public class NumberElement {
	private int number;

	public NumberElement(int number) {
		this.number = number;
		validate();
	}

	public NumberElement(String number) {
		try {
			this.number = Integer.parseInt(number);
		} catch (Exception e) {
			throw new RuntimeException(String.format("[ERROR] text is not Integer format. text = %s", number));
		}
		validate();
	}

	public int getNumber() {
		return this.number;
	}

	public void validate() {
		if (this.number <= 0) {
			throw new RuntimeException(String.format("[ERROR] Number is negative. number = %d", this.number));
		}
	}
}
