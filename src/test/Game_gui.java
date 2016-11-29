package test;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game_gui {

	public static void main(String[] args){
		JFrame Game = new JFrame("Game");
		Game.setBounds(0, 0, 1024, 660);
	    Game.setResizable(false);
	    Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon back = new ImageIcon("Game.png");
		
		JPanel GameP= new JPanel()
		{
	        public void paintComponent(Graphics g) {
	            g.drawImage(back.getImage(), 0, 0, null);
	        }
		};
		GameP.setLayout(null);
		JButton Start= new JButton("Start");
		JButton Quit = new JButton("Exit");
		
		Start.setBounds(732, 534, 140, 93);
		Quit.setBounds(874, 534, 140, 93);
		
		GameP.add(Start);
		GameP.add(Quit);
		
		Game.add(GameP);
		
		
		Game.setVisible(true);
		
	}

}
