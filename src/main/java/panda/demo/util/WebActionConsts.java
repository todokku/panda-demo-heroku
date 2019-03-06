package panda.demo.util;

import java.util.Map;

import panda.app.util.AppActionConsts;
import panda.ioc.Scope;
import panda.ioc.annotation.IocBean;
import panda.mvc.util.ActionConsts;

@IocBean(type=ActionConsts.class, scope=Scope.REQUEST)
public class WebActionConsts extends AppActionConsts {

	public Map getPetGenderMap() {
		return this.getTextAsMap("pet-gender-map");
	}

	public Map getPetOriginMap() {
		return this.getTextAsMap("pet-origin-map");
	}

	public Map getPetTemperMap() {
		return this.getTextAsMap("pet-temper-map");
	}

	public Map getPetHabitMap() {
		return this.getTextAsMap("pet-habit-map");
	}
}
