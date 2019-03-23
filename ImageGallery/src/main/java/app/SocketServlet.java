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
    
    private String startServer() {
    	String msg = "";
    	try {
    		String command = getServletContext().getRealPath("/python/script.py");
    		System.out.println(command);
    		ProcessBuilder processBuilder = new ProcessBuilder("python", command);
    		Process p = processBuilder.start();
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

	            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
	            System.out.println("Here is the standard output of the command:\n");
	            String s = null;
	            while ((s = stdInput.readLine()) != null) {
	                System.out.println(s);
	                msg = s;
	            }	            
	            Server.getInstance().sendMessage(msg);
	            
	            while ((s = stdError.readLine()) != null) {
	                System.out.println(s);
	            }
		} catch (IOException e) {
			e.printStackTrace();
		}    	
    	return msg;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", startServer());
		getServletContext().getRequestDispatcher("/socket.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
