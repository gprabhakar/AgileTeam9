package TestBed;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestBedServlet
 */
@WebServlet("/TestBedServlet")
public class TestBedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestBedServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TestBed testBed = new TestBed();

		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(startdate);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date start,end;
		try {
			start = df.parse(startdate);
			end = df.parse(enddate);
			Calendar s = Calendar.getInstance();
			Calendar e = Calendar.getInstance();
			s.setTime(start);
			e.setTime(end);
			testBed.setStartDate(s);
			testBed.setEndDate(e);
			testBed.StartTest();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("Home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
