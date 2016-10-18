package com.mysite.action.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import com.bit2016.util.Action;
import com.bit2016.util.WebUtil;

public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,SerialException, IOException {
			WebUtil.forward(request, response, "/WEB-INF/views/main/index.jsp");
	}

}
