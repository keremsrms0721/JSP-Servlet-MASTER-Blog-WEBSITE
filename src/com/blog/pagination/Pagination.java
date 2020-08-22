package com.blog.pagination;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.BlogDAO;
import com.blog.dao.BlogDAOImpl;
import com.blog.models.Blog;

public class Pagination extends HttpServlet{
		public void yap(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			BlogDAO blog = new BlogDAOImpl();
			String spageid = req.getParameter("page");
			if (spageid == null) {
				spageid = "1";
			}
			int pageid = Integer.parseInt(spageid);
			int total = 5;
			if (pageid == 1) {
			} else {
				pageid = pageid - 1;
				pageid = pageid * total + 1;
			}
			double countBlog = blog.countBlog();
			int totalPages = (int) Math.ceil(countBlog / total);
			req.setAttribute("totalPages", totalPages);
			req.setAttribute("pageid", pageid);
			List<Blog> blogList = blog.blogList(pageid, total);
			req.setAttribute("blogList", blogList);
		}
}
