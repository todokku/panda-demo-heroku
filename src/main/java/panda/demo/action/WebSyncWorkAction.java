package panda.demo.action;

import panda.app.action.work.SyncWorkAction;
import panda.dao.DaoClient;
import panda.demo.util.WebActionAssist;
import panda.demo.util.WebActionConsts;
import panda.ioc.annotation.IocInject;


public abstract class WebSyncWorkAction extends SyncWorkAction {
	@IocInject
	protected DaoClient daoClient;

	/**
	 * @return the daoClient
	 */
	protected DaoClient getDaoClient() {
		return daoClient;
	}
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
