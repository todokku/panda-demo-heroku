package panda.demo.action.sample;

import panda.app.action.tool.Html2PdfAction;
import panda.app.auth.Auth;
import panda.mvc.annotation.At;

@Auth
@At("/pdf")
public class PdfAction extends Html2PdfAction {

}
