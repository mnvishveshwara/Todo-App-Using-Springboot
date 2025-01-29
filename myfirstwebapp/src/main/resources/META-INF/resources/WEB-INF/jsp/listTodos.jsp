<%@include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp"  %>
	
	
	<div class="container">
	
		<div>Welcome ${name}</div>
			
			<hr>
			<h3>Your Todos are </h3>
			
			<table class="table">
				<thead>
					<tr>
						
						<th>description</th>
						<th> Target date</th>
						<th> Is done? </th>
						<th></th>
						<th></th>
						
					</tr>
				
				</thead>
				<tbody>
					
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td> ${todo.description}</td>
							<td> ${todo.targetDate}</td>
							<td> ${todo.done}</td>
							<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete </a></td>
							<td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
						
						</tr>
					
					</c:forEach>
				
				</tbody>
			
			</table>
			<a href="add-todo" class= "btn btn-success">Add Todo</a>
			</div>
			
			<%@ include file="common/fotter.jsp" %>
