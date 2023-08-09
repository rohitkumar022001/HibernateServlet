package com.digit.servletHibernate.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.servletHibernate.model.HibernateManager;

@WebServlet("/delete")
public class delete extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		AadharDetails a=new AadharDetails();
		a.setId(id);
		String s=a.getId();
		HibernateManager h=new HibernateManager();
		boolean b=h.delete(s);
		if(b==true) {
			resp.sendRedirect("/servletHibernate/deleteSucc.html");
		}
		else {
			resp.sendRedirect("/servletHibernate/deleteFail.html");
		}
	}

}
