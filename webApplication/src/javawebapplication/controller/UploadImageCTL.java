package javawebapplication.controller;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import javawebapplication.utilility.ServletUtility;

/**
 * Servlet implementation class UploadImage
 */
@WebServlet(name = "UploadImageCTL", urlPatterns = {"/UploadImageCTL"})
@MultipartConfig(maxFileSize = 1699999999)
public class UploadImageCTL extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServletUtility.forward(JWAView.uploadImageView, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part part = null;
		try {
			part =request.getPart("photo");
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ServletException e) {
			e.printStackTrace();
		}
	    String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		System.out.println("file name: "+fileName);
		String image = ServletUtility.UploadImage(request, response, fileName);	
		System.out.println("Image name: "+image);
		
		if(image != null) {
			ServletUtility.setSuccessMessage("Image Uploaded Successfully", request);
			ServletUtility.forward(JWAView.uploadImageView, request, response);
		}
	}

}
