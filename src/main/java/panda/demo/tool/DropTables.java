package panda.demo.tool;

import panda.app.AppHelper;
import panda.dao.Dao;
import panda.demo.WebSetup;
import panda.lang.Arrays;



/**
 */
public class DropTables {
	/**
	 * main
	 * @param args arguments
	 */
	public static void main(String[] args) {
		new DropTables().execute();
	}

	public void execute() {
		AppConsole ac = AppConsole.i();
		try {
			Dao dao = ac.getDao();

			Class[] cs = WebSetup.ENTITIES;
			Arrays.reverse(cs);
			AppHelper.dropTables(dao, cs);
		}
		finally {
			ac.destroy();
		}
	}
}
