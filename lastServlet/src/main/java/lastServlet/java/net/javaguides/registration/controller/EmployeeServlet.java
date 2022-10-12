package lastServlet.java.net.javaguides.registration.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lastServlet.java.net.javaguides.registration.model.Employee;

import java.util.*;

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

		// RequestDispatcher dispatcher =
		// request.getRequestDispatcher("C:\\Users\\wchen\\git\\lastServletRepo\\lastServlet\\src\\main\\webapp\\RegisterEmployee.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/RegisterEmployee.jsp");
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
		if (request.getParameter("login") != null) {
			String[][] data = null;
			try {
				data = ReadFile.readFunction("C:\\Users\\wchen\\eclipse\\jee-2022-06\\eclipse\\fileNameNew.txt");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			// this searches the file currently if there exists a password and email address. 
			// right now searchFile only takes in username OR password need to change that. 
			if (SearchFile.SearchTextFile(data, username, password) == true) {
				System.out.println("login was successful");
				System.out.println("The search was conducted successfully");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/EmployeeLoginSuccessful.jsp");
				dispatcher.forward(request, response);
			} else {
				System.out.println("login was unsuccessful");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/EmployeeLoginUnsuccessful.jsp");
				dispatcher.forward(request, response);
			}
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

//		exportFile.exportFunction("C:\\Users\\wchen\\eclipse\\jee-2022-06\\eclipse\\fileNameNew.txt", sizeOfFile);

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
