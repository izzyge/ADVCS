import javax.swing.JFrame;
public class Main{
    public static void main(String[] args){
        Screen sc = new Screen();
        JFrame frame = new JFrame("Translator");

        frame.add(sc);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
