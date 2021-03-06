<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="_view/stylesheets/stylesheet.css" media="screen" />
	</head>
	
	
	<body>
		<section class="page-header">
			<h1 class="project-name">Event Factory</h1>
		</section>
		
		<div class="occasion-info">
			<h3 class="welcome">Welcome Occasion Organizers!</h3>
			
			<p>
			Planning an occasion and want there to be an easy to use interface for your various events? Then
		  look no further! Holy cow, have we got the solution for you! Event Factory will create a configurable,
			unique Android application for you to distribute to your attending guests. How hard is creating an application 
			through Event Factory, you may ask? About as hard as typing out your itinerary! Our advanced infrastructure performs all
			the hard parts for you. Leaving you with more time to plan your occasions!
			</p>
		</div>
		
		<form action="${pageContext.servletContext.contextPath}/OccasionPlanner" method="post">
			<div class="main-content">
				
				
				<table class="user-input">
					<thead>
						<tr>
							<th>
								<label>Name</label>
							</th>
							
							<th>
								<label>Description</label>
							</th>
							
							<th>
								<label>Location</label>
							</th>
							
							<th>
								<label>Start Date and Time</label>
							</th>
							
							<th>
								<label>End Date and Time</label>
							</th>
							
							<th>
								<label>Primary Color</label>
							</th>
							
							<th>
								<label>Secondary Color</label>
							</th>
							
							<th>
								<label>Accent Color</label>
							</th>
						</tr>
					</thead>
					
					<tbody>
						<tr>
							<td>
								<input type="text" name="oname" required>
							</td>
							
							<td>
								<textarea cols="20" rows="2" name="odescription" id="odescription" ></textarea>
							</td>
							
							<td>
								<input type="text" name="oloc" required>
							</td>
							
							<td>
								<input type="datetime-local" name="osdate" max=2222-12-30T00:00:00.00 min=2016-10-10T00:00:00.00 required>
							</td>
							
							<td>
								<input type="datetime-local" name="oedate" max=2222-12-30T00:00:00.00 min=2016-10-10T00:00:00.00 required>
							</td>
							
							<td>
								<input type="color" name="ocolor1" required>
							</td>
							
							<td>
								<input type="color" name="ocolor2" required>
							</td>
							
							<td>
								<input type="color" name="ocolor3" required>
							</td>
						</tr>
					</tbody>
				</table>
				
				<div class="occasion-submit">
					<input type="submit" value="Submit" />				
				</div>
				
			</div>
		</form>
	</body>
</html>