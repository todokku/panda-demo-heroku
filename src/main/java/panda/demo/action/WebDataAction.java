package panda.demo.action;

import panda.app.action.AbstractDataAction;
import panda.demo.util.WebActionAssist;
import panda.demo.util.WebActionConsts;


public abstract class WebDataAction extends AbstractDataAction {
	/**
	 * @return the consts
	 */
	@Override
	protected WebActionConsts consts() {
		return (WebActionConsts)super.getConsts();
	}

	/**
	 * @return the assist
	 */
	@Override
	protected WebActionAssist assist() {
		return (WebActionAssist)super.getAssist();
	}
}
