package test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.Socket;


public class testimda extends JPanel {
   
	JFrame origin = new JFrame("Login");
	BufferedReader in;
    PrintWriter out;
    
	private String getServerAddress() {
        return JOptionPane.showInputDialog(
            origin,
            "Enter IP Address of the Server:",
            "Welcome to the Chatter",
            JOptionPane.QUESTION_MESSAGE);
    }
	
	
	
   private void login() throws IOException{
      
   JTextField idField;
   JPasswordField pwField;
   
   
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
    
    joinBtn = new JButton("Join");
    joinBtn.setBounds(370, 390,95 , 32);
    joinBtn.setOpaque(true);
	joinBtn.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 20));
	joinBtn.setBorderPainted(false);//버튼 테두리설
	joinBtn.setContentAreaFilled(false);//버튼 영역 배경표시 
	joinBtn.setFocusable(false);
	joinBtn.setForeground(new Color(255, 228, 225));
	joinBtn.setBackground(Color.PINK);
	joinBtn.addActionListener(new ActionListener(){
	       public void actionPerformed(ActionEvent e) {
	            
	            Join();
	    }});
	    all.add(joinBtn);
	joinBtn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent arg0) {
        	joinBtn.setForeground(new Color(255, 228, 225));
        joinBtn.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 30));
         }

         @Override
         public void mouseExited(MouseEvent e) {
        	joinBtn.setForeground(new Color(255, 228, 225));
        joinBtn.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 20));
         }
      });
    
    loginBtn = new JButton("Login");
    loginBtn.setBounds(270, 390,120 , 33);
    loginBtn.setOpaque(true);
    loginBtn.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 20));
    loginBtn.setBorderPainted(false);//버튼 테두리설
    loginBtn.setContentAreaFilled(false);//버튼 영역 배경표시 
    loginBtn.setFocusable(false);
    loginBtn.setForeground(new Color(255, 228, 225));
    loginBtn.setBackground(Color.PINK);
    loginBtn.addActionListener(new ActionListener() {
          
          @Override
          public void actionPerformed(ActionEvent tosev) {
        	  if (!idField.getText().equals("")
                      && !pwField.getText().equals(""))
                   out.println("CHECK " + idField.getText() + " "
                         + pwField.getText());
                else if (idField.getText().equals(""))
                   alert("id를 입력하세요!", origin);
                else if (pwField.getText().equals(""))
                   alert("pw를 입력하세요!", origin);
          	
          }
      
          }
    );
	 loginBtn.addMouseListener(new MouseAdapter() {
       @Override
       public void mouseEntered(MouseEvent arg0) {
      	 loginBtn.setForeground(new Color(255, 228, 225));
      	 loginBtn.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 30));
       }

       @Override
       public void mouseExited(MouseEvent e) {
      	 loginBtn.setForeground(new Color(255, 228, 225));
      	 loginBtn.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 20));
       }
    });
    all.add(loginBtn);

    
    
    
    
    
   origin.add(all);
   origin.setVisible(true);
   }
    
    public void Join(){
       JFrame Join = new JFrame("Join");
       Join.setResizable(false);
       Join.setBounds(450,200, 600, 400);
       
       JPanel mainP = new JPanel();
       mainP.setLayout(null);
       mainP.setBackground(new Color(255,255,255));
       
       JTextField idField;
       JPasswordField pwField;
       ImageIcon IDimage = new ImageIcon("id.png");
        ImageIcon PWimage = new ImageIcon("pw.png");       
       JLabel ID;
       JLabel PW;
       JButton JB;
       
       ID=new JLabel(IDimage);
       ID.setBounds(170, 100, 30, 32);
       mainP.add(ID);
       
       PW=new JLabel(PWimage);
       PW.setBounds(170, 150, 39, 25);
       mainP.add(PW);
       
       idField = new JTextField();
       idField.setBounds(215, 103 , 200 , 30);
       mainP.add(idField);
       
       pwField = new JPasswordField();
       pwField.setBounds(215, 153 , 200 , 30);
       mainP.add(pwField);
       
       JB = new JButton("JOIN");
       JB.setBounds(200, 220, 80, 50);
       JB.addActionListener(new ActionListener(){
    	   public void actionPerformed(ActionEvent arg0) {
               // 서버로 알려준다.
               out.println("Join " + idField.getText().trim()
                     + " "+ pwField.getText().trim());

               idField.setText("");
               pwField.setText("");
               Join.dispose();
            }
       });
       mainP.add(JB);
       
       Join.add(mainP);
       Join.setVisible(true);
    }
    
    private void run() throws IOException{
    	this.sock();
    	main_GUI next = new main_GUI();
    	
    	while (true) {
            String line = in.readLine();
            System.out.println(line);
            
            if(line.startsWith("login")){
            	login();
            }
            else if(line.startsWith("OK")){
            	next.run();
            	origin.dispose();
            }
    	}
    }
    
    private void sock() throws IOException {

        String serverAddress = getServerAddress();
        Socket socket = new Socket(serverAddress, 9001);
        in = new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }
    
    private int alert(String inform, JFrame parent) {
        return JOptionPane.showConfirmDialog(parent, inform, "warning",
              JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
     }
    
    public static void main(String[] args) throws Exception{
       testimda test= new testimda();
       test.run();
    }
    
}

   

