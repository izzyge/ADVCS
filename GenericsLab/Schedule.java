import java.util.ArrayList;
public class Schedule{
  private ArrayList<Pair<Integer,String>> mySchedule;
  public Schedule(){
    mySchedule = new ArrayList<Pair<Integer,String>>();
  }

  public void addClass(int period, String course){
    boolean exists = false;
    for(int i=0; i<mySchedule.size(); i++){
      if(mySchedule.get(i).getK() == period)
        mySchedule.remove(i);
    }

    Pair<Integer,String> n = new Pair<Integer,String>(period, course);
    mySchedule.add(n);


    for(int i=0; i<mySchedule.size(); i++){
      for(int j = i+1; j<mySchedule.size();j++){
        if(mySchedule.get(j).getK()<mySchedule.get(i).getK()){
          Pair<Integer,String> temp = mySchedule.get(j);
          mySchedule.set(j,mySchedule.get(i));
          mySchedule.set(i, temp);
        }

      }
    }
  }

  public String toString(){
    String val = "";
    for(int i=0; i<mySchedule.size(); i++){
      val= val + mySchedule.get(i).getK() + ":" + mySchedule.get(i).getV() + "\n";
    }
    return val;
  }

  public void deletePeriod(int period) {
		for (int i = 0; i < mySchedule.size(); i++) {
			if (mySchedule.get(i).getK() == period) {
				mySchedule.remove(i);
			}
		}
	}
}
