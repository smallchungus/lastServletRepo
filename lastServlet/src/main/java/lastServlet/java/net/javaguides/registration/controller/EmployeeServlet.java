package lastServlet.java.net.javaguides.registration.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lastServlet.java.net.javaguides.registration.model.Employee;


/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/EmployeeLogin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();

		// first we check if login is null
		// if not null then we proceed with the login function
		// which creates a 2d array of already given data
		// and returns true if there is a match
		// and false if there isn't a match and redirects to the correct
		// web page.
		if (request.getParameter("login") != null) {

			// create the 2d array of already given data.
			String[][] data = null;
			try {
				data = ReadFile.readFunction("C:\\Users\\wchen\\eclipse\\jee-2022-06\\eclipse\\fileNameNew.txt");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			
			//we create the cookies UserName and password
			//cookies delete after an hour 
			//and we have added cookies to the response. 
			Cookie cookUsername = new Cookie ("cUsername", request.getParameter("username"));
			Cookie cookPassword = new Cookie("cPassword", request.getParameter("password"));

			cookUsername.setMaxAge(60*60);
			cookPassword.setMaxAge(60*60);

			response.addCookie( cookUsername );
			response.addCookie( cookPassword );
			
			// this searches the file currently if there exists a password and email
			// address.
			// right now searchFile only takes in user name OR password need to change that.
			// if there is a match then login
			// if there is no match then redirect to register or login page.
			if (SearchFile.SearchTextFile(data, username, password) == true) {
				System.out.println("login was successful");
				System.out.println("The search was conducted successfully");
//				response.sendRedirect("RegisterEmployee");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/EmployeeLoginSuccessful.jsp");
				dispatcher.forward(request, response);
			} else {
				System.out.println("login was unsuccessful");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/EmployeeLoginUnsuccessful.jsp");
				dispatcher.forward(request, response);
			}

			// the login page has not been pressed the registered page has been pressed
			// so we register the user by taking in their data into a 2d array
			// and reference the Java beans object class
			// then we search whether there is already an email address that exists or UserName 
			// if there is then we redirect to login page 
			// else we continue registering. 
		} else {

			out.println("You have successfully registered");

			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String emailAddress = request.getParameter("emailAddress");
			String username = request.getParameter("userName");
			String password = request.getParameter("passWord");

			Employee employee = new Employee();
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setEmailAddress(emailAddress);
			employee.setUserName(username);
			employee.setPassWord(password);

			System.out.println("Employee Servlet and Employee Object is made is successfully called");

			String[][] data = null;
			try {
				data = ReadFile.readFunction("C:\\Users\\wchen\\eclipse\\jee-2022-06\\eclipse\\fileNameNew.txt");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// this searches the file currently if there is the same UserName and password.
			if (SearchFile.SearchTextFile(data, username, emailAddress) == true) {
				System.out.println("There already exists a user with the same username or email address");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/RegisterEmployeeUnsuccessful.jsp");
				dispatcher.forward(request, response);
			}
			// if the UserName or EmailAddress is not in the searched files then we can
			// continue
			else {

				WriteFile.writeFunction(firstName, lastName, emailAddress, username, password);
				try {
					ReadFile.readFunction("C:\\Users\\wchen\\eclipse\\jee-2022-06\\eclipse\\fileNameNew.txt");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String[][] updatedData = null;
				try {
					updatedData = ReadFile
							.readFunction("C:\\Users\\wchen\\eclipse\\jee-2022-06\\eclipse\\fileNameNew.txt");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					ExportFile.exportFunction(updatedData);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Employee has successfully registered");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/EmployeeSuccessfullyRegistered.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
