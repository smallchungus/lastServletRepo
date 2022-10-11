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
		out.println("You have successfully registered");

		

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailAddress = request.getParameter("emailAddress");
		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");
		
//		System.out.println("firstname " + firstName + " ");
//		System.out.println("last name " + lastName + " ");
//		System.out.println("email " + emailAddress + " ");
//		System.out.println("username " + username + " ");
//		System.out.println("password " + password + " ");

		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmailAddress(emailAddress);
		employee.setUserName(username);
		employee.setPassWord(password);
		
//		System.out.println("firstname " + employee.getFirstName() + " ");
//		System.out.println("last name " + employee.getLastName() + " ");
//		System.out.println("email " + employee.getEmailAddress() + " ");
//		System.out.println("username " + employee.getUserName() + " ");
//		System.out.println("password " + employee.getPassWord() + " ");
		System.out.println("Employee Servlet and Employee Object is made is successfully called");
		WriteFile.writeFunction(firstName, lastName, emailAddress, username, password);
		int sizeOfFile = ReadFile.readFunction("C:\\Users\\wchen\\eclipse\\jee-2022-06\\eclipse\\fileNameNew.txt");
//		exportFile.exportFunction("C:\\Users\\wchen\\eclipse\\jee-2022-06\\eclipse\\fileNameNew.txt", sizeOfFile);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/EmployeeSuccessfullyRegistered.jsp");
		dispatcher.forward(request, response);
	}

}
