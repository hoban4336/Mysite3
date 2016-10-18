package com.bit2016.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import com.bit2016.util.Action;
import com.bit2016.util.WebUtil;
import com.yeon.Dao.GuestBookDao;
import com.yeon.Dao.GuestbookVo;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GuestBookDao dao = new GuestBookDao();
		List<GuestbookVo> list = dao.getlist();
		
		request.setAttribute("list", list);
		System.out.println("ListAction");
		try {
			WebUtil.forward(request, response, "/WEB-INF/views/index.jsp");
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
