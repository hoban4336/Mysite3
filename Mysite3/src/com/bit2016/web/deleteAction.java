package com.bit2016.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import com.bit2016.util.Action;
import com.bit2016.util.WebUtil;
import com.yeon.Dao.GuestBookDao;
import com.yeon.Dao.GuestbookVo;

public class deleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String num = request.getParameter("no");
		int no = Integer.parseInt(num);
		String password = request.getParameter("password");

		GuestbookVo gvo = new GuestbookVo();
		gvo.setNo(no);

		GuestBookDao dao = new GuestBookDao();
		dao.delete(gvo);
		try {
			WebUtil.redirect(request,response,"/GuestBookMVC/gb");
		} catch (ServletException e) {
			e.printStackTrace();
		}

	}

}
