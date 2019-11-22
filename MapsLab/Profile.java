import java.util.*;
public class Profile implements Comparable<Profile>{
  private String firstName, lastName;
  private int birthYear;

  private String school;
  private char init1, init2;

  public Profile(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
    birthYear = (int)(Math.random()*4) + 2001;
    init1 = firstName.charAt(0);
    init2 = lastName.charAt(0);
  }

  public int compareTo(Profile p){
    if(lastName == p.getLast() && birthYear == p.getBirthyear()){
      return 0;
    } else if(lastName == p.getLast()){
      return birthYear - p.getBirthyear();
    } else {
      return lastName.compareTo(p.getLast());
    }

  }

  public boolean equals(Object o){
    Profile p = (Profile) o;
    return firstName == getFirst() && lastName == getLast() ;
  }

  public int hashCode(){
    int hash1 = firstName.hashCode();
    int hash2 = lastName.hashCode();
    return hash1 * hash2 * birthYear * 23;
  }

  public String getInit(){
    return init2 + "-" + init1;
  }

  public String getFirst(){
    return firstName;
  }

  public String getLast(){
    return lastName;
  }

  public int getBirthyear(){
    return birthYear;
  }

  public void setBirthYear(int year){
    birthYear = year;
  }

  public String toString(){
    return lastName + ", " + firstName + " - " + birthYear;
  }



}
