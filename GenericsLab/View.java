import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public abstract class View extends JPanel {

	public View() {
		this.setLayout(null);
		this.setFocusable(true);
	}

	public Dimension getPreferredSize() {
		return new Dimension(800,600);
	}

	public final void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 600);
		this.draw(g);
	}

	public abstract void draw(Graphics g);

}
