public class Date {
	 String year;
	 String month;

	public Date(String year, String month) {
		this.year = year;
		this.month = month;
	}

	public String toString() {
		return year + "-" + month;
	}
}
