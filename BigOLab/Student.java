import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class Student{
  private String first;
  private String last;
  private int age;

  public Student(String first, String last, int age){
    this.last = last;
    this.first = first;
    this.age = age;
  }

  public String getFirstName(){
    return first;
  }

  public String getLastName(){
    return last;
  }

  public int getAge(){
    return age;
  }

  public String toString(){
    return last + ", " + first + " - " + age;
  }
}
