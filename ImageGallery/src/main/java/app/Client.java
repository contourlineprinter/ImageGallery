package app;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Client extends Thread{
	
	 private final String IP = "230.0.0.0";
	 private final int port = 4321;
	
	 public static void main(String[] args) {
	      Thread t=new Thread(new Client());
	      t.start();
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

