public class Pair<K,V>{
	private K key;
  private V value;
  public Pair(K key, V value){
    this.key = key;
    this.value = value;
  }

  public K getK(){
    return key;
  }

  public V getV(){
    return value;
  }

  public String toString(){
    return key + " : " + value;
  }
}
