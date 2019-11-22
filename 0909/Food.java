public class Food {
    private String name;
    private double price;
    public Food(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String toString(){
        return name + " $" + price;
    }
}
