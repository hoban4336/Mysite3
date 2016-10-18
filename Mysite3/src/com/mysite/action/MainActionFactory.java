package com.mysite.action;

import com.bit2016.util.Action;
import com.bit2016.util.ActionFactory;
import com.mysite.action.main.MainAction;

public class MainActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		return new MainAction();
	}

}
