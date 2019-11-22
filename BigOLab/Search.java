import java.util.*;
public class Search{
int x = 0;
  public int binarySearch (ArrayList<Student> students, String last, int start_pos, int end_pos ){
    this.x = 0;
		int startPos = start_pos;
		int endPos = end_pos;

		while (startPos <= endPos) {
			x++;
			int mid = (startPos + endPos) / 2;

			if (students.get(mid).getLastName().equals(last)) {
				return mid + 1;
			} else if (students.get(mid).getLastName().compareTo(last) > 0) {
				endPos = mid - 1;

			} else if (students.get(mid).getLastName().compareTo(last) < 0) {
				startPos = mid + 1;
			}

		}

		return -1;

  }

  public int sequentialSearch(ArrayList<Student> students, String lastName) {
		x = 0;

		for (int i = 0; i < students.size(); i++) {
			x++;

			if (students.get(i).getLastName().equals(lastName))
				return i + 1;
		}

		return -1;
	}

	public int getCalls(){
		return x;
  }

  public ArrayList<Student> bubbleSort(ArrayList<Student> students){

		x = 0;

		Student temp;

		for (int i = 0; i < students.size(); i++) {
			for (int j = i + 1; j < students.size(); j++) {
				x++;

				if (students.get(i).getLastName().compareTo(students.get(j).getLastName()) > 0) {
					temp = students.get(i);
					students.set(i, students.get(j));
					students.set(j, temp);
				}
			}
		}

    return students;

  }

  public ArrayList<Student> mergeSort(ArrayList<Student> students, int start, int end){

		x = 0;
    int mid = (start + end) / 2;

		if (mid == start)
			return students;

		this.mergeSort(students, start, mid);
		this.mergeSort(students, mid, end);

		return this.merge(students, start, end);

  }
  

  private ArrayList<Student> merge(ArrayList<Student> students, int start, int end) {

		x++;
		Student[] temp = new Student[end - start];

		int mid = (start + end) / 2;
		int i = start;
		int j = mid;
		int k = 0;

		while (i < mid && j < end) {
			if (students.get(i).getLastName().compareTo(students.get(j).getLastName()) < 0) {
				temp[k] = students.get(i);
				i++;
			} else {
				temp[k] = students.get(j);
				j++;
			}

			k++;
		}

		while (i < mid) {
			temp[k] = students.get(i);
			i++;
			k++;
		}

		while (j < end) {
			temp[k] = students.get(j);
			j++;
			k++;
		}

		for (i = 0; i < end - start; i++) {
			students.set(start + i, temp[i]);
		}

    return students;

	}


  public String toString(ArrayList<Student> students) {
		String returnVal = "";

		for (int i = 0; i < students.size(); i++) {
			returnVal += (i + 1) + ". " + students.get(i).toString() + "\n";
		}

		return returnVal.substring(0, returnVal.length() - 1);
	}
}
