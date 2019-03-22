package app;

import java.io.*;  
import java.net.*; 
  
public class Server  
{ 
	 private final String IP = "230.0.0.0";
	 private final int port = 4321;
	 
	 private static Server instance;
	    
	public void sendMessage(String message) throws IOException {
      DatagramSocket socket = new DatagramSocket();
      InetAddress group = InetAddress.getByName(IP);
      byte[] msg = message.getBytes();
      DatagramPacket packet = new DatagramPacket(msg, msg.length,
         group, port);
      socket.send(packet);
      socket.close();
	}
	
	private Server() {
		
	}

	public static Server getInstance() {
		if(instance == null) {
			instance = new Server();
		}
		return instance;
	}
  
} 
