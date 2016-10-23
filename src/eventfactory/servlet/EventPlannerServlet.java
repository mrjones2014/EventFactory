package eventfactory.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
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
		String startTime = new String();
		String endTime = new String();
		
		Occasion occasion = (Occasion) req.getSession().getAttribute("occasion");
		
		for(int i = 0; i < Integer.parseInt(req.getParameterValues("rows")[1]); i++)
		{
			eName = req.getParameterValues("name")[i];
			location = req.getParameterValues("loc")[i];
			startDate = req.getParameterValues("sdate")[i];
			endDate = req.getParameterValues("edate")[i];
			description = req.getParameterValues("desc")[i];

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
				Event event = new Event(eName, location, description, startTime, endTime);
				occasion.getEvents().add(event);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		String JSON = occasion.toJSON();
		File f = new File("apk_templates/$app_name/app/src/main/assets/JSON.json");
		//File f = new File("JSON.json");
		FileWriter file = new FileWriter(f);
		file.write(JSON);
		file.flush();
		file.close();
	}
}
