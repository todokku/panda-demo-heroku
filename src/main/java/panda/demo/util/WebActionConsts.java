package panda.demo.util;

import java.util.Map;

import panda.app.util.AppActionConsts;
import panda.ioc.Scope;
import panda.ioc.annotation.IocBean;
import panda.mvc.util.ActionConsts;

@IocBean(type=ActionConsts.class, scope=Scope.REQUEST)
public class WebActionConsts extends AppActionConsts {

	public Map getPetGenderMap() {
		return (Map)get("petGenderMap");
	}

	public Map getPetOriginMap() {
		return (Map)get("petOriginMap");
	}

	public Map getPetTemperMap() {
		return (Map)get("petTemperMap");
	}

	public Map getPetHabitMap() {
		return (Map)get("petHabitMap");
	}
}
