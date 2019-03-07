package panda.demo.action.user;

import panda.demo.action.WebAction;
import panda.demo.entity.User;
import panda.lang.Strings;
import panda.lang.time.DateTimes;
import panda.mvc.annotation.At;
import panda.mvc.annotation.Redirect;
import panda.mvc.annotation.To;
import panda.mvc.annotation.param.Param;
import panda.mvc.annotation.validate.RequiredValidate;
import panda.mvc.annotation.validate.VisitValidate;
import panda.mvc.view.Views;


/**
 * LoginAction
 */
@At("/login")
@To(Views.SFTL)
public class LoginAction extends WebAction {
	public static class Arg {
		private String username;
		private String password;
		private Boolean autosave;
		private String redirect;
	
		/**
		 * @return the username
		 */
		@RequiredValidate
		public String getUsername() {
			return username;
		}
	
		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = Strings.stripToLowerNull(username);
		}
	
		/**
		 * @return the password
		 */
		@RequiredValidate
		public String getPassword() {
			return password;
		}
	
		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = Strings.stripToNull(password);
		}
	
		/**
		 * @return the autosave
		 */
		public Boolean getAutosave() {
			return autosave;
		}
	
		/**
		 * @param autosave the autosave to set
		 */
		public void setAutosave(Boolean autosave) {
			this.autosave = autosave;
		}
	
		/**
		 * @return the redirect
		 */
		public String getRedirect() {
			return redirect;
		}
	
		/**
		 * @param redirect the redirect to set
		 */
		public void setRedirect(String redirect) {
			this.redirect = Strings.stripToNull(redirect);
		}
	}
	
	/**
	 * input
	 * @param arg the input argument
	 */
	@At("")
	@Redirect(toslash=true)
	public void input(@Param Arg arg) {
		if (arg.username == null) {
			User u = assist().getLoginUser();
			if (u != null) {
				arg.username = u.getEmail();
			}
		}
	}
	
	/**
	 * login
	 * @param arg the input argument
	 * @return redirect url or view
	 */
	@At
	@To(error=Views.SFTL_INPUT)
	public Object login(@Param @VisitValidate Arg arg) {
		User user = assist().findUser(arg.username, arg.password);
		if (user == null) {
			addActionError(getText("error-login"));
			return Views.sftlInput(context);
		}

		assist().setLoginUser(user, DateTimes.getDate());
		if (Boolean.TRUE.equals(arg.autosave)) {
			assist().saveUserToClient(user);
		}

		addActionMessage(getText("message-login-success"));
		return arg.redirect;
	}

	/**
	 * logout
	 */
	@At
	public void logout() {
		assist().removeLoginUser();
		addActionMessage(getText("message-logout-success"));
	}

}