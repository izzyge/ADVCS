import java.util.Scanner;
public class Runner2{
    public static void main(String[] args){
        Profile[] profiles = new Profile[10];
        profiles[0] = new Profile("Bob",1);
       profiles[1] = new Profile("Bart",5);
       profiles[2] = new Profile("Bill",7);
       profiles[3] = new Profile("Billy",2);
       profiles[4] = new Profile("Becky",6);
       profiles[5] = new Profile("Bethany",12);
       profiles[6] = new Profile("Bobby",19);
       profiles[7] = new Profile("Barry",48);
       profiles[8] = new Profile("Bazz",124);
       profiles[9] = new Profile("Benji",124);

       Scanner s = new Scanner(System.in);



for(Profile each: profiles){
    System.out.println(each);
}

System.out.println("If you want to sort by age type AGE");
System.out.println("If you want to scramble type SCRAMBLE");
System.out.println("If you want to sort by name type NAME");

String what = s.next();

if(what.equals("AGE")){
for(int i = 0; i<profiles.length; i++){
    for(int j = i+1; j<profiles.length-1; j++){
        if(profiles[j].getAge()< profiles[i].getAge()){
            Profile temp = profiles[j];
            profiles[j] = profiles[i];
            profiles[i] = temp;
}
}
}

for(Profile each: profiles){
    System.out.println(each);
}
}



if(what.equals("SCRAMBLE")){
for(int i = 0; i<profiles.length; i++){
    int n = (int)(Math.random() * profiles.length);
    Profile temp = profiles[n];
    profiles[n] = profiles[i];
    profiles[i] = temp;
}

for(Profile each: profiles){
    System.out.println(each);
}
}

if(what.equals("NAME")){
for(int i = 0; i<profiles.length; i++){
	for(int j = i+1; j<profiles.length; j++){
			if(profiles[j].getName().compareTo(profiles[i].getName())<0){
					Profile temp = profiles[j];
					profiles[j] = profiles[i];
					profiles[i] = temp;
}
}
}

for(Profile each: profiles){
    System.out.println(each);
}
}

}

}
