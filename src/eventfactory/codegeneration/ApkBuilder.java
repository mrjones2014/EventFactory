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
		String gradlewBat = "buildApp.bat";
		
		String[] commands = {gradlewBat, };
		Process proc = rt.exec(commands);

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
		String signedApkPath = "";
		try{ signedApkPath = signAPK(appName); } catch(Throwable t) { t.printStackTrace(); }
		
		apkFilePath = signedApkPath.replace("war/", "");
	}
	
	private String signAPK(String appName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, GeneralSecurityException {
    	String apkDir = "apk_templates/$app_name/app/build/outputs/apk/";
        String generatedApkPath = apkDir + "app-release-unsigned.apk";

        String signedApkPath = "war/" + appName + "-signed.apk";

        ZipSigner zipSigner = null;
        zipSigner = new ZipSigner();

        zipSigner.setKeymode(ZipSigner.KEY_NONE);

        zipSigner.signZip(generatedApkPath, signedApkPath);

        // After signing apk , delete unsigned apk
        new File(generatedApkPath).delete();
        return signedApkPath;
	}
}
