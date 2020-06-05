package panda.demo.action.test;

import java.io.IOException;
import java.util.Map;

import panda.app.action.BaseAction;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.annotation.param.Param;


@At("/test")
public class TestAction extends BaseAction {
	@At
	@To("sjson:{'includeParams':true}")
	public Object json(@Param Map m) {
		return m;
	}

	@At
	@To("sxml:{'includeParams':true}")
	public Object xml(@Param Map m) {
		return m;
	}

	@At
	@To("raw:{'encoding':'${params.c}'}")
	public Object echo(@Param("c") String cs, @Param("t") String txt) throws IOException {
		return txt;
	}
}
