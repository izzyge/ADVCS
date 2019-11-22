import java.util.Scanner;
import java.util.ListIterator;
import java.util.ArrayList;
public class Runner
{
public static void main(String[] args)
{
	ArrayList<Item> list = new ArrayList<Item>();
  Scanner keyBoard = new Scanner(System.in);

	list.add(new Item("Apples",9.5));
	list.add(new Item("Banana",10.5));
	list.add(new Item("Mango",19.5));

	while(true){
         System.out.println("Enter name of Item, press q to delete, press a to show list ");
         String name = keyBoard.nextLine();
         if (name.equals("q")){
           System.out.println("What item you would like to delete?");
           String delete = keyBoard.nextLine();
           ListIterator<Item> list3 = list.listIterator();
           while(list3.hasNext()){
             if (list3.next().getName().equals(delete)) {
                list3.remove();
                 break;
             }
           }
         printList(list);

        }else if(name.equals("a")){
	         printList(list);
           System.out.println(addPrice(list));
           break;


        }else{
         	System.out.println("Enter price: ");
         	double price = keyBoard.nextDouble();
         	keyBoard.nextLine();
         	list.add(new Item(name, price));
          printList(list);

         }
       }

    }

 private static void printList(ArrayList<Item> list) {
     ListIterator<Item> list1 = list.listIterator();
     while(list1.hasNext()){
       System.out.println(list1.next());
     }
 }
  private static double addPrice(ArrayList<Item> list){
    ListIterator<Item> list2 = list.listIterator();
    double sum = 0;
    	  while(list2.hasNext()){
           	    sum += list2.next().getPrice();
        	 }
      return sum;
    }
	}
