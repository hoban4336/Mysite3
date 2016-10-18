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

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SerialException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDao dao = new UserDao();
		UserVo vo = dao.get(email, password);
		if (vo == null) {
			WebUtil.redirect(request, response, "/Mysite3/user?action=loginForm&result=fail");
			return;
		}

		System.out.println(" 로그인 성공 -->인증처리 ");
//		true: session Manager가 jsessionid와 연결된 session 객체가 없으면, 새로 만들어서 준다. 
//		false | (); :  jsessionid와 연결된 session 객체가 없으면, null값을 준다.
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", vo);
		
		WebUtil.redirect(request, response, "/Mysite3/mysite");
	}

}
