package panda.demo.action;

import java.util.Map;

import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.annotation.param.Param;
import panda.mvc.view.Views;


@At("/test")
public class TestAction extends WebAction {
	@At
	@To(Views.SJSON)
	public void json(@Param Map m) {
	}

	@At
	@To(Views.SXML)
	public void xml(@Param Map m) {
	}
}
