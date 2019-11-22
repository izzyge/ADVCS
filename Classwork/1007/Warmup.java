import java.util.*;
public class Warmup{
  public static void main(String[] args){
    String str = "1 2 3 4 5 6 1 2 3 4 5 1 3 1 2 3 4";
    char[] chars = str.toCharArray();
    Map<Character, Integer> map = new TreeMap<Character, Integer>();
    for(char each: chars){
      if(map.containsKey(each))
        map.put(each, map.get(each) + 1);
      else
        map.put(each, 1);
    }

    for(char c: map.keySet()){
      System.out.print (c + "\t");
      for(int i=0; i<map.get(c); i++){
        System.out.print("*");
      }
      System.out.println();
    }


  }
}
