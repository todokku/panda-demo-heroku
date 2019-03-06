package panda.demo.action.user;

import java.util.List;

import panda.app.constant.RES;
import panda.dao.entity.EntityDao;
import panda.demo.action.WebAction;
import panda.demo.auth.ROLE;
import panda.demo.auth.WebAuthenticator;
import panda.demo.constant.T;
import panda.demo.entity.User;
import panda.demo.entity.query.UserQuery;
import panda.demo.util.WebMailer;
import panda.ioc.annotation.IocInject;
import panda.lang.Strings;
import panda.lang.Texts;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.annotation.param.Param;
import panda.mvc.annotation.validate.RequiredValidate;
import panda.mvc.annotation.validate.VisitValidate;
import panda.mvc.view.Views;
import panda.net.mail.EmailException;
import panda.servlet.HttpServlets;


/**
 * RegisterAction
 */
@At("/user/register")
@To(value=Views.SFTL, error=Views.SFTL_INPUT)
public class RegisterAction extends WebAction {

	@IocInject
	private WebMailer mailer;

	public static class Arg extends User {
		private static final long serialVersionUID = 1L;

		private String redirect;
		private Boolean autoLogin;

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

		/**
		 * @return the autoLogin
		 */
		public Boolean getAutoLogin() {
			return autoLogin;
		}

		/**
		 * @param autoLogin the autoLogin to set
		 */
		public void setAutoLogin(Boolean autoLogin) {
			this.autoLogin = autoLogin;
		}
	}

	/**
	 * public for getText(...)
	 * @return the type
	 */
	public Class<?> getT() {
		return User.class;
	}
	
	/**
	 * check email
	 * @param email the email
	 * @return true/false
	 */
	protected boolean checkEmail(String email) {
		EntityDao<User> udao = getDaoClient().getEntityDao(User.class);

		UserQuery uq = new UserQuery();
		uq.email().eq(email);

		List<User> list = udao.select(uq);

		if (list.size() > 0) {
			addFieldError("email", getText("error-email-is-used"));
			return false;
		}

		return true;
	}
	
	/**
	 * input
	 * @param user the input user data
	 */
	@At
	public void input(@Param User user) {
	}
	
	/**
	 * confirm
	 * @param user the input user data
	 * @return user object or view
	 */
	@At
	public Object confirm(@Param
			@RequiredValidate(fields={ "name", "email", "password" })
			@VisitValidate
			Arg user) {
		if (!checkEmail(user.getEmail())) {
			return Views.sftlInput(context);
		}

		addActionConfirm(getText("message-confirm"));
		return null;
	}

	/**
	 * execute
	 * @param user the input user data
	 * @return user object or view
	 */
	@At
	public Object execute(final @Param
			@RequiredValidate(fields={ "name", "email", "password" })
			@VisitValidate
			Arg user) {
		if (!checkEmail(user.getEmail())) {
			return Views.sftlInput(context);
		}

		final EntityDao<User> udao = getDaoClient().getEntityDao(User.class);
		udao.exec(new Runnable() {
			public void run() {
				String pwd = user.getPassword();

				user.setId(null);
				user.setPassword(WebAuthenticator.hashPassword(pwd));
				user.setRole(ROLE.USER);
				assist().setCreatedByFields(user);
				udao.insert(user);

				try {
					user.setPassword(Texts.maskPassword(pwd));
					mailer.sendTemplateMail(user, T.MAIL_REGISTER, user);
				}
				catch (EmailException e) {
					String msg = getText(RES.ERROR_SENDMAIL, RES.ERROR_SENDMAIL, user.getEmail());
					if (assist().ignoreEmailException()) {
						addActionWarning(msg);
					}
					else {
						addActionError(msg);
						udao.rollback();
					}
				}
				finally {
					user.setPassword(WebAuthenticator.hashPassword(pwd));
				}
			}
		});

		if (hasActionErrors()) {
			return Views.sftlInput(context);
		}

		assist().setLoginUser(user);

		if (Strings.isNotEmpty(user.redirect)) {
			int timeout = getTextAsInt(RES.REDIRECT_TIMEOUT, 0);
			if (timeout < 1) {
				HttpServlets.sendRedirect(getResponse(), user.redirect);
				return Views.none(context);
			}
		}

		addActionMessage(getText(RES.MESSAGE_SUCCESS));
		return null;
	}
}
