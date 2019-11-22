import java.util.Scanner;
import java.util.ArrayList;
public class Runner{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Search s = new Search();
		System.out.println("Enter Array Size: ");
		int size = sc.nextInt();
		int[] array = new int[size];
		for(int i=0; i<size; i++){
			array[i] = (int)(Math.random()*99 + 1);
}
for(int i = 0;i<size-1;i++)
{
	for(int j = i+1;j<size;j++)
	{
		if(array[j]<array[i])
{
	int temp = array[i];
	Array[i] = array[j];
	Array[j] = temp;
}
	}
}
for(int i = 0;i<size;i++)
{
System.out.println(array[i]);
}


System.out.println("Enter Search Value: ");
int val = sc.nextInt();
System.out.println(s.binarySearch(array, val, 0, size));
System.out.println(s.getCalls()+ " calls");

}
}
