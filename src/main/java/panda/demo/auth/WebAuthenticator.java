package panda.demo.auth;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import panda.app.auth.AppAuthenticator;
import panda.app.auth.UserAuthenticator;
import panda.dao.Dao;
import panda.dao.DaoClient;
import panda.demo.constant.V;
import panda.demo.entity.User;
import panda.demo.entity.query.UserQuery;
import panda.ioc.annotation.IocBean;
import panda.ioc.annotation.IocInject;
import panda.lang.Strings;
import panda.mvc.ActionContext;
import panda.util.crypto.Digests;

@IocBean(type=UserAuthenticator.class)
public class WebAuthenticator extends AppAuthenticator {
	@IocInject
	private DaoClient daoClient;

	public static int HASH_PASSWORD_LENGTH = hashPassword(V.DEFAULT_PWD).length();
	
	public static String hashPassword(String password) {
		return Digests.sha256Hex(password);
	}

	public User findUser(String usr, String pwd) {
		Dao dao = daoClient.getDao();

		// find user
		UserQuery uq = new UserQuery();

		pwd = hashPassword(pwd);
		uq.email().eq(usr);
		uq.password().eq(pwd);
		uq.status().eq(V.STATUS_ACTIVE);

		return dao.fetch(uq);
	}
	
	@Override
	protected Object getUserFromParameter(ActionContext ac) {
		User u = (User)super.getUserFromParameter(ac);
		if (u != null) {
			return u;
		}
		
		HttpServletRequest req = ac.getRequest();
		
		String usr = Strings.strip(req.getParameter("_usr_"));
		String pwd = Strings.strip(req.getParameter("_pwd_"));
		if (Strings.isEmpty(usr) || Strings.isEmpty(pwd)) {
			return null;
		}
		
		return findUser(usr, pwd);
	}

	@Override
	protected String serializeUser(Object user) {
		User u = (User)user;

		Map<String, Object> cu = new HashMap<String, Object>(2);
		cu.put(User.ID, u.getId());
		cu.put(User.PASSWORD, u.getPassword());

		return super.serializeUser(cu);
	}

	@Override
	protected Object deserializeUser(String ticket) {
		User u = (User)super.deserializeUser(ticket);

		if (u == null || u.getId() == null) {
			return null;
		}
		
		Dao dao = daoClient.getDao();
		UserQuery q = new UserQuery();
		q.id().eq(u.getId()).password().eq(u.getPassword()).status().eq(V.STATUS_ACTIVE);
		
		return dao.fetch(q);
	}
}
