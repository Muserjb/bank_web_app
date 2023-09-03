package javawebapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javawebapplication.bean.UserBean;
import javawebapplication.model.UserModel;
import javawebapplication.utilility.DataUtility;
import javawebapplication.utilility.ServletUtility;

/**
 * Servlet implementation class UserCTL
 */
@WebServlet(name = "/UserCTL", urlPatterns = "/UserCTL")
public class UserCTL extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserModel model = new UserModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if(id > 0) {
			UserBean bean = null;
			bean = model.findByPK(id);
			request.setAttribute("bean", bean);
		}
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher(JWAView.userView);
		//dispatcher.forward(request, response);
		ServletUtility.forward(JWAView.userView, request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    UserBean user = new UserBean();
	    user.setFirstName(request.getParameter("firstName"));
	    user.setLastName(request.getParameter("lastName"));
	    user.setLoginId(request.getParameter("login"));
	    user.setPassword(request.getParameter("password"));
	    user.setDob(DataUtility.getDate(request.getParameter("dob")));
	    user.setMobileNumber(request.getParameter("mobile"));
	    
	    
	    user.setId(DataUtility.getLong(request.getParameter("id")));
	    System.out.println("id for eidt :"+ user.getId());
	    if(user.getId() > 0) {
	    	
	    	
	    	  
	    	 
	    	
	    	long i = UserModel.UpdateUser(user);
	    	if(i > 0) {
	    		ServletUtility.setSuccessMessage("User Updated successfully", request);
	    	}else {
	    		ServletUtility.setErrorMessage("User didnt Updated", request);
	    	}
	    	
	    }else {
	    
		    long i = UserModel.addUser(user);
		    if(i > 0) {
		      ServletUtility.setSuccessMessage("User register sucessfully", request);
		    }else {
		      ServletUtility.setErrorMessage("User Not inserted", request);
		    }
  
	    }
	    ServletUtility.forward(JWAView.userView, request, response);
	  //  request.getRequestDispatcher(JWAView.userView).forward(request, response);
	    
	}
}
