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
				
				<form>
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
								<input type="text" name="oname">
							</td>
							
							<td>
								<input type="date" name="osdate">
							</td>
							
							<td>
								<input type="text" name="ostime">
							</td>
							
							<td>
								<input type="date" name="oedate">
							</td>
							
							<td>
								<input type="text" name="oetime">
							</td>
							
							<td>
								<input type="color" name="ocolor">
							</td>
							
							<td>
								<input type="color" name="ocolor">
							</td>
							
							<td>
								<input type="color" name="ocolor">
							</td>
						</tr>
					</tbody>
				</table>
				
				<input type="submit" value="Submit" />
				</form>				
			
			</section>
		</form>
	</body>
</html>