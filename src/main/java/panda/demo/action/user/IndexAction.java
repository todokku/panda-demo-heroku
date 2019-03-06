package panda.demo.action.user;

import panda.demo.action.WebAction;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.view.Views;
import panda.app.auth.Auth;
import panda.app.constant.AUTH;

@At("/user")
@Auth(AUTH.SIGNIN)
@To(Views.SFTL)
public class IndexAction extends WebAction {

	@At({ "", "index"})
	public void index() {
	}
}
