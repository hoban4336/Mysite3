package com.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

import com.bit2016.util.Action;
import com.bit2016.util.WebUtil;
import com.yeon.Dao.UserDao;
import com.yeon.Dao.UserVo;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SerialException, IOException {
		UserVo uservo = new  UserVo();
		
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		uservo.setPassword(password);
		
		HttpSession session = request.getSession();
		session.setAttribute("authUser", uservo);
		
		uservo.setNo(Long.parseLong(no.trim()));
		uservo.setName(name);
		uservo.setEmail(email);
		uservo.setGender(gender);
		
		UserDao dao = new UserDao();
		dao.update(uservo);
		
		WebUtil.redirect(request, response, "/Mysite3/mysite");
		
	}

}
