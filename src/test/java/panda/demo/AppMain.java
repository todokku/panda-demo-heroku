package panda.demo;

import panda.io.Files;

public class AppMain {
	public static void main(String[] args) {
		try {
			Files.makeDirs("web/WEB-INF/_sqlite");

			System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow", "|{}&");
			AppLaunch.main(new String[] { 
					"--port", "80",
					"--sslport", "443",
					"--keystoreFile", "web/WEB-INF/keystore.pfx",
					"--keystorePass", "trustme",
					"--keystoreType", "PKCS12",
//					"--path", "pdemo",
					"--temp-directory", "out/tomcat",
					"--uri-encoding", "UTF-8",
					"--use-body-encoding-for-uri",
					"web" });
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
