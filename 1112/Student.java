import java.io.Serializable;
import java.io.*;
import java.net.*;
import java.util.*;


public class Student implements Serializable{
  String name;
  int id;
  public Student(String name, int id){
    this.name = name;
    this.id = id;
  }

  public String toString(){
    return name + ": " + id;
  }

  public int getID(){
    return id;
  }

  public String getName() {
    return name;
  }
}
