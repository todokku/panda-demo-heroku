package panda.demo.action.entity.user;

import panda.demo.action.WebImportAction;
import panda.demo.entity.User;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.annotation.TokenProtect;
import panda.mvc.annotation.param.Param;
import panda.mvc.view.Views;

public abstract class UserImportAction extends WebImportAction<User> {

	/**
	 * Constructor
	 */
	public UserImportAction() {
		setType(User.class);
		setDisplayFields(User.ID, User.NAME, User.EMAIL, User.ROLE, User.PASSWORD, User.STATUS, User.CREATED_AT, User.CREATED_BY, User.UPDATED_AT, User.UPDATED_BY);
	}


	/*----------------------------------------------------------------------*
	 * Actions
	 *----------------------------------------------------------------------*/
	/**
	 * importx
	 * @param arg argument
	 * @return result or view
	 */
	@At("import")
	@To(value=Views.SFTL, error=Views.SFTL)
	@TokenProtect
	public Object importx(@Param Arg arg) {
		return super.importx(arg);
	}
	
}

