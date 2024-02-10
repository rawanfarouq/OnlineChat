import java.net.*; 
import java.io.*; 



public class TCPServer{ 
public static void main(String args[])throws Exception{ 
        String clientSentence="";
        String capitalizedSentence="";
       
ServerSocket welcomeSocket=new ServerSocket(6789); 
Socket connectionSocket=welcomeSocket.accept(); 
DataInputStream inFromClient=new DataInputStream(connectionSocket.getInputStream()); 
DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream()); 
BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
clientSentence=inFromClient.readUTF();
if(clientSentence.equals("CONNECT")){
          System.out.println("client says: "+clientSentence); 
          capitalizedSentence=br.readLine(); 
          outToClient.writeUTF(capitalizedSentence);
          outToClient.flush(); 
          while(!clientSentence.equals("STOP")){ 
                  clientSentence=inFromClient.readUTF(); 
                  System.out.println("client says: "+clientSentence); 
                  capitalizedSentence=br.readLine(); 
                  outToClient.writeUTF(capitalizedSentence);
                  outToClient.flush(); 
                  } 
                  inFromClient.close(); 
                  connectionSocket.close(); 
                  welcomeSocket.close(); 
                  }
  }

} 