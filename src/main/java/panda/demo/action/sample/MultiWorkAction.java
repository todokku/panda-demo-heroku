package panda.demo.action.sample;

import panda.lang.Threads;
import panda.mvc.annotation.At;
import panda.app.action.work.GenericMultiWorkAction;

@At("/mwork")
public class MultiWorkAction extends GenericMultiWorkAction {
	@Override
	protected void doExecute() throws Exception {
		status.total = 60;
		for (int i = 0; i < status.total; i++) {
			status.count++;
			printInfo("Sleep 1s");
			Threads.safeSleep(1000);
		}
	}
}
