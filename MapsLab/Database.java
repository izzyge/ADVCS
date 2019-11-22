import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.math.*;
public class Database {
	private Map<Profile, SchoolInfo> hMap, tMap;
  private String[] schools = {"Mountain View HS", "Los Altos HS", "Palo Alto HS", "Homestead HS", "Cupertino HS", "Lynbrook HS",
  "Monta Vista HS", "Alta Vista HS", "Fremont HS", "St Francis HS", "Gunn HS", "Wilcox HS"};
  private String[] classes = {"AP Comp Sci", "AP Spanish", "AP French", "AP World History", "AP Psychology", "AP Biology", "Dance", "Choir",
  "AP Calc BC" , "AP Statistics", "AP Physics 1", "HAmLit"};

	public Database(String fileName) {

		hMap = new HashMap<>();
    tMap = new TreeMap<>();

		try {
			Scanner in = new Scanner(new File(fileName));

			while (in.hasNextLine()) {

				String[] mapParts = in.nextLine().split(" ");
				Profile p = new Profile(mapParts[0], mapParts[1]);

        String cl = getNewClasses();

				hMap.put(p,new SchoolInfo(schools[getNum()], cl) );
        tMap.put(p,new SchoolInfo(schools[getNum()], cl) );
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}


	public String getProfiles() {
    String val = "";
	   for(Profile p: tMap.keySet()){
       val += p.toString() + "\n";
     }
    return val;

  }

  public String getSchool(Profile p){
    if(hMap.containsKey(p))
      return hMap.get(p).getSchool();
    return "Person not found";
  }

  public String getClasses(Profile p){
    if(hMap.containsKey(p))
      return hMap.get(p).getClasses();
    return "Person not found";
  }

  public void changeSchool(Profile p, String school){
    hMap.get(p).changeSchool(school);
    tMap.get(p).changeSchool(school);
  }

  public void addProfile(Profile p, String school){
    hMap.put(p, new SchoolInfo(school, getNewClasses()));
    tMap.put(p, new SchoolInfo(school, getNewClasses()));
  }

  public void removeProfile(Profile p){
    hMap.remove(p);
    tMap.remove(p);
  }

  public int getNum(){
    return (int)(Math.random()*11);
  }

  public String getNewClasses(){
    return classes[getNum()] + "  " + classes[getNum()] + "  " + classes[getNum()];
  }




}
