package panda.demo.action.tool;

import panda.app.auth.Auth;
import panda.gems.pages.action.PageDetailAction;
import panda.mvc.annotation.At;


@At("${pages_path}")
@Auth
public class PageDetailExAction extends PageDetailAction {
}
