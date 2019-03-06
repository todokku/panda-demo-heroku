package panda.demo.action.sample;

import java.util.Map;

import panda.demo.action.WebAction;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.annotation.param.Param;
import panda.mvc.view.Views;

@At("/")
public class TagsAction extends WebAction {

	@At
	@To(value=Views.SJSP, error=Views.SJSP)
	public void jsptags(@Param Map<String, Object> ps) {
	}

	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public void ftltags(@Param Map<String, Object> ps) {
	}
}
