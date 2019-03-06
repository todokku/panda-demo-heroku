package panda.demo.action.entity.user;

import java.util.List;

import panda.app.auth.Auth;
import panda.app.constant.AUTH;
import panda.dao.query.DataQuery;
import panda.demo.constant.V;
import panda.demo.entity.User;
import panda.demo.entity.query.UserQuery;
import panda.mvc.annotation.At;

@At("${super_path}/user")
@Auth(AUTH.SUPER)
public class UserBulkDisableExAction extends UserBulkDisableAction {

	public UserBulkDisableExAction() {
		super();
	}

	@Override
	protected void addQueryFilters(DataQuery<User> gq) {
		super.addQueryFilters(gq);
		
		User lu = assist().getLoginUser();

		UserQuery q = new UserQuery(gq);
		q.status().in(V.STATUS_ACTIVE).id().ne(lu.getId());
	}

	@Override
	protected User getBulkUpdateSample(List<User> dataList, DataQuery<User> gq) {
		User d = new User();
		d.setStatus(V.STATUS_DISABLED);

		gq.excludeAll().include(User.STATUS);

		return d;
	}

}
