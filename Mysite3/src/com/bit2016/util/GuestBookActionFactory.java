package com.bit2016.util;

import com.bit2016.web.ListAction;
import com.bit2016.web.addAction;
import com.bit2016.web.deleteAction;
import com.bit2016.web.deleteFormAction;



public class GuestBookActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if ("add".equals(actionName)) {
			action = new addAction();
		} else if ("delete".equals(actionName)) {
			action = new deleteAction();
		} else if ("deleteform".equals(actionName)) {
			action = new deleteFormAction();
		} else {
			action = new ListAction();
		}
		return action;
	}

}
