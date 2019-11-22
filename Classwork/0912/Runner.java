import java.util.ArrayList;
public class Runner{
  public static void main(String[] args){
    ArrayList<MyItem> list = new ArrayList<MyItem>();
    MyItem<String, Double> a = new MyItem<String, Double>("pizza",1.0);
    MyItem<String, Double> b = new MyItem<String, Double>("soda",1.0);
    MyItem<String, Double> c = new MyItem<String, Double>("water",2.0);

    list.add(a);
    list.add(b);
    list.add(c);

    for(MyItem each: list)
      System.out.println(each);
  }
}
