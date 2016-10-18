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

public class GuestBookAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		GuestbookVo vo = new GuestbookVo();
		vo.setName(name);
		vo.setContent(content);
		vo.setPassword(password);
		
		GuestBookDao dao = new GuestBookDao();
		dao.insert(vo);

		WebUtil.redirect(request, response, "/Mysite3/guestbook");

	}

}
