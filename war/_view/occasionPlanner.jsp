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
				<table border="0">
					<tr>
						<!--<td>Row 1, Column 1</td>
						<td>Row 1, Column 2</td>-->
						<td>Event Name</td>
						<td><input type="text" name="oname"></td>
					</tr>
					<tr>
						<!--<td>Row 2, Column 1</td>
						<td>Row 2, Column 2</td>-->
						<td>Event Location</td>
						<td><input type="text" name="oloc"></td>
					</tr>
					<tr>
						<td>Event Start Date</td>
						<td><input type="text" name="osdate"></td>
					</tr>
					<tr>
						<td>Event Start Time</td>
						<td><input type="text" name="ostime"></td>
					</tr>
					<tr>
						<td>Event End Date</td>
						<td><input type="text" name="oedate"></td>
					</tr>
					<tr>
						<td>Event End Date</td>
						<td><input type="text" name="oetime"></td>
					</tr>
					<tr>
						<td>Event Color</td>
						<td><input type="text" name="ocolor"></td>
					</tr>
				</table>
				
				<input type="submit" value="Submit"></input>
			</section>
		</form>
	</body>
</html>