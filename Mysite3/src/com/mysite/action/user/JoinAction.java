package com.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import com.bit2016.util.Action;
import com.bit2016.util.WebUtil;
import com.yeon.Dao.UserDao;
import com.yeon.Dao.UserVo;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SerialException, IOException {
		System.out.println("JoinAction");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		UserVo vo = new UserVo();
		vo.setName(name);
		vo.setEmail(email);
		vo.setPassword(password);
		vo.setGender(gender);
		
		UserDao dao = new UserDao();
		dao.insert(vo);
		
		try {
			WebUtil.redirect(request, response, "/Mysite3/user?action=JoinSuccess");
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
