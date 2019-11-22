import java.util.*;
public class Hash{
  Set<Integer> intSet;
  Set<String> stringSet;
  public String[] getUniques(String[] list){
    stringSet = new TreeSet<String>();
    String[] uniques;
    for(int i = 0; i<list.length; i++){
      stringSet.add(list[i]);
      if(stringSet.contains(list[i]) == false)
        uniques.add(list[i]);
    }

    return uniques;

  }

  public String[] getDuplicates(String[] list){
    stringSet = new TreeSet<String>();
    String[] uniques;
    for(int i = 0; i<list.length; i++){
      stringSet.add(list[i]);
      if(stringSet.contains(list[i]))
        uniques.add(list[i]);
    }

    return uniques;
  }
}
