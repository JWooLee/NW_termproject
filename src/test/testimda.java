package test;
import java.awt.*;
import javax.swing.*;


public class testimda extends JPanel {
	
	public static void main(String[] args){
		
	JTextField idField;
	JPasswordField pwField;
	
	JFrame origin = new JFrame("Login");
    origin.setBounds(450, 200, 752, 508);
    origin.setResizable(false);
    origin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    JButton loginBtn;
    JButton joinBtn;
    JLabel idLabel;
    JLabel pwLabel; 
    ImageIcon ID = new ImageIcon("id.png");
    ImageIcon PW = new ImageIcon("pw.png");
	ImageIcon icon = new ImageIcon("back.png");
	  
    
	JPanel all= new JPanel()
	{
        public void paintComponent(Graphics g) {
            g.drawImage(icon.getImage(), 0, 0, null);
        }
	};
	all.setLayout(null);
	
	idLabel = new JLabel(ID);
    idLabel.setBounds(280, 300, 30, 32);
    all.add(idLabel);
	
    pwLabel = new JLabel(PW);
    pwLabel.setBounds(280, 340, 39, 25);
    all.add(pwLabel);
    
    idField = new JTextField();
    idField.setBounds(350, 304, 100, 25);
    all.add(idField);

    pwField = new JPasswordField();
    pwField.setBounds(350, 342, 100, 25);
    all.add(pwField);
    
    loginBtn = new JButton(new ImageIcon("login.png"));
    loginBtn.setBounds(270, 390,94 , 33);
    loginBtn.setBorder(BorderFactory.createEmptyBorder());
    all.add(loginBtn);
    
    joinBtn = new JButton(new ImageIcon("join.png"));
    joinBtn.setBounds(370, 390,95 , 32);
    joinBtn.setBorder(BorderFactory.createEmptyBorder());
    all.add(joinBtn);
    
    
    
	origin.add(all);
	origin.setVisible(true);
	}

	
}

