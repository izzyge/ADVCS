import java.util.*;

public class Classwork{
public static void main(String[] args){

  String[] letters = "a b c d e f g h a b c d e f g h i j k".split(" ");
    Set<String> stringset = new TreeSet<String>();
    Set<String> duplicateset = new TreeSet<String>();
    for(int i = 0;i<letters.length;i++){
      if(stringset.contains(letters[i])){
        duplicateset.add(letters[i]);
        }
      stringset.add(letters[i]);
    }

    System.out.println(stringset);

    // for(int i = 0;i<letters.length;i++){
    // if(stringset.contains(letters[i])){
    //   duplicateset.add(letters[i]);
    //   }
    // }

    System.out.println(duplicateset);

    String[] numbers = "one two three one two three six seven one two".split(" ");
    Set<String> stringset2 = new TreeSet<String>();
    Set<String> duplicateset2 = new TreeSet<String>();
    for(int i = 0;i<numbers.length;i++){
      if(stringset2.contains(numbers[i])){
        duplicateset2.add(numbers[i]);
        }
        stringset2.add(numbers[i]);

    }

    System.out.println(stringset2);

    System.out.println(duplicateset2);

    int[] integers = {3,5,4,7,5,17,29,17,4,6,56,72,6};
    Set<Integer> intset = new TreeSet<Integer>();
    Set<Integer> intset2 = new TreeSet<Integer>();
    for(int i = 0;i<integers.length;i++){
    if(integers[i]% 2 == 1){
    intset.add(integers[i]);
      }
    }

    System.out.println(intset);

    for(int i = 0;i<integers.length;i++){
    if(integers[i]% 2 == 0){
    intset2.add(integers[i]);
      }
    }

    System.out.println(intset2);

    int[] list1 = {1,5,9,4,6,8,12,1};
    int[] list2 = {6,5,8,9,11,7,10,11};
    Set<Integer> duplicateset3 = new TreeSet<Integer>();
    for(int i = 0;i<list1.length;i++){
    for(int j = 0;j<list2.length;j++){
      if(list1[i] == list2[j]){
        duplicateset3.add(list1[i]);
        }
      }
    }
    System.out.println(duplicateset3);
}
}
