package panda.demo;

import panda.dao.Dao;
import panda.demo.tool.AppConsole;


public abstract class AppTestCase {
	protected Dao getDao() {
		return AppConsole.i().getDao();
	}
}
