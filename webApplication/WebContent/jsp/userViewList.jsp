<%@page import="javawebapplication.bean.UserBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="javawebapplication.utilility.ServletUtility"%>
<%@ include file="header.jsp"%>
	<%
	
	List list = ServletUtility.getList(request);
	Iterator it = list.iterator();

	%>
<div class="container card">
<h3 class="text-center">LIST OF USERS </h3>
	<table class="table table-striped table-hover">
	  <thead>
	 		<h3 class="text-success text-center"><%=ServletUtility.getSuccessMessage(request) %></h3> 
	  <%=ServletUtility.getErrorMessage(request) %>
	    <tr>
	      <th scope="col">Id</th>
	      <th scope="col">First Name</th>
	      <th scope="col">Last Name</th>
	      <th scope="col">Login</th>
	      <th scope="col">Password</th>
	      <th scope="col">Mobile Number</th>
	      <th scope="col">Date of Birth</th>
	      <th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	  <%
	  int index = 1;
	  while(it.hasNext()){
			UserBean user = (UserBean) it.next();
	  %>
	    <tr>
	      <th scope="row"><%=index++%></th>
	      <td><%=user.getFirstName() %></td>
	      <td><%=user.getLastName() %></td>
	      <td><%=user.getLoginId() %></td>
	      <td><%=user.getPassword() %></td>
	      <td><%=user.getMobileNumber() %></td>
	      <td><%=user.getDob()%></td>
	       <td>
	       <a href="UserCTL?id=<%=user.getId()%>">Edit</a>
	       <a href="UserListCTL?id=<%=user.getId()%>">Delete</a>
	       </td>
	       
	    </tr>
	    <%} %>
	  </tbody>
	</table>
</div>
<%@ include file="footer.jsp"%>