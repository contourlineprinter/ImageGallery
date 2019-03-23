package app;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Client extends Thread{
	
	 private final String IP = "192.168.0.2";
	 private final int port = 8080;
	 
	 private List<String> lstMessages;
	 
	 public Client() {
		 lstMessages = new ArrayList<>();	
		 Thread t = new Thread(this);
		 t.start();
	 }
	 
	 public List<String> getMessages(){
		 return lstMessages;
	 }
	 
	
	 public static void main(String[] args) {
		 new Client();
	   }

	   public void receiveMessage() throws
	         IOException {
	      byte[] buffer=new byte[1024];
	      MulticastSocket socket=new MulticastSocket(port);
	      InetAddress group=InetAddress.getByName(IP);
	      

	      socket.joinGroup(group);
	     
	      while(true){
	         System.out.println("Waiting for server's message...");
	         DatagramPacket packet=new DatagramPacket(buffer,
	            buffer.length);
	         socket.receive(packet);
	         String msg=new String(packet.getData(),
	         packet.getOffset(),packet.getLength());
	         lstMessages.add(msg);
	         System.out.println("Message received: "+msg);
	         if("EXIT".equals(msg)) {
	            System.out.println(" Exiting ");
	            break;
	         }
	      }
	      socket.leaveGroup(group);
	      socket.close();
	   }

	   @Override
	   public void run(){
	   try {
		   receiveMessage();
	   }catch(IOException ex){
	      ex.printStackTrace();
	   }
	   }
}

