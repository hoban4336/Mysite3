package com.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import com.bit2016.util.Action;
import com.bit2016.util.WebUtil;
import com.yeon.Dao.GuestBookDao;
import com.yeon.Dao.GuestbookVo;

public class GuestBookDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String no = request.getParameter("no");
		String password = request.getParameter("password");

		GuestbookVo gvo = new GuestbookVo();
		gvo.setNo( Integer.parseInt(no));
		gvo.setPassword(password);
		
		GuestBookDao dao = new GuestBookDao();
		dao.delete(gvo);

		WebUtil.redirect(request,response,"/Mysite3/guestbook");


	}

}
