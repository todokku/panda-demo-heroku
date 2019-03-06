package panda.demo.tool;

import panda.demo.auth.WebAuthenticator;
import panda.lang.Arrays;



/**
 */
public class HashPwd {
	/**
	 * main
	 * @param args arguments
	 */
	public static void main(String[] args) {
		new HashPwd().execute(args);
	}

	public void execute(String[] args) {
		if (Arrays.isEmpty(args)) {
			return;
		}
		
		for (String p : args) {
			System.out.println(p + ": " + WebAuthenticator.hashPassword(p));
		}
	}
}
