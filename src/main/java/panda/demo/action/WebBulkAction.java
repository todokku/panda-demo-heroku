package panda.demo.action;

import panda.demo.util.WebActionAssist;
import panda.demo.util.WebActionConsts;
import panda.app.action.crud.GenericBulkAction;

/**
 * @param <T> data type
 */
public abstract class WebBulkAction<T> extends GenericBulkAction<T> {
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
