package com.mysite.action.main;

import com.bit2016.util.Action;
import com.bit2016.util.ActionFactory;

public class MainActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		return new MainAction();
	}

}
