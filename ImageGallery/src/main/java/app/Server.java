package app;

import java.io.*;  
import java.net.*;
import java.util.Enumeration; 
  
public class Server  
{ 
	 private final String IP = "192.168.0.2";
	 private final int port = 8080;
	 
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
