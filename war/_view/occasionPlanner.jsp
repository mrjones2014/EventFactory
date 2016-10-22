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
		<form action="${pageContext.servletContext.contextPath}/OccasionPlanner" method="post">
			<section class="main-content">
				
				
				<table class="ocassion-input">
					<thead>
						<tr>
							<th>
								<label>Name</label>
							</th>
							
							<th>
								<label>Start Date</label>
							</th>
							
							<th>
								<label>Start Time</label>
							</th>
							
							<th>
								<label>End Date</label>
							</th>
							
							<th>
								<label>End Time</label>
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
								<input type="date" name="osdate" required>
							</td>
							
							<td>
								<input type="time" name="ostime" step="60" required>
							</td>
							
							<td>
								<input type="date" name="oedate" required>
							</td>
							
							<td>
								<input type="time" name="oetime" step="60" required>
							</td>
							
							<td>
								<input type="color" name="ocolor" required>
							</td>
							
							<td>
								<input type="color" name="ocolor" required>
							</td>
							
							<td>
								<input type="color" name="ocolor" required>
							</td>
						</tr>
					</tbody>
				</table>
				
				<input type="submit" value="Submit" />				
			
			</section>
		</form>
	</body>
</html>