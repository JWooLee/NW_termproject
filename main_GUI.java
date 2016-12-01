package crossword;


import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	            g.drawImage(back.getImage(), 0, 0,null);
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
		
		
		Main.add(MainP);
	
		
		
		
		
		
	

		Join.setOpaque(true);
	    Join.setForeground(new Color(240, 228, 225));
		Join.setBackground(Color.PINK);
		Join.setFont(new Font("고딕체",Font.ITALIC,30));
		Join.setBorderPainted(false);//버튼 테두리설
		Join.setContentAreaFilled(true);//버튼 영역 배경표시 설
		Join.setFocusPainted(false);
		MainP.add(Join);
		
		
		
        Quit.setOpaque(true);
        Quit.setForeground(new Color(255, 228, 225));
		Quit.setBackground(Color.PINK);
		Quit.setFont(new Font("고딕체",Font.ITALIC,30));
		Quit.setBorderPainted(false);//버튼 테두리설
		Quit.setContentAreaFilled(true);//버튼 영역 배경표시 설
		MainP.add(Quit);
		
		
        Start.setOpaque(true);
        Start.setForeground(new Color(255, 228, 225));
		Start.setBackground(Color.PINK);
		Start.setFont(new Font("고딕체",Font.ITALIC,30));
		Start.setBorderPainted(false);//버튼 테두리설
		Start.setContentAreaFilled(true);//버튼 영역 배경표시 설
		MainP.add(Start);
	
        Hist.setOpaque(true);
		Hist.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 30));
 	    Hist.setBorderPainted(false);//버튼 테두리설
	    Hist.setContentAreaFilled(true);//버튼 영역 배경표시 
	    Hist.setFocusable(false);
	    Hist.setForeground(new Color(255, 228, 225));
		Hist.setBackground(Color.PINK);
		MainP.add(Hist);
	
	
		Main.setVisible(true);
		
		
		
		 Start.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	 Object obj = e.getSource();
	                 if (obj.equals(Start)) {

	            }
	        
	            }
	      });
		 Start.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseEntered(MouseEvent arg0) {
	        Start.setForeground(new Color(255, 228, 225));
	            Start.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 40));
	         }

	         @Override
	         public void mouseExited(MouseEvent e) {
	            Start.setForeground(new Color(255, 228, 225));
	            Start.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 30));
	         }
	      });

		 
		 
		 
		 
		 

		Join.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	 Object obj = e.getSource();
	                 if (obj.equals(Start)) 
	                 {
	                 }
	            }
	      });
	Join.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseEntered(MouseEvent arg0) {
	      Join.setForeground(new Color(255, 228, 225));
	          Join.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 40));
	         }

	         @Override
	         public void mouseExited(MouseEvent e) {
	            Join.setForeground(new Color(255, 228, 225));
	             Join.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC,   - 30));
	         }
	      });

	
	
	
	

	Quit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	 Object obj = e.getSource();
                 if (obj.equals(Start)) 
                 {
                 }
            }
      });
Quit.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent arg0) {
      Quit.setForeground(new Color(255, 228, 225));
          Quit.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 40));
         }

         @Override
         public void mouseExited(MouseEvent e) {
            Quit.setForeground(new Color(255, 228, 225));
             Quit.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 30));
         }
      });






Hist.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
        	 Object obj = e.getSource();
             if (obj.equals(Start)) 
             {
             }
        }
  });
Hist.addMouseListener(new MouseAdapter() {
     @Override
     public void mouseEntered(MouseEvent arg0) {
  Hist.setForeground(new Color(255, 228, 225));
     Hist.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 40));
     }

     @Override
     public void mouseExited(MouseEvent e) {
        Hist.setForeground(new Color(255, 228, 225));
       Hist.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 30));
     }
  });
	
	}
}
