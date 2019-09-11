package panda.demo.action.test;

import java.io.IOException;
import java.util.Map;

import panda.app.action.BaseAction;
import panda.io.MimeTypes;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.annotation.param.Param;
import panda.mvc.view.Views;
import panda.servlet.HttpServletResponser;


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

	@At
	@To(Views.NONE)
	public void echo(@Param("c") String cs, @Param("t") String txt) throws IOException {
		HttpServletResponser hsrs = new HttpServletResponser(getRequest(), getResponse());
		hsrs.setContentType(MimeTypes.TEXT_HTML);
		hsrs.setMaxAge(0);
		hsrs.setCharset(cs);
		hsrs.writeHeader();
		hsrs.writeText(txt);
	}
}
