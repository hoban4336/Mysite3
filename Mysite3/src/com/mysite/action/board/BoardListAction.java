package com.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import com.bit2016.util.Action;
import com.bit2016.util.WebUtil;
import com.yeon.Dao.GuestBookDao;
import com.yeon.Dao.GuestbookVo;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,  IOException {
		
		GuestBookDao dao = new GuestBookDao();
		List<GuestbookVo> list = dao.getlist();
		
		request.setAttribute("list", list);
		System.out.println("BoardListAction");
		try {
			WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
