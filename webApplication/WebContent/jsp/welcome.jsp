
<%@page import="javawebapplication.utilility.ServletUtility"%>
<body>
<%@ include file="header.jsp"%>
<h3 style="color: green;"><%=ServletUtility.getSuccessMessage(request) %></h3>
<%="welcome: "+session.getAttribute("user") %>
<h1>Welcome User</h1>
<br><br><br><br><br>

<%@ include file="footer.jsp"%>
</body>
</html>