package com.mysite.action.user.modify;

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

public class ModifyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,  IOException {
		//인증 여부
		HttpSession session = request.getSession();
		if(session == null ){
			WebUtil.redirect(request, response, "Mysite3/mysite");
			return; 
		}
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if( authUser == null ){
			WebUtil.redirect(request, response, "Mysite3/mysite");
			return;
		}
		
		//세션에 비밀번호는 넣지 않는것이 좋다.
		UserVo userVo = new UserDao().get( authUser.getNo() );
		request.setAttribute( "userVo" ,  userVo );
		
		WebUtil.forward(request, response, "/WEB-INF/views/user/modifyform.jsp");
	}

}
