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
					<tr>
						<td>
							<label>Name</label>
						</td>
						
						<td>
							<label>Start Date</label>
						</td>
						
						<td>
							<label>Start Time</label>
						</td>
						
						<td>
							<label>End Date</label>
						</td>
						
						<td>
							<label>End Time</label>
						</td>
						
						<td>
							<label>Primary Color</label>
						</td>
						
						<td>
							<label>Secondary Color</label>
						</td>
						
						<td>
							<label>Accent Color</label>
						</td>
					</tr>
					
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
				</table>
				
				<input type="submit" value="Submit" />
				</form>				
			
			</section>
		</form>
	</body>
</html>