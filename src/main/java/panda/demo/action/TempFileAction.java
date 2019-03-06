package panda.demo.action;

import panda.mvc.annotation.At;
import panda.app.action.base.BaseTempFileAction;


@At("${files_path}")
public class TempFileAction extends BaseTempFileAction {
}
