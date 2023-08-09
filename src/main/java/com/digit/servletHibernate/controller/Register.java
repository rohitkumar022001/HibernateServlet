package com.digit.servletHibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ha.backend.Sender;

import com.digit.servletHibernate.bean.AadharDetails;
import com.digit.servletHibernate.model.HibernateManager;

@WebServlet("/Register")
public class Register extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String dob=req.getParameter("dob");
		String address=req.getParameter("address");
		AadharDetails a=new AadharDetails();
		a.setId(id);
		a.setDob(dob);
		a.setName(name);
		a.setAddress(address);
		HibernateManager h=new HibernateManager();
		boolean b=h.saveObject(a);
		if(b==true) {
			resp.sendRedirect("/servletHibernate/registerSucc.html");
		}
		else {
			resp.sendRedirect("/servletHibernate/registerFail.html");
		}
		
		
	}

}
