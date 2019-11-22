public class Runner{
  public static void main(String[] args){
    String[] letters = "a b c d e f g h a b c d e f g h i j k".split(" ");
    String[] words = "one two three one two three six seven one two".split(" ");
    int[] nums = {3, 5, 4, 7, 5, 17, 29, 17, 4, 6, 56, 72, 6};
    int[] list1 = {1, 5, 9, 4, 6, 8, 12, 1};
    int[] list2 = {6, 5, 8, 9, 11, 7, 10, 11};
    Hash hash = new Hash();
    System.out.println(hash.getUniques(letters));
    System.out.println(hash.getDuplicates(letters));
  }
}
