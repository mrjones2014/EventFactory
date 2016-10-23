package eventfactory.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eventfactory.model.Occasion;

public class OccasionPlannerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("/_view/occasionPlanner.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name = req.getParameter("oname");
			String location = req.getParameter("oloc");
			String startDate = req.getParameter("osdate");
			String startTime = req.getParameter("ostime");
			String endDate = req.getParameter("oedate");
			String endTime  = req.getParameter("oetime");
			String description = req.getParameter("odescription");
			String eventCount = req.getParameter("oevents");
			
			try {
				Occasion occasion = new Occasion(name, location, description, startDate+startTime, endDate+endTime);
				req.getSession().setAttribute("occasion", occasion);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resp.sendRedirect("EventPlanner");
	}
}
