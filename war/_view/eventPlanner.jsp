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
							
						</tr>
					</thead>
					
					<tbody>
						<tr>
							<td>
								<input type="text" name="name" id="name" required>
							</td>
							
 							<td>
								<textarea cols="20" rows="2" name="desc" id="desc" ></textarea>
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
				
				<input type="submit" value="Submit" onclick="return gatherData();"/>
				<input id="add-event" type="button" value="Add Event" onclick="eventAdder();"/>
				<p id="num-row" name="num-row" hidden="true">1</p>
				
			</section>
		</form>
		
	<script type="text/javascript">
	
		var table = document.getElementById("event-input"),
		tbody = table.getElementsByTagName("tbody")[0],
		clone = tbody.rows[0].cloneNode(true);
		
		var rowCounter = parseInt(document.getElementById("num-row").innerHTML);
		
		function eventAdder() {
		    var new_row = updateRow(clone.cloneNode(true), ++tbody.rows.length, true);
		    tbody.appendChild(new_row);
		    
		    rowCounter = rowCounter + 1;
		    document.getElementById("num-row").innerHTML = rowCounter;
		    return;
		}
		
		function updateRow(row, len, reset) {
				var inputField = [];
			
				for (var i =0; i< row.cells.length; i++) {
					inputField[i] = row.cells[i];
					
					/* inputField[i].id = rowCounter; */
					
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
	    rowCounter = rowCounter - 1;
	    document.getElementById("num-row").innerHTML = rowCounter;
	    return;
		}
		
		function gatherData() {
			
			var name = document.getElementsByName("name");
			var desc = document.getElementsByName("desc");
			var loc = document.getElementsByName("loc");
			var sdate = document.getElementsByName("sdate");
			var edate = document.getElementsByName("edate");
			
	    return [name, desc, loc, sdate, edate];
		}
		
		</script>
	</body>
</html>