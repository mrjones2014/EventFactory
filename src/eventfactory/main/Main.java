package eventfactory.main;

import java.util.Scanner;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

import eventfactory.model.Event;
import eventfactory.model.Occasion;

public class Main {

	public static void main(String[] args) throws Exception{
		Server server = new Server(8081);

		// Create and register a webapp context
		WebAppContext handler = new WebAppContext();
		handler.setContextPath("/eventfactory");
		handler.setWar("./war"); // web app is in the war directory of the project
		server.setHandler(handler);
		
		// Use 20 threads to handle requests
		server.setThreadPool(new QueuedThreadPool(20));
		
		// Start the server
		server.start();
		
		// Wait for the user to type "quit"
		System.out.println("Web server started, type quit to shut down");
		Scanner keyboard = new Scanner(System.in);
		while (keyboard.hasNextLine()) {
			String line = keyboard.nextLine();
			if (line.trim().toLowerCase().equals("quit")) {
				break;
			}
		}
		keyboard.close();
		System.out.println("Shutting down...");
		server.stop();
		server.join();
		System.out.println("Server has shut down, exiting");
		/*
		Occasion occasion = new Occasion("test name", "test loc", "test desc", "102120162100", "102320161300");
		Event event = new Event("test name", "test loc", "test desc", "102120162100", "102320161300");
		occasion.getEvents().add(event);
		System.out.println("JSON = \n" + occasion.toJSON());*/
	}

}
