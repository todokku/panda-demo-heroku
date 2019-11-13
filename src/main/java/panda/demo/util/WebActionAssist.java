package panda.demo.util;

import java.util.List;
import java.util.Locale;

import panda.app.util.AppActionAssist;
import panda.demo.entity.PetImage;
import panda.gems.users.entity.User;
import panda.ioc.Scope;
import panda.ioc.annotation.IocBean;
import panda.lang.Collections;
import panda.lang.Locales;
import panda.lang.Strings;
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
	
	public String getCountryByLanguage(String language) {
		List<Locale> ls = Locales.countriesByLanguage(language);
		if (Collections.isEmpty(ls)) {
			return "";
		}
		if (ls.size() == 1) {
			return Strings.lowerCase(ls.get(0).getCountry());
		}
		
		if ("en".equals(language)) {
			return "us";
		}
		if ("zh".equals(language)) {
			return "cn";
		}
		return Strings.lowerCase(ls.get(0).getCountry());
	}
}
