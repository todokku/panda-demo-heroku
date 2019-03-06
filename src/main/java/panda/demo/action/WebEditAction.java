package panda.demo.action;

import panda.demo.util.WebActionAssist;
import panda.demo.util.WebActionConsts;
import panda.app.action.crud.GenericEditAction;

/**
 * @param <T> data type
 */
public abstract class WebEditAction<T> extends GenericEditAction<T> {
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
