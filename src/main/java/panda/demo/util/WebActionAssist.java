package panda.demo.util;

import panda.app.util.AppActionAssist;
import panda.demo.entity.PetImage;
import panda.gems.users.entity.User;
import panda.ioc.Scope;
import panda.ioc.annotation.IocBean;
import panda.mvc.util.ActionAssist;


@IocBean(type=ActionAssist.class, scope=Scope.REQUEST)
public class WebActionAssist extends AppActionAssist {
	@Override
	public User getLoginUser() {
		return (User)super.getLoginUser();
	}

	public String getPetImageLink(PetImage pi) {
		if (pi == null || pi.getImageSize() <= 0) {
			return "";
		}
		return "<a href=\"" + context.getBase() + "/pet/view?id=" + pi.getId() + "\">"
				+ "<img class=\"pi-icon\" src=\"" + context.getBase() + "/petimage/pimage?id=" + pi.getId() + "\">"
				+ "</a>";
	}
}
