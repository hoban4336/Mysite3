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

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,  IOException {
		//인증여부
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if( session ==null || authUser ==null){
			WebUtil.redirect(request, response, "/Mysite3/mysite");	
			return; 
		}
	
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		UserVo uservo = new  UserVo();
		uservo.setNo(Long.parseLong(no.trim()));
		uservo.setName(name);
		uservo.setPassword(password);
		uservo.setGender(gender);
		
		 new UserDao().update(uservo);
		 
		 WebUtil.redirect(request, response, "/Mysite3/user?action=ModifyForm&update=success");	
	}

}
