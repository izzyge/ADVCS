public class Item<T> {

    //Why do we use the Object class?
    private T o;

    public Item(T o){
        this.o = o;
    }

    public T get(){
        return o;
    }
}
