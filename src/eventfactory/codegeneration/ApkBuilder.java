package eventfactory.codegeneration;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;

import kellinwood.security.zipsigner.ZipSigner;

public class ApkBuilder {
	
	public void generateAndSignApk(String appName) throws Exception{
		Runtime rt = Runtime.getRuntime();
		String gradlewBat = this.getClass().getResource("/apk_templates/$app_name/gradlew.bat").getPath();
		
		String[] commands = {gradlewBat + " assembleRelease"};
		Process proc = rt.exec(commands);

		BufferedReader stdInput = new BufferedReader(new 
		     InputStreamReader(proc.getInputStream()));

		String accum = "";
		String s = null;
		while ((s = stdInput.readLine()) != null) {
		    accum += s + "\n";
		}

		if(!accum.contains("SUCCESSFUL") && !accum.contains("successful")) throw new Exception("Build failed; trace: \n" + accum);
		
		try{ signAPK(appName); } catch(Throwable t) { t.printStackTrace(); }
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
