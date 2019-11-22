public class MyItem<T>{
  private T obj;
  public MyItem(T obj){
    this.obj = obj;
  }
  public String toString(){
    return obj + " ";
  }
}
