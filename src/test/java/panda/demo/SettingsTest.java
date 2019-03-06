package panda.demo;

import org.junit.Test;

import panda.io.Settings;

public class SettingsTest {

	private Object top;
	
	/**
	 * @return the top
	 */
	public Object getTop() {
		return top;
	}

	/**
	 * @param top the top to set
	 */
	public void setTop(Object top) {
		this.top = top;
	}

	private void testResourceTemplate(String name) throws Exception {
		new Settings(name);
	}
	
	@Test
	public void testResourceTemplateJA() throws Exception {
		testResourceTemplate("app.properties");
	}
}
