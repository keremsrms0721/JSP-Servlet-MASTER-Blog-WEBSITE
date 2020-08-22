package com.blog.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.dao.AdminDAO;
import com.blog.dao.AdminDAOImpl;

@WebServlet("/admincontroller")
public class AdminController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// if you want to create adminController  , you can use the context-param in web.xml instead req.getparameter
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		AdminDAO a = new AdminDAOImpl();
		int i = a.getAdmin(username, password);
		if(i==1) {
			HttpSession session = req.getSession(); // security.
			session.setAttribute("username", username);
			RequestDispatcher d = req.getRequestDispatcher("admin/admin.jsp");
			d.forward(req, resp);
		}else
		{
			RequestDispatcher d = req.getRequestDispatcher("adminLogin.jsp");
			d.forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session != null)
		{
			session.removeAttribute("username");
		}
		resp.sendRedirect("homepage");
	}
}
