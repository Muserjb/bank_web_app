package javawebapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import jakarta.servlet.http.HttpSessionAttributeListener;
import javawebapplication.bean.UserBean;
import javawebapplication.model.UserModel;
import javawebapplication.utilility.DataUtility;
import javawebapplication.utilility.ServletUtility;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//RequestDispatcher dispatcher = request.getRequestDispatcher(JWAView.LoginView);
		//dispatcher.forward(request, response);
		//ServletUtility.setErrorMessage("this is demoo error massege", request);
		
		HttpSession session = request.getSession(false);
	    String op = request.getParameter("operation");
	   try {
		   if(op.equals("logout")) {
		    	session.invalidate();
			    ServletUtility.setSuccessMessage("LogoutSucessfully",request);
			 }
	   }catch(Exception e) {
		   System.out.println(e);
	   }
		    ServletUtility.forward(JWAView.LoginView, request, response);
				
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       UserBean user 		= new UserBean();
	       String login	 		= request.getParameter("login");
	       String password	 	= request.getParameter("password");
	       HttpSession session 	= request.getSession(true);
	       
	    
	       user = UserModel.UserLogin(login, password);
	       if(user != null) {
	    	   session.setAttribute("user", user.getFirstName());
	           ServletUtility.setSuccessMessage(request.getParameter("login")+ " is login successfully", request);
	           ServletUtility.redirect(JWAView.WelcomeCTL, request, response);
	       }else {
	           ServletUtility.setErrorMessage("Invalid User", request);
	           ServletUtility.forward(JWAView.LoginView, request, response);
	       }
	  
	}

}
