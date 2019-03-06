package panda.demo.util;

import panda.app.util.AppMailer;
import panda.demo.entity.User;
import panda.ioc.Scope;
import panda.ioc.annotation.IocBean;
import panda.net.mail.Email;
import panda.net.mail.EmailException;
import panda.net.mail.HtmlEmail;

@IocBean(type=AppMailer.class, scope=Scope.REQUEST)
public class WebMailer extends AppMailer {
	/**
	 * send email
	 * @param user user 
	 * @param tpl template name
	 * @param context context object
	 * @throws EmailException  email error
	 */
	public void sendTemplateMail(User user, String tpl, Object context) throws EmailException {
		Email email = new HtmlEmail();

		email.addTo(user.getEmail(), user.getName());
		
		sendTemplateMail(email, tpl, context);
	}

}
