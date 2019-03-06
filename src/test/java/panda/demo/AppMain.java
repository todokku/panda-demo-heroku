package panda.demo;

public class AppMain {
	public static void main(String[] args) {
		try {
			System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow", "|{}&");
			webapp.runner.launch.Main.main(new String[] { 
					"--port", "8080",
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
