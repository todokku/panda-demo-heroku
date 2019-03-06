package panda.demo.action.entity.user;

import java.util.Map;
import panda.dao.query.DataQuery;
import panda.demo.action.WebBulkAction;
import panda.demo.entity.User;
import panda.demo.entity.query.UserQuery;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.annotation.TokenProtect;
import panda.mvc.annotation.param.Param;
import panda.mvc.view.Views;
import panda.net.http.HttpMethod;

public abstract class UserBulkDeleteAction extends WebBulkAction<User> {

	/**
	 * Constructor
	 */
	public UserBulkDeleteAction() {
		setType(User.class);
		addDisplayFields(User.ID, User.NAME, User.EMAIL, User.ROLE, User.STATUS, User.CREATED_AT, User.CREATED_BY, User.CREATED_BY_USER, User.UPDATED_AT, User.UPDATED_BY, User.UPDATED_BY_USER);
	}


	/*----------------------------------------------------------------------*
	 * Joins
	 *----------------------------------------------------------------------*/
	/**
	 * add query joins
	 * @param dq data query
	 */
	@Override
	protected void addQueryJoins(DataQuery<User> dq) {
		super.addQueryJoins(dq);

		UserQuery eq = new UserQuery(dq);
		eq.autoLeftJoinCU();
		eq.autoLeftJoinUU();
	}

	/*----------------------------------------------------------------------*
	 * Actions
	 *----------------------------------------------------------------------*/
	/**
	 * bdelete
	 * @param args arguments
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object bdelete(@Param Map<String, String[]> args) {
		return super.bdelete(args);
	}

	/**
	 * bdelete_execute
	 * @param args arguments
	 * @return result or view
	 */
	@At(method=HttpMethod.POST)
	@To(value=Views.SFTL, error="sftl:~bdelete")
	@TokenProtect
	public Object bdelete_execute(@Param Map<String, String[]> args) {
		return super.bdelete_execute(args);
	}
	
}

