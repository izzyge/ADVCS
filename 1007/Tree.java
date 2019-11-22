import java.util.*;
public class Tree{
public static void main(String[] args)
{
Map<Character,Integer> map;
map = new TreeMap<Character,Integer>();

String s = "a b c d e f g h i a c d e g h i h k";
for(char c : s.toCharArray()){
   if(map.containsKey(c)){
      map.put(c,map.get(c)+1);
   } else{
      map.put(c,1);
   }
}
for(char c : map.keySet()){
    System.out.print(c+"\t");
    for(int i = 0;i<map.get(c);i++)
    {
	System.out.print("*");
    }
    System.out.println();
}
}
}
