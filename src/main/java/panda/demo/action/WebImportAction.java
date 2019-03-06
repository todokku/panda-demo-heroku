package panda.demo.action;

import panda.app.action.crud.GenericImportAction;
import panda.demo.util.WebActionAssist;
import panda.demo.util.WebActionConsts;

/**
 * @param <T> data type
 */
public abstract class WebImportAction<T> extends GenericImportAction<T> {
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
