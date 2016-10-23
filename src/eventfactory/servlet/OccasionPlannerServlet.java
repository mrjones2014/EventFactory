package eventfactory.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

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
			int count = 0;
			while(true)
			{
				count++;
				if(startDate.charAt(count) == 'T')
				{
					break;
				}
			}
			try {
				startTime = startDate.substring(count - 2, count) + startDate.substring(count - 5, count - 3) + startDate.substring(0, count-6) + startDate.substring(count + 1, count + 3) + startDate.substring(count + 4, count + 6);
				endTime = endDate.substring(count - 2, count) + endDate.substring(count - 5, count - 3) + endDate.substring(0, count-6) + endDate.substring(count + 1, count + 3) + endDate.substring(count + 4, count + 6);
				Occasion occasion = new Occasion(name, location, description, startTime, endTime);
				req.getSession().setAttribute("occasion", occasion);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resp.sendRedirect("EventPlanner");
	}
}
