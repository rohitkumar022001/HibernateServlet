package com.digit.servletHibernate.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.servletHibernate.model.HibernateManager;

@WebServlet("/update")
public class update extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		AadharDetails a=new AadharDetails();
		a.setId(id);
		
		a.setName(name);
		String s=a.getId();
		HibernateManager h=new HibernateManager();
		boolean b=h.update(s);
		if(b==true) {
			resp.sendRedirect("/servletHibernate/updateSucc.html");
		}
		else {
			resp.sendRedirect("/servletHibernate/updateFail.html");
		}
	}

}
