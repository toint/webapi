package asia.luckyit.api.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import asia.luckyit.api.flow.WebFlowAction;

/**
 * Servlet implementation class WebAPIServlet
 */
public class WebAPIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WebAPIServlet() {
        
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		final Map<String, String> config = new HashMap<String, String>();
		final String fnc = request.getParameter("fnc");
		final String clientIP = request.getParameter("client_ip");
		final String data = request.getParameter("data");
		config.put("fnc", fnc);
		config.put("client_ip", clientIP);
		config.put("data", data);
		
		JSONObject json = new JSONObject();
		WebFlowAction action = new WebFlowAction();
		json = action.process(config);
		
		response.getWriter().println(json.toString());
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public static void main(String[] args) {
		final Map<String, String> config = new HashMap<String, String>();
		config.put("fnc", "login");
		config.put("client_ip", "");
		config.put("data", "{userName:12345, password: toint@123}");
		
		JSONObject json = new JSONObject();
		WebFlowAction action = new WebFlowAction();
		json = action.process(config);
	}

}
