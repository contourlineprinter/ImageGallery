package app;

import java.util.ArrayList;
import java.util.List;

public class ClientHandler {
	
	private static ClientHandler instance;
	
	private List<Client> lstClients;
	
	private ClientHandler() {
		lstClients = new ArrayList<>();
	}
	
	public static ClientHandler getInstance() {
		if(instance == null) {
			instance = new ClientHandler();
		}
		return instance;
	}
	
	public void addClient(Client client) {
		lstClients.add(client);
	}
	
	public List<Client> getClients(){
		return lstClients;
	}

}
