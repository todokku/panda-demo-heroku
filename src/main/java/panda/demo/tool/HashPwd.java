package panda.demo.tool;

import panda.lang.Arrays;
import panda.util.crypto.Digests;



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
			System.out.println(p + ": " + Digests.sha256Hex(p));
		}
	}
}
