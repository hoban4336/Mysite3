package com.mysite.action;

import com.bit2016.util.Action;
import com.bit2016.util.ActionFactory;
import com.mysite.action.guestbook.GuestBookAddAction;
import com.mysite.action.guestbook.GuestBookDeleteAction;
import com.mysite.action.guestbook.GuestBookDeleteFormAction;
import com.mysite.action.guestbook.GuestBookListAction;



public class GuestBookActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		
		Action action = null;
		
		if ("add".equals(actionName)) {
			action = new GuestBookAddAction();
		} else if ("deleteform".equals(actionName)) {
			action = new GuestBookDeleteFormAction();
		} else if ("delete".equals(actionName)) {
			action = new GuestBookDeleteAction();
		} else {
			action = new GuestBookListAction();
		}
		
		return action;
	}

}
