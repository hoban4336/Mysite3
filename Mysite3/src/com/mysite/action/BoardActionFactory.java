package com.mysite.action;

import com.bit2016.util.Action;
import com.bit2016.util.ActionFactory;
import com.mysite.action.board.BoardListAction;


public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if("add".equals(actionName) ){
			action =  new BoardListAction();
		}else{
			action =  new BoardListAction();
		}
		return action;
	}
	

}
