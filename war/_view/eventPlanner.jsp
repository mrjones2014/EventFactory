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
			<h1 class="">Event Factory</h1>
		</section>
		<form action="${pageContext.servletContext.contextPath}/EventPlanner" method="post">
			<section class="main-content">
				
				
				<table class="ocassion-input">
					<thead>
						<tr>
							<th>
								<label>Name</label>
							</th>
							
							<th>
								<label>Location</label>
							</th>
							
							<th>
								<label>Start Date</label>
							</th>
							
							<th>
								<label>Start Time</label>
							</th>
							
							<th>
								<label>End Time</label>
							</th>
							
						</tr>
					</thead>
					
					<tbody>
						<tr>
							<td>
								<input type="text" name="ename" required>
							</td>
							
							<td>
								<input type="date" name="esdate" required>
							</td>
							
							<td>
								<input type="time" name="estime" required>
							</td>
							
							<td>
								<input type="date" name="eedate" required>
							</td>
							
							<td>
								<input type="time" name="eetime" required>
							</td>
							
						</tr>
					</tbody>
				</table>
				
				<input type="submit" value="Submit" />
				<button id="add-event">Add Event</button>
			
			</section>
		</form>
	</body>
</html>