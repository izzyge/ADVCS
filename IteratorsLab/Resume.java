import java.util.*;


public class Resume {

	private String name;
	private String email;
	private String address;
	private String objectives;
	private String skills;

	private ArrayList<Education> schools;
	private ArrayList<Job> jobs;

	public Resume() {}

	public void init(String name, String email, String address, String objectives, String skills) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.objectives = objectives;
		this.skills = skills;

		schools = new ArrayList<Education>();
		jobs = new ArrayList<Job>();
	}

	public void addEducation(String name, String year, String month) {

		Education newEd = new Education(name, year, month);
		ListIterator<Education> it = schools.listIterator();

		while (it.hasNext()) {
			if (it.next().getGraduationDate().toString().compareTo(newEd.getGraduationDate().toString()) > 0) {
				it.previous();
				break;
			}
		}
		it.add(newEd);

	}

	public void addJob(String title, String company, String year, String month, String yearStart, String monthStart, String description) {
		Job newJob = new Job(title, company, year, month, yearStart, monthStart, description);
		ListIterator<Job> it = jobs.listIterator();

		while (it.hasNext()) {
			if (it.next().getEndDate().toString().compareTo(newJob.getEndDate().toString()) > 0) {
				it.previous();
				break;
			}
		}
		it.add(newJob);
	}

	public String educationToString() {
		ListIterator<Education> it = schools.listIterator();
		String val = "";

		while (it.hasNext()) {
			val += it.next().toString() + "\n";
		}

		return val;
	}

	public String jobsToString() {
		ListIterator<Job> it = jobs.listIterator();
		String val = "";

		while (it.hasNext()) {
			val += it.next().toString() + "\n";
		}

		return val;
	}

	public void removeSchool(int i) {
		schools.remove(i);
	}

	public void removeJob(int i) {
		jobs.remove(i);
	}

	public int getNumOfSchools() {
		return schools.size();
	}

	public int getNumOfJobs() {
		return jobs.size();
	}

	public String getName() {
		return name;
	}

	public String basicInfoToString() {
		return "Email: " + email + "\nAddress:" + address + "\nObjectives: " + objectives + "\nSkills: " + skills;
	}

}
