package PTBS;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Facade implements Reminder{

	private int UserType;

	@SuppressWarnings("unused")
	private Product theSelectedProduct;
	
	@SuppressWarnings("unused")
	private int nProductCategory;

	@SuppressWarnings("unused")
	private ClassProductList theProductList;

	private String thePerson;

	public Map<String,Object> login() {
		boolean login_Status = false;
		Map<String, Object> authenticationMap = new HashMap<>();
		try {
			System.out.println("Enter Username:");
			@SuppressWarnings("resource")
			Scanner pm = new java.util.Scanner(System.in);
			String user1 = pm.nextLine();
			System.out.println("Enter Password:");
			String password1 = pm.nextLine();
		    boolean Login = loginVerification(".src/PTBS/SellerInfo.txt", user1, password1);
		    if(Login) {
		    	System.out.println("Logged in as a Seller");
		    	login_Status = Login;
		    	UserType = Login? 0:1;
		    	thePerson = user1;
		    }else{
		    	boolean BuyerLoginStatus = loginVerification(".src/PTBS/BuyerInfo.txt", user1, password1);
		    	if(BuyerLoginStatus) {
		    		System.out.println("logged in as Buyer ");
			    	login_Status = BuyerLoginStatus;
			    	UserType = BuyerLoginStatus? 1:0;
			    	thePerson = user1;
		    	}else {
					throw new Exception("Try again");
			    }
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			login();
		}
		authenticationMap.put("userType", UserType);
		authenticationMap.put("theperson", thePerson);
		authenticationMap.put("loginStatus", login_Status);
		return authenticationMap;
	}
	
	public boolean loginVerification(String inputFileType, String User1, String pw1) {
		boolean login_Status = false;
		try {
	    	boolean userFound = false;
	    	FileReader credentialFile = new FileReader(inputFileType);
	    	@SuppressWarnings("resource")
			BufferedReader readsellerInfo = new BufferedReader(credentialFile);
		    String sell = readsellerInfo.readLine();
		    while (sell != null) { 
		    String user2 = sell.substring(0,sell.indexOf(":"));
            if (User1.equalsIgnoreCase(user2))  {
            	userFound = true;
            	String password2 = sell.substring(sell.lastIndexOf(":") + 1);
            	boolean passwordCheck = pw1.equals(password2);
            	if(passwordCheck) {
            		System.out.println("Login success");
            		login_Status = true;
            	}else {
            		System.out.println("Invalid Username/Password");
            		login();
            	}
             }
             sell = readsellerInfo.readLine();
            }
		    if(!userFound) {
		    	return userFound;
		    }
	    }catch (FileNotFoundException e) {
			System.out.println("File Handling Exception Occured");
			login();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			login();
		}
		return login_Status;
	}
	
	public void selectProduct() {
		System.out.println("Select the Product");
		
	}
	public void addTrading() {
		System.out.println("Add Trading");
	}

	public void viewTrading() {
		System.out.println("View Trading");
	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {
		System.out.println("Reminder");
	}

	public void createUser(UserInfoItem userinfoitem) {

	}

	public void createProductLIst() {

	}

	public void AttachProductToUser() { 
	}

	public Product SelectProduct() {
		return null;
	}

	public void productOperation() {

	}

	@Override
	public int visit(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int visit(Trading trading) {
		// TODO Auto-generated method stub
		return 0;
	}

}
