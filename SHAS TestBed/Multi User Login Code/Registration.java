

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	 
	  
	  String fname  = request.getParameter("fname");
	  String lname  = request.getParameter("lname");
	  String city  = request.getParameter("city");
	  String uname = request.getParameter("username");
	  String pswd  = request.getParameter("password");
	  
	  Getsets sets = new Getsets();
	  
	  sets.setFname(fname);
	  sets.setLname(lname);
	  sets.setUsername(uname);
	  sets.setPassword(pswd);
	  
	  DbManager.Insert(sets);
	 	  
	}

}
