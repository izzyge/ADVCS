import java.util.ArrayList;
import java.util.ListIterator;

public class Runner{
  public static void main(String[]args){
    ArrayList<Integer> list = new ArrayList<Integer>();
    ListIterator<Integer> it, fin;

    for(int i=0; i<5; i++){
      int num = (int)(Math.random()*99 + 1);
      it = list.listIterator();
      boolean added = false;
      while(it.hasNext()){
        if(it.next() <= num){
          it.previous();
          it.add(num);
          added = true;
          break;
        }
      }
      if(added == false)
        it.add(num);
    }

    fin = list.listIterator();
    while(fin.hasNext())
      System.out.print(fin.next() + "\t");
  }
}
