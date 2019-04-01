package panda.demo.action.entity.user;

import java.util.List;

import panda.app.auth.Auth;
import panda.app.constant.AUTH;
import panda.dao.query.DataQuery;
import panda.demo.constant.V;
import panda.demo.entity.User;
import panda.demo.entity.query.UserQuery;
import panda.mvc.annotation.At;

@At("${!!super_path|||'/super'}/user")
@Auth(AUTH.SUPER)
public class UserBulkEnableExAction extends UserBulkEnableAction {
	public UserBulkEnableExAction() {
		super();
	}

	@Override
	protected void addQueryFilters(DataQuery<User> gq) {
		super.addQueryFilters(gq);
		
		UserQuery q = new UserQuery(gq);
		q.status().in(V.STATUS_DISABLED);
	}

	@Override
	protected User getBulkUpdateSample(List<User> dataList, DataQuery<User> gq) {
		User d = new User();
		d.setStatus(V.STATUS_ACTIVE);

		gq.excludeAll().include(User.STATUS);

		return d;
	}

}
