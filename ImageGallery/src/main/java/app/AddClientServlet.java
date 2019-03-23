package app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddClientServlet() {
        super();
    }
    
    private void addClient() {
    	Client client = new Client();
    	ClientHandler.getInstance().addClient(client);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addClient();
		request.setAttribute("clients", ClientHandler.getInstance().getClients());
		getServletContext().getRequestDispatcher("/socket.jsp").include(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
