import java.util.*;
public class Patient implements Comparable<Patient>{
  private String name, illness, note, age;
  private int priority, time;

  public Patient(String name, String illness, int priority, String age, int time, String note){
    this.name = name;
    this.illness = illness;
    this.priority = priority;
    this.age = age;
    this.time = time;
    this.note = note;
  }

  public Patient(String name){
    this.name = name;
    illness = "";
    priority = 0;
    age = "";
    time = 0;
    note = "";
  }

  @Override
  public int compareTo(Patient p){
    int pri = p.getPriority();

    if (pri > this.priority) {
			return -1;
		} else if (pri < this.priority) {
			return 1;
		} else if (pri == this.priority) {

			if (age.equals("Child")&& p.getAge().equals("Adult")){
        return -1;
      } else if (age.equals("Adult")&& p.getAge().equals("Child")){
        return 1;
      } else if(p.getTime() > this.time) {
				return 1;
			}

			return 1;

		}

    return 1;
  }

  public boolean equals(Object o){
    Patient p = (Patient) o;
    if(this.name.equals(p.getName())){
      return true;
    } else {
      return false;
    }
  }

  public void updNote(String note){
    this.note = note;
  }

  public String getNote(){
    return note;
  }

  public void updIllness(String illness ){
    this.illness = illness;
  }

  public void updPriority(int pri){
    priority = pri;
  }

  public String getName(){
    return name;
  }

  public String getIllness(){
    return illness;
  }

  public int getPriority(){
    return priority;
  }

  public String getPriorityStr(){
    if(priority == 1)
      return "High";
    else if(priority == 2)
      return "Medium";
    else
      return "Low";

  }

  public String getAge(){
    return age;
  }

  public int getTime(){
    return time;
  }

  public String getTimeStr(){
    char[] chars = ("" + time).toCharArray();
    String time = "";
    for(char each: chars)
      time += each;
    return time.substring(0,2) + ":" + time.substring(2,time.length());
  }

  public String toString(){
    return name + ": " + illness + ", " + getPriorityStr() + " priority, " + age + ", " + getTimeStr();
  }



}
