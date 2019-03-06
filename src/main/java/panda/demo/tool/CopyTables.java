package panda.demo.tool;

import java.util.Map;
import java.util.Map.Entry;

import panda.app.AppHelper;
import panda.dao.sql.SqlDaoClient;
import panda.demo.WebSetup;
import panda.io.Settings;
import panda.lang.Collections;


/**
 */
public class CopyTables {
	/**
	 * main
	 * @param args arguments
	 */
	public static void main(String[] args) {
		new CopyTables().execute(args[0], args[1]);
	}

	public void execute(String src, String des) {
		try {
			Settings ss = new Settings("app.properties");
			for (Entry<String, String> en : ss.entrySet()) {
				if (en.getValue().contains("${web}")) {
					String v = en.getValue().replace("${web}", "web");
					en.setValue(v);
				}
			}

			Map<String, String> dp0 = Collections.subMap(ss, "data." + src + ".");
			SqlDaoClient dc0 = AppHelper.createSqlDaoClient(dp0);
			
			Map<String, String> dp1 = Collections.subMap(ss, "data." + des + ".");
			SqlDaoClient dc1 = AppHelper.createSqlDaoClient(dp1);
			
			AppHelper.copyTables(dc0.getDao(), dc1.getDao(), WebSetup.ENTITIES);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
