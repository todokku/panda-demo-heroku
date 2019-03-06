package panda.demo.action.sample;

import panda.demo.action.WebAction;
import panda.lang.Arrays;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.annotation.param.Param;
import panda.mvc.view.Views;
import panda.vfs.FileItem;

@At("/mfupd")
public class MultiFileUploadAction extends WebAction {
	@At("")
	@To(Views.SFTL)
	public void ftl(@Param("files") FileItem[] files) {
		if (Arrays.isEmpty(files)) {
			return;
		}
		
		for (FileItem f : files) {
			addActionMessage(f.getName() + " [" + f.getSize() + "] " + f.isExists());
		}
	}
}
