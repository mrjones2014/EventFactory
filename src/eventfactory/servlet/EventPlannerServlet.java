package eventfactory.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eventfactory.model.Event;
import eventfactory.model.Occasion;

public class EventPlannerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("/_view/eventPlanner.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String eName;
		String location;
		String startDate;
		String endDate;
		String description;

		Occasion occasion = (Occasion) req.getSession().getAttribute("occasion");
		
		for(int i = 0; i < Integer.parseInt(req.getParameterValues("rows")[1]); i++)
		{
			eName = req.getParameterValues("name")[i];
			location = req.getParameterValues("loc")[i];
			startDate = req.getParameterValues("sdate")[i];
			endDate = req.getParameterValues("edate")[i];
			description = req.getParameterValues("desc")[i];
			try {
				Event event = new Event(eName, location, description, startDate, endDate);
				occasion.getEvents().add(event);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}
