public class MyItem<K,V>{
  private K name;
  private V price;
  public MyItem(K key, V value){
    name = key;
    price = value;
  }

  public String toString(){
    return name + " $" + price;
  }
}
