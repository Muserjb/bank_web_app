
<%@page import="javawebapplication.utilility.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

 <script>
 $( function() {
      $( "#datepicker" ).datepicker({
          dateFormat : 'mm/dd/yy',
          changeMonth: true,
        changeYear: true
      });
    } );
  </script>
</head>
<body>
<%@ include file="header.jsp"%>
  <main class="login-form">
  <div class="cotainer">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-header">
            User Registration
          </div>
         
          <div class="card-body">
			<h3 class="text-success text-center"><%=ServletUtility.getSuccessMessage(request) %></h3>
            <h3 class="text-danger text-center"><%=ServletUtility.getErrorMessage(request) %></h3>
            <jsp:useBean id="bean" class="javawebapplication.bean.UserBean" scope="request"></jsp:useBean>
            <form action="<%=JWAView.UserCTL%>" method="post">

          <%--    <input type="hidden" name="uri" value=""> <input
                type="hidden" name="id" value=""> <input
                type="hidden" name="createdBy" value="">
              <input type="hidden" name="modifiedBy"
                value=""> <input type="hidden"
                name="createdDatetime"
                value="">
              <input type="hidden" name="modifiedDatetime"
                value="">
 --%>
 
			<input type="hidden" name="id" value="<%=bean.getId() %>">
 
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">First Name<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text"   class="form-control" placeholder="Enter First Name"
                    name="firstName" value="<%=bean.getFirstName() %>" >
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Last Name<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text"   class="form-control" placeholder="Enter Last Name"
                    name="lastName" value="<%=bean.getLastName() %>" >
                    <font  color="red"></font>
                </div>
              </div>

              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Login Id<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="email_address"  class="form-control" placeholder="Enter Login Id"
                    name="login" value="<%=bean.getLoginId() %>" >
                    <font  color="red"></font>
                </div>
              </div>
              
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Password<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="password" id="email_address"  class="form-control" placeholder="Enter password"
                    name="password" value="<%=bean.getPassword()%>" >
                    <font  color="red"></font>
                </div>
              </div>

              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Date Of Birth<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text"  id="datepicker" class="form-control" placeholder="Enter Date Of Birth"
                    name="dob" value="<%=bean.getDob() %>" >
                    <font  color="red"></font>
                </div>
              </div>
              
              
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Mobile No.<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="email_address"  class="form-control" placeholder="Enter Mobile No"
                    name="mobile" value="<%=bean.getMobileNumber() %>" >
                    <font  color="red"></font>
                </div>
              </div>

              
              <%if(bean.getId() > 0){ %>
                <div class="col-md-6 offset-md-4">
                <input type="submit" class="btn btn-primary" name="operation" value="Update">
              </div>
              <%}else{ %>
              <div class="col-md-6 offset-md-4">
                <input type="submit" class="btn btn-primary" name="operation" value="Register">
              </div>
              <%} %>
            </form>
          </div>

        </div>
      </div>
    </div>
  </div>
  </main>
  <div style="margin-top: 120px">
    <%@ include file="footer.jsp"%>
  </div>
</body>
</html>