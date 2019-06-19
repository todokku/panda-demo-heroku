package panda.demo.action.sample;

import panda.app.action.base.BaseHtml2PdfAction;
import panda.app.auth.Auth;
import panda.mvc.annotation.At;

@Auth
@At("/pdf")
public class PdfAction extends BaseHtml2PdfAction {

}
