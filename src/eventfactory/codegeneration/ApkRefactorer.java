package eventfactory.codegeneration;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApkRefactorer {
	public static final String HEX_COLOR_PATTERN = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
	public static final String APP_NAME_STRING = "<string name=\"app_name\">$app_name</string>";
	public static final String APP_LABEL_STRING = "android:label=\"$app_name\"";
	
	public ApkRefactorer(){}
	
	public void makeReplacementsInApkCode(String primaryColor, String secondaryColor, String accentColor, String appName) throws IOException{
		makeReplacementsAndroidManifest(appName);
		makeReplacementsStringsXml(appName);
		makeReplacementsColorsXml(primaryColor, secondaryColor, accentColor);
	}
	
	private void makeReplacementsAndroidManifest(String appName) throws IOException{
		FileInputStream fstream = new FileInputStream(this.getClass().getResource("/apk_templates/$app_name/app/src/main/res/values/strings.xml").getPath());
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		while ((strLine = br.readLine()) != null){
			strLine.replace(APP_LABEL_STRING, "android:label=\"" + appName + "\"");
		}
		br.close();
	}
	
	private void makeReplacementsStringsXml(String appName) throws IOException{
		FileInputStream fstream = new FileInputStream(this.getClass().getResource("/apk_templates/$app_name/app/src/main/res/values/strings.xml").getPath());
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		while ((strLine = br.readLine()) != null){
			strLine.replace(APP_NAME_STRING, "<string name=\"app_name\">" + appName + "</string>");
		}
		br.close();
	}
	
	private void makeReplacementsColorsXml(String primaryColor, String secondaryColor, String accentColor) throws IOException{
		FileInputStream fstream = new FileInputStream(this.getClass().getResource("/apk_templates/$app_name/app/src/main/res/values/colors.xml").getPath());
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		int colorNum = 0;
		String[] colors = new String[3];
		colors[0] = primaryColor;
		colors[1] = secondaryColor;
		colors[2] = accentColor;
		
		while ((strLine = br.readLine()) != null){
			strLine.replaceAll(HEX_COLOR_PATTERN, colors[colorNum]);
			++colorNum;
		}
		br.close();
	}
}
