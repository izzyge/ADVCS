public class Search{
int x = 0;
public int binarySearch (int [] list, int value, int start_pos, int end_pos ){
	x = 0;
	if(start_pos<=end_pos){
		//find the middle position
		int middle = (start_pos + end_pos)/2;
		//if the middle number is equal to the value
		if(list[middle]==value)
		{
			System.out.println("found");
			return middle;
		}
			//print the word "found"
			//return the middle position
		//if the middle number is greater than the value
		else if(list[middle] > value){
			System.out.println("split");
			x++;
      return binarySearch(list, value, start_pos, middle-1);
    }


    else if(list[middle]<value)
    {
      System.out.println("split");
      return binarySearch(list, value, middle+1,end_pos);

    }

  	}
  	return -1;
  }

	public int getCalls(){
		return x;
}
}
