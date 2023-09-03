package javawebapplication.utilility;

import java.util.Date;


public class DataValidator {

	//validate the name or any other text field for a simple
	public static boolean isName(String val) {

		  String name = "^[A-Za-z ]*$";
		  if (val.matches(name)) {
		    return true;
		  } else {
		    return false;
		  }
		}
	//validate number
	public static boolean isPhoneNo(String val) {
		  String regex = "^[7-9][0-9]{9}$";
		  if (val.matches(regex)) {
		    return true;
		  } else {
		    return false;
		  }
		}
	
	//validate password Demo@123
	public static boolean isPassword(String val) {
		  String passregex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\S])[A-Za-z0-9\\S]{6,12}$";

		  if (val.matches(passregex)) {
		    return true;
		  } else {
		    return false;
		  }
		}
	
		  /**
		   * Checks if value is Null
		   */
		  public static boolean isNull(String val) {
		    if (val == null || val.trim().length() == 0) {
		      return true;
		    } else {
		      return false;
		    }
		  }
		  /**
		   * Checks if value is NOT Null
		   * 
		   * @param val
		   * @return
		   */
		  public static boolean isNotNull(String val) {
		    return !isNull(val);
		  }
		  /**
		   * Checks if value is an Integer
		   * 
		   * @param val
		   * @return
		   */
		  public static boolean isInteger(String val) {
		    if (isNotNull(val)) {
		      try {
		        int i = Integer.parseInt(val);
		        return true;
		      } catch (NumberFormatException e) {
		        return false;
		      }
		    } else {
		      return false;
		    }
		  }
		  
		  /**
		   * Checks if value is Long
		   * @param val
		   * @return
		   */
		  public static boolean isLong(String val) {
		    if (isNotNull(val)) {
			      try {
			        long i = Long.parseLong(val);
			        return true;
			      } catch (NumberFormatException e) {
			        return false;
			      }
		    } else {
		      return false;
		    }
		  }
		  /*public static boolean isIntegerName(String val) {
		    String match = "^[0-9]{3}$";
		    if (val.matches(match)) {
		      return true;
		    } else {
		      return false;
		    }
		  }*/
		  /**
		   * Checks if value is valid Email ID
		   * 
		   * @param val
		   * @return
		   */
		  public static boolean isEmail(String val) {
		    String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		    if (isNotNull(val)) {
		      try {
		        return val.matches(emailreg);
		      } catch (NumberFormatException e) {
		        return false;
		      }
		    } else {
		      return false;
		    }
		  }
		  
		  /**
		   * Checks if value is Date
		   * @param val
		   * @return
		   * @throws ParseException
		   */
		  public static boolean isDate(String val) {
		    Date d = null;
		    if (isNotNull(val)) {
		      d = DataUtility.getDate(val);
		    }
		    return d != null;
		  }
		
		 
	/*// test methods
	public static void main(String args[]) {
		String val = "mdfkf";
		System.out.print("Check: "+ isEmail(val));
	}
	*/
}
