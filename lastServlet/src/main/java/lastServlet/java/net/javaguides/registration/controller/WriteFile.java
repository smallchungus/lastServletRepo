package lastServlet.java.net.javaguides.registration.controller;

import java.io.FileWriter;

public class WriteFile {
	public static void writeFunction (String firstName, String lastName, String email, String userName, String password) 
	{
	try {
		
		
		FileWriter myWriter = new FileWriter("fileNameNew.txt", true);
//		Employee employee = new Employee();
		
//		String firstName = employee.getFirstName();
//		String lastName = employee.getLastName();
//		String email = employee.getEmailAddress();
//		String userName = employee.getUserName();
//		String password = employee.getPassWord();
//		
//		System.out.println(firstName);
//		System.out.println("this is last name " + lastName);
//		System.out.println( "this is email " + email);
//		System.out.println("this is userName" + userName);
//		System.out.println("password this is " + password);
//		
		
		myWriter.write(firstName + " ");
		myWriter.write(lastName + " ");
		myWriter.write(email + " ");
		myWriter.write(userName + " ");
		myWriter.write(password+ "\n");
		myWriter.close();
	}
	catch ( Exception E )
	{
		System.out.println("There is something wrong with the write in file ");
	}
}
}
