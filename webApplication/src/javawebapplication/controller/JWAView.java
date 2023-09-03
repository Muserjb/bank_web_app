package javawebapplication.controller;

public interface JWAView {

	
	public String APP_CONTEXT = "/webApplication";
	public String PAGE_FOLDER = "/jsp";
	
	public String homeView = APP_CONTEXT+PAGE_FOLDER+"/"+"home.jsp";
	
	
	public String LoginView = PAGE_FOLDER+"/"+"LoginView.jsp";
	public String LoginServlet = APP_CONTEXT+"/"+"LoginServlet";
	

	public String userView = PAGE_FOLDER+"/"+"userView.jsp";
	public String UserCTL = APP_CONTEXT+"/"+"UserCTL";
	
	public String welcomeView = PAGE_FOLDER+"/"+"welcome.jsp";
	public String WelcomeCTL = APP_CONTEXT+"/"+"WelcomeCTL";
	
	public String userViewList = PAGE_FOLDER+"/"+"userViewList.jsp";
	public String UserListCTL = APP_CONTEXT+"/"+"UserListCTL";
	
	
	
	

	public String uploadImageView = PAGE_FOLDER+"/"+"uploadImageView.jsp";
	public String UploadImageCTL = APP_CONTEXT+"/"+"UploadImageCTL";
	





}
