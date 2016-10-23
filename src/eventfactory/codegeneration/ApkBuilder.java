package eventfactory.codegeneration;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.GeneralSecurityException;

import kellinwood.security.zipsigner.ZipSigner;

public class ApkBuilder {
	private String apkFilePath;
	public ApkBuilder() {
		apkFilePath = "";
	}
	
	public String getApkFilePath(){
		return apkFilePath;
	}
	
	public void generateAndSignApk(String appName) throws Exception{
		Runtime rt = Runtime.getRuntime();
		String gradlewBat = "apk_templates/$app_name/gradlew.bat";
		
		String[] commands = {"gradlew.bat", "assembleRelease"};
		//Process proc = rt.exec(commands, null, new File(new File("apk_templates/$app_name/").getAbsolutePath()));
		Process proc = rt.exec(new String[] {"cmd.exe", "/c", "\"apk_templates/$app_name/gradlew.bat\""});

		BufferedReader stdInput = new BufferedReader(new 
		     InputStreamReader(proc.getInputStream()));
		BufferedReader stdError = new BufferedReader(new 
			     InputStreamReader(proc.getErrorStream()));

		String accum = "";
		String s = null;
		while ((s = stdInput.readLine()) != null) {
		    accum += s + "\n";
		}
		
		String accum2 = "";
		while ((s = stdError.readLine()) != null) {
		    accum += s + "\n";
		}

		if(!accum.contains("SUCCESSFUL") && !accum.contains("successful")) throw new Exception("Build failed; trace: \n" + accum + "\n" + accum2);
		
		try{ signAPK(appName); } catch(Throwable t) { t.printStackTrace(); }
		
		apkFilePath = this.getClass().getResource("/apk_templates/$app_name/app/build/outputs/apk/" + appName + "-signed.apk").getPath();
	}
	
	private void signAPK(String appName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, GeneralSecurityException {
    	String apkDir = this.getClass().getResource("/apk_templates/$app_name/app/build/outputs/apk/").getPath();
        String generatedApkPath = apkDir + appName + ".apk";

        String signedApkPath = apkDir + appName + "-signed.apk";

        ZipSigner zipSigner = null;
        zipSigner = new ZipSigner();

        zipSigner.setKeymode(ZipSigner.MODE_AUTO);

        zipSigner.signZip(generatedApkPath, signedApkPath);

        // After signing apk , delete unsigned apk
        new File(generatedApkPath).delete();
	}
}
