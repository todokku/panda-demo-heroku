package panda.demo.action.entity.user;

import java.util.HashSet;
import java.util.Set;

import panda.app.auth.Auth;
import panda.app.constant.AUTH;
import panda.demo.auth.ROLE;
import panda.demo.auth.WebAuthenticator;
import panda.demo.constant.V;
import panda.demo.entity.User;
import panda.lang.Strings;
import panda.mvc.annotation.At;

@At("${!!super_path|||'/super'}/user")
@Auth(AUTH.SUPER)
public class UserEditExAction extends UserEditAction {

	public UserEditExAction() {
		super();
	}

	@Override
	protected User prepareData(User data) {
		User pu = super.prepareData(data);
		
		if (Strings.isEmpty(pu.getRole())) {
			pu.setRole(ROLE.USER);
		}
		if (pu.getStatus() == null) {
			pu.setStatus(V.STATUS_ACTIVE);
		}

		return pu;
	}

	@Override
	protected User trimData(User d) {
		d.setPassword(null);
		return super.trimData(d);
	}

	@Override
	protected User startInsert(User data) {
		data = super.startInsert(data);

		if (Strings.isEmpty(data.getPassword())) {
			data.setPassword(V.DEFAULT_PWD);
		}

		User iu = data.clone();
		iu.setPassword(WebAuthenticator.hashPassword(iu.getPassword()));
		return iu;
	}

	@Override
	protected User startUpdate(User data, User sd) {
		data = super.startUpdate(data, sd);

		User ud = data;
		if (Strings.isNotEmpty(data.getPassword())) {
			ud = data.clone();
			ud.setPassword(WebAuthenticator.hashPassword(ud.getPassword()));
		}
		return ud;
	}

	@Override
	protected Set<String> getUpdateFields(User data, User sd) {
		Set<String> ufs = super.getUpdateFields(data, sd);
		if (Strings.isEmpty(data.getPassword())) {
			ufs = new HashSet<String>(ufs);
			ufs.remove(User.PASSWORD);
		}

		return ufs;
	}
}
