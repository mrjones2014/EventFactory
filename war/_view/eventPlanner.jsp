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
							
              <td>
                <input id="remove-event" type="button" value="Remove Event" onclick="eventRemove(this);"/>
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
		
		function updateRow(row, len, reset) {
				var inputField = [];
			
				for (var i =0; i< inputField.length; i++) {
					inputField[i] = row.cells[i].getElementsByTagName('input')[0];
					inputField[i].id = row.cells[i].id + len;
					
					if(reset) {
						inputField[i].value = '';
					}
				}
		    return row;
		}
	
		function eventRemove(el) {
	    var i = el.parentNode.parentNode.rowIndex;
	    table.deleteRow(i);
	    while (table.rows[i]) {
	        updateRow(table.rows[i], i, false);
	        i++;
	  	}
	    return;
		}
		
		</script>
	</body>
</html>