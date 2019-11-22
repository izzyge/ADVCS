public class Runner {
    public static void main(String[] args) {

        Item<Food> a = new Item<Food>(new Food("pizza", 2.0));
        Item<Food> b = new Item<Food>(new Food("pasta", 10.0));
        Item<String> c = new Item<String>("Bird");
        Item<String> d = new Item<String>("Dog");
        Item<Integer> e = new Item<Integer>((int)(Math.random() * 100 + 1));
        System.out.println(a.get());
        System.out.println(b.get());
        System.out.println(c.get());
        System.out.println(d.get());
        System.out.println(e.get());

    }
}
// Create 5 objects of the Item<T> class.  2 are of the Food Class,  2 are of the String class with names of Animals, and one of the Integer class with a random number.
// Print each of the 5 objects from Item utilizing the toString method.  Make sure to call get().
