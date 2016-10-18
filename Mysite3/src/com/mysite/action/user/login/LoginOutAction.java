package com.mysite.action.user.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

import com.bit2016.util.Action;
import com.bit2016.util.WebUtil;
import com.yeon.Dao.UserVo;

public class LoginOutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,  IOException {	
		
		//	저장된 값이 있으면 줘..
		HttpSession session = request.getSession();
		if( session == null ){
			WebUtil.redirect(request, response, "/Mysite3/mysite");
		}
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if( authUser != null ){
			//logout 
			session.removeAttribute("authUser");
			//새로운 세션 값을 발급 받음.
			session.invalidate();
		}
		
		WebUtil.redirect(request, response, "/Mysite3/mysite");
	}

}
