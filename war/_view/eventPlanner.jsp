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
				
				
				<table class="event-input" id="event-input">
					<thead>
						<tr>
							<th>
								<label>Name</label>
							</th>
							
							<th>
								<label>Location</label>
							</th>
							
							<th>
								<label>Description</label>
							</th>
							
							<th>
								<label>Start Date and Time</label>
							</th>
							
							<th>
								<label>End Date and Time</label>
							</th>
							
						</tr>
					</thead>
					
					<tbody>
						<tr>
							<td>
								<input type="text" name="name" id="name" required>
							</td>
							
							<td>
								<input type="text" name="desc" id="desc" required>
							</td>
							
							<td>
								<input type="text" name="loc" id="loc" required>
							</td>
							
							<td>
								<input type="datetime-local" name="sdate" id="sdate" required>
							</td>
							
							<td>
								<input type="datetime-local" name="edate" id="edate" required>
							</td>
							
						</tr>
					</tbody>
				</table>
				
				<input type="submit" value="Submit" />
				<input id="add-event" type="button" value="Add Event" onclick="eventAdder();"/>
			
			</section>
		</form>
		
	<script type="text/javascript">
	
		var table = document.getElementById("event-input"),
		tbody = table.getElementsByTagName("tbody")[0],
		clone = tbody.rows[0].cloneNode(true);
		
		function eventAdder() {
		    var new_row = updateRow(clone.cloneNode(true), ++tbody.rows.length, true);
		    tbody.appendChild(new_row);
		    return;
		}
		
		function updateRow(row, i, reset) {
	
		    var inp1 = row.cells[0].getElementsByTagName('input')[0];
		    var inp2 = row.cells[1].getElementsByTagName('input')[0];
		    var inp3 = row.cells[2].getElementsByTagName('input')[0];
		    var inp4 = row.cells[3].getElementsByTagName('input')[0];
		    var inp5 = row.cells[4].getElementsByTagName('input')[0];
		    inp1.id = row.cells[0].id + i;
		    inp2.id = row.cells[1].id + i;
		    inp3.id = row.cells[2].id + i;
		    inp4.id = row.cells[3].id + i;
		    inp5.id = row.cells[4].id + i;
	
		    if (reset) {
		        inp1.value = inp2.value = inp3.value = inp4.value = inp5.value = '';
		    }
		    return row;
		}
	
		
		</script>
	</body>
</html>