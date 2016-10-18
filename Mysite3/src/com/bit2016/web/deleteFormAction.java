package com.bit2016.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import com.bit2016.util.Action;
import com.bit2016.util.WebUtil;

public class deleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException {
		try {
			WebUtil.forward(request, response, "/WEB-INF/Views/deleteform.jsp");
		} catch (ServletException e) {
			e.printStackTrace();
		}
			
	}

}
