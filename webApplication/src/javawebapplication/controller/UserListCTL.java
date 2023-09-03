package javawebapplication.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javawebapplication.model.UserModel;
import javawebapplication.utilility.DataUtility;
import javawebapplication.utilility.ServletUtility;

/**
 * Servlet implementation class UserViewListCTL
 */
@WebServlet(name = "UserListCTL", urlPatterns = {"/UserListCTL"})
public class UserListCTL extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    UserModel model=new UserModel();
	    
	  long id = DataUtility.getLong(request.getParameter("id"));
  	  long di  =  UserModel.delete(id);
  	  if(di > 0) {
  	    ServletUtility.setSuccessMessage("Data Deleted Successfully", request);
  	  }
	    
	    
	    List list	= null;
	    list		= model.list();
	   // System.out.println(list.size());
	    if(list == null && list.size() == 0){
	      ServletUtility.setErrorMessage("Record Not Found", request);
	    }
	    
	    ServletUtility.setList(list, request);
		ServletUtility.forward(JWAView.userViewList, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
