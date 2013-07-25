package arm.developer.gsportscenter.arrayadapter;

public enum AdapterVenues {

	golf("Golf Simulator", "Golf Simulator"), futsal("Futsal", "Futsal"), badminton(
			"Badminton", "Badminton");

	private String text;
	private String value;

	AdapterVenues(String text, String value) {
		this.text = text;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String toString() {
		return text;
	}

}
