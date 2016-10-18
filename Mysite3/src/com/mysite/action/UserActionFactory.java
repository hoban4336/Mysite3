package com.mysite.action;

import com.bit2016.util.Action;
import com.bit2016.util.ActionFactory;
import com.bit2016.util.WebUtil;
import com.mysite.action.main.MainAction;
import com.mysite.action.user.join.JoinAction;
import com.mysite.action.user.join.JoinFormAction;
import com.mysite.action.user.join.JoinSuccessAction;
import com.mysite.action.user.login.LoginAction;
import com.mysite.action.user.login.LoginFormAction;
import com.mysite.action.user.login.LoginOutAction;
import com.mysite.action.user.modify.ModifyAction;
import com.mysite.action.user.modify.ModifyFormAction;

public class UserActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
			//회원가입 폼 보여주기.
		if("JoinForm".equals(actionName)){
			action = new JoinFormAction();
		}else if ( "Join".equals(actionName)){
			action = new JoinAction();
		}else if ("JoinSuccess".equals(actionName))	{
			action = new JoinSuccessAction();
		}else if ("loginForm".equals(actionName))	{
			action = new LoginFormAction();
		}else if ("login".equals(actionName))	{
			action = new LoginAction();
		}else if ("logout".equals(actionName))	{
			action = new LoginOutAction();
		}else if ("ModifyForm".equals(actionName))	{
			action = new ModifyFormAction();
		}else if ("Modify".equals(actionName))	{
			action = new ModifyAction();
		}else{
			action = new MainAction();
		}
		return action;
	}

}
