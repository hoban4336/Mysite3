package com.mysite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import com.bit2016.util.Action;
import com.bit2016.util.ActionFactory;
import com.mysite.action.main.MainActionFactory;
import com.mysite.action.user.UserActionFactory;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String actionName = request.getParameter("action");

		ActionFactory af = new UserActionFactory();
		Action action = af.getAction(actionName);
		try {
			action.execute(request, response);
		} catch (SerialException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
