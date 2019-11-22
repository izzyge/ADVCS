import javax.swing.JFrame;


public class Runner{

    public static void main(String[] args){

     JFrame fr = new JFrame("Bank");
		 Program p = new Program();

		 fr.add(p);
		 fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 fr.pack();
		 fr.setVisible(true);

    }

}
