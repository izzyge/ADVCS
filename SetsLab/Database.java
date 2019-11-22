import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.math.*;
public class Database {
	private HashSet<Item> hashSetItems;
	private TreeSet<Item> treeSetItems;
	private ArrayList<Pair<Item, Integer> > shoppingCart;

	public Database(String fileName) {

		hashSetItems = new HashSet<Item>();
		treeSetItems = new TreeSet<Item>();
		shoppingCart = new ArrayList<Pair<Item, Integer> >();

		try {
			Scanner in = new Scanner(new File(fileName));

			while (in.hasNextLine()) {

				String[] itemParts = in.nextLine().split(",");
				Item item = new Item(itemParts[0], Double.parseDouble(itemParts[1]));

				hashSetItems.add(item);
				treeSetItems.add(item);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}


	public String getItems() {
		Iterator it = treeSetItems.iterator();
    String items = "";

		while (it.hasNext()) {
			items += it.next().toString() + "\n";
		}

    return items;

  }

	public String getCart(){
		String items = "";
		for(int i=0; i<shoppingCart.size(); i++){
			items += shoppingCart.get(i).toString() + "\n";
		}

    return items;
	}

	public void addToCart(Item item, int quantity) {

		if (hashSetItems.contains(item) == false)
			return;

		for (int i = 0; i < shoppingCart.size(); i++) {
			if (shoppingCart.get(i).getK().compareTo(item) == 0) {
				shoppingCart.remove(i);
			}
		}

		if (quantity > 0) {
			Pair<Item, Integer> p = new Pair<Item, Integer>(item, quantity);
			shoppingCart.add(p);
		}
	}

	public void addToSet(Item item) {
		if (hashSetItems.contains(item))
			return;

		hashSetItems.add(item);
		treeSetItems.add(item);
	}

	public void removeFromSet(Item item) {

		if (!hashSetItems.contains(item))
			return;

		hashSetItems.remove(item);
		treeSetItems.remove(item);
	}

	public String cartToString() {
		String items = "";
		double totalCost = 0;

		for (int i = 0; i < shoppingCart.size(); i++) {
			Pair<Item, Integer> p = shoppingCart.get(i);
			Item item = p.getK();
			String name = item.getName();
			int quantity = p.getV();
			double price = this.round(item.getPrice() * quantity, 2);
			totalCost += price;

			items += name + ", quantity: " + quantity + ", price: $" + price + "\n";
		}

		totalCost = this.round(totalCost, 2);
		items += "Total: $" + totalCost;

		return items;
	}

	public static double round(double value, int places) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}


}
