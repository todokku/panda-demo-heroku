package panda.demo.action;

import panda.demo.util.WebActionAssist;
import panda.demo.util.WebActionConsts;
import panda.app.action.AbstractAction;


public abstract class WebAction extends AbstractAction {
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
