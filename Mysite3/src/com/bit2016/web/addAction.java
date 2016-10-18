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

public class addAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SerialException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		GuestbookVo vo = new GuestbookVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setContent(content);
		
		GuestBookDao dao = new GuestBookDao();
		dao.insert(vo);

		try {
			WebUtil.redirect(request, response, "/GuestBookMVC/gb");
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
