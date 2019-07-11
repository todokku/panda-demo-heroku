package panda.demo.action.test;

import java.util.Map;

import panda.app.action.BaseAction;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.annotation.param.Param;
import panda.mvc.view.Views;


@At("/test")
public class TestAction extends BaseAction {
	@At
	@To(Views.SJSON)
	public void json(@Param Map m) {
	}

	@At
	@To(Views.SXML)
	public void xml(@Param Map m) {
	}
}
