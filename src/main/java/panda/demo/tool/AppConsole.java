package panda.demo.tool;

import panda.demo.WebSetup;
import panda.mvc.MvcConsole;

public class AppConsole extends MvcConsole {
	private static AppConsole INSTANCE;
	
	public static synchronized AppConsole i() {
		if (INSTANCE == null) {
			INSTANCE = new AppConsole();
		}
		return INSTANCE;
	}

	public AppConsole() {
		super(WebSetup.class, "web");
	}
}
