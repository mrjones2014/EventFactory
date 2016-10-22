package eventfactory.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eventfactory.model.Event;

public class EventPlannerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("/_view/eventPlanner.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name = req.getParameter("name");
			String location = req.getParameter("loc");
			String startDate = req.getParameter("sdate");
			String startTime = req.getParameter("stime");
			String endDate = req.getParameter("edate");
			String endTime  = req.getParameter("etime");
			
			try {
				Event event = new Event(name, location, startDate+startTime, endDate+endTime);
				req.getSession().setAttribute("event", event);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
