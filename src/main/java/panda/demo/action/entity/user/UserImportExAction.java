package panda.demo.action.entity.user;

import panda.app.auth.Auth;
import panda.app.constant.AUTH;
import panda.demo.auth.WebAuthenticator;
import panda.demo.constant.V;
import panda.demo.entity.User;
import panda.lang.Strings;
import panda.mvc.annotation.At;

@At("${!!super_path|||'/super'}/user")
@Auth(AUTH.SUPER)
public class UserImportExAction extends UserImportAction {

	public UserImportExAction() {
		super();
	}

	protected void checkNotNulls(User data) {
		// disable pwd null check
		String pwd = data.getPassword();
		data.setPassword("-");
		try {
			super.checkNotNulls(data);
		}
		finally {
			data.setPassword(pwd);
		}
	}
	
	@Override
	protected void insertData(User data) {
		if (Strings.isEmpty(data.getPassword())) {
			data.setPassword(WebAuthenticator.hashPassword(V.DEFAULT_PWD));
		}
		else if (data.getPassword().length() != WebAuthenticator.HASH_PASSWORD_LENGTH) {
			data.setPassword(WebAuthenticator.hashPassword(data.getPassword()));
		}

		super.insertData(data);
	}
}
