package panda.demo.action;

import panda.mvc.annotation.At;
import panda.app.action.base.BaseFileAction;


@At("${files_path}")
public class TempFileAction extends BaseFileAction {
}
