package test;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class Server {
	
	private static ArrayList<User> Userinfo = new ArrayList<>();
	private static final int PORT = 9001;
	private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
	private static HashMap<String, PrintWriter> clients = new HashMap<String, PrintWriter>();
	
	public  Server(){
		
		
		  String fileName = "information.txt";
	      Scanner inputStream = null;

	      // 파일 인풋 스트림 만들기
	      try {
	         inputStream = new Scanner(new File(fileName));
	      } catch (FileNotFoundException e) {
	         System.out.println("Error opening the file " + fileName);
	         System.exit(0);
	      }

	      // 읽어오기
	      while (inputStream.hasNextLine()) {
	         String line = inputStream.nextLine();
	         String[] temp = line.split(" ");
	         Userinfo.add(new User(temp[0],temp[1])); 
	                                                         
	         System.out.println(line + " is read successfully");
	      }
	
	}
	
	public static void main(String[] args) throws Exception{
		new Server();
		 System.out.println("\n- The game server is running.");
	      ServerSocket listener = new ServerSocket(PORT);
	      
	      
	      try {
	          while (true) {
	             new Handler(listener.accept()).start();
	          }
	       } finally {
	          listener.close();
	       }
	}
	
	
	
	 private static class Handler extends Thread {
	      private String id;
	      private String pw;
	      private Socket socket;
	      private BufferedReader in;
	      private PrintWriter out;

	      public Handler(Socket socket) {
	         this.socket = socket;
	      }

	      public void run() {
	         try {

	            in = new BufferedReader(new InputStreamReader(
	                  socket.getInputStream()));
	            out = new PrintWriter(socket.getOutputStream(), true);

	            
	            out.println("login");

	            while (true) {
	               String input = in.readLine();

	               if (input == null)
	                  return;
	               else if(input.startsWith("Join")){
	            	   String t[] = input.split(" ");

	                
	                   User tmpInfo = new User(t[1], t[2]);

	                   Userinfo.add(tmpInfo);

	                   String fileName = "information.txt";

	                   PrintWriter outputStream = null;
	                   FileWriter file = null;
	                   try {
	                      file = new FileWriter("information.txt", true);
	                      outputStream = new PrintWriter(file, true);
	                   } catch (FileNotFoundException e1) {
	                      System.out.println("Error opening the file"
	                            + fileName);
	                   } catch (IOException e1) {
	                      e1.printStackTrace();
	                   }

	                   System.out.println(input);
	                   
	                   outputStream.println(tmpInfo.getid().trim()+" "+tmpInfo.getpw().trim());

	                   outputStream.close();

	                   out.println("Join_OK");
	               }
	               else if(input.startsWith("CHECK")){
	            	   String t[] = input.split(" ");
	            	   id=t[1];
	            	   pw=t[2];
	            	   
	            	   boolean loginOK = false;
	                   int userIndex = -1;
	                   
	                   for (int i = 0; i < Userinfo.size(); i++) {
	                       if (Userinfo.get(i).getid().equals(id)
	                             && Userinfo.get(i).getpw().equals(pw)) {
	                          loginOK = true;
	                          userIndex = i; //
	                          break;
	                       }
	                    }
	                   if (loginOK) {
	                       synchronized (clients) {
	                          
	                          if (!clients.containsKey(id)) {
	                             clients.put(id, out);

	                             User tmp = Userinfo.get(userIndex);
	                             
	                             out.println("OK");
	                             
	                             break;
	                          } else {
	                             out.println("AlREADY_LOGON");
	                          }
	                       }
	                    } else {
	                       out.println("FAIL");
	                    }
	               }
	            }
	         }
	         catch (IOException e) {
	             System.out.println(e);
	          } 
	         
	         
	      }
	 }
}

  
    /*private static final int PORT = 9001;

    
    private static HashSet<String> names = new HashSet<String>();
    private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
    public static void main(String[] args) throws Exception {
        System.out.println("채팅방에 오신것을 환영합니다..");
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }

    
    private static class Handler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

       
        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
            	
                in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                
                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + ": " + input);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                if (out != null) {
                    writers.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}*/

