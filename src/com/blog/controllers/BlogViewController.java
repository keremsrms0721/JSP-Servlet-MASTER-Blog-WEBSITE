package com.blog.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.BlogDAO;
import com.blog.dao.BlogDAOImpl;
import com.blog.models.Blog;
import com.blog.pagination.Pagination;

@WebServlet("/homepage")
public class BlogViewController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String getId = req.getParameter("id");
		BlogDAO imp = new BlogDAOImpl();
		if (getId == null || getId.length() == 0) {
			Pagination p = new Pagination();
			p.yap(req, resp);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} else {
			long id = Long.parseLong(getId);
			Blog blog = imp.getBlog(id);
			req.setAttribute("blog",blog);
			req.getRequestDispatcher("blog-post.jsp").forward(req, resp);
		}
	}

}
