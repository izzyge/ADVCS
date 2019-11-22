import java.util.*;
public class Warmup{
  public static void main(String[] args){
    Map<Student, Integer> hMap = new HashMap<>();
    Map<Student, Integer> tMap = new TreeMap<>();
    hMap.put(new Student("John", 1234), 17);
    hMap.put(new Student("Paula", 4321),16);
    hMap.put(new Student("Paula", 4321),15);
    hMap.put(new Student("Jose", 1111),18);
    hMap.put(new Student("John", 1233),17);
    tMap.put(new Student("John", 1234), 17);
    tMap.put(new Student("Paula", 4321),16);
    tMap.put(new Student("Paula", 4321),15);
    tMap.put(new Student("Jose", 1111),18);
    tMap.put(new Student("John", 1233),17);

    for(Student s: hMap.keySet())
        System.out.println(s + ", " + hMap.get(s));
    System.out.println();
    for(Student s: tMap.keySet())
        System.out.println(s + ", " +tMap.get(s));
  }
}
