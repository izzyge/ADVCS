public class Education {

	private String name;
	private String degree;
	private Date graduationDate;

	public Education(String name, String year, String month) {
		this.name = name;
		this.graduationDate = new Date(year, month);
	}

	public Date getGraduationDate() {
		return this.graduationDate;
	}

	public String toString() {
		return this.name  + "\n" + this.graduationDate.toString() + "\n";
	}

}
