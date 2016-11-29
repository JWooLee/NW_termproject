package test;
import java.awt.*;
import javax.swing.*;


public class main_GUI {

	public static void main(String[] args ){
		
		
		JFrame Main = new JFrame("Main");
		Main.setBounds(0, 0, 1024, 660);
	    Main.setResizable(false);
	    Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon back = new ImageIcon("main_back.png");
		
		JPanel MainP= new JPanel()
		{
	        public void paintComponent(Graphics g) {
	            g.drawImage(back.getImage(), 0, 0, null);
	        }
		};
		MainP.setLayout(null);
		JButton Start= new JButton("Start");
		JButton Join= new JButton("Join");
		JButton Quit = new JButton("Quit");
		JButton Hist = new JButton("Histogram");
		
		Start.setBounds(733, 435, 280, 97);
		Join.setBounds(733, 534, 140, 93);
		Quit.setBounds(874, 534, 140, 93);
		Hist.setBounds(734, 335, 279, 97);
		
		
		MainP.add(Start);
		MainP.add(Hist);
		MainP.add(Join);
		MainP.add(Quit);
		
		Main.add(MainP);
		
		
		Main.setVisible(true);
		
		
		
		
	}
}
