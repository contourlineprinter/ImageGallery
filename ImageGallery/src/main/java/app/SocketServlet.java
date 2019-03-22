package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SocketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SocketServlet() {
        super();
    }    
    @Override
    public void init() throws ServletException {
   
    }    
    private void startServer() {
    	try {
    		String command = getServletContext().getRealPath(File.separator + "python") + File.separator + "server.py";
			Process p = Runtime.getRuntime().exec("python " + command);
			BufferedReader stdInput = new BufferedReader(new 
	                 InputStreamReader(p.getInputStream()));
	            BufferedReader stdError = new BufferedReader(new 
	                 InputStreamReader(p.getErrorStream()));
	            // read the output from the command
	            System.out.println("Here is the standard output of the command:\n");
	            String s = null;
	            while ((s = stdInput.readLine()) != null) {
	                System.out.println(s);
	            }
	            
	            Server.getInstance().sendMessage("File created");	            
	            while ((s = stdError.readLine()) != null) {
	                System.out.println(s);
	            }
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		startServer();
		request.setAttribute("message", "Socket started successfully");
		getServletContext().getRequestDispatcher("/socket.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
