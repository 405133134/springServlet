package cn.enn.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.apache.log4j.Logger;
import org.nutz.json.Json;
import org.nutz.json.JsonException;
import org.nutz.lang.Files;
import org.nutz.lang.Lang;

public class AppConfigure {
	
	private static Logger log=Logger.getLogger(AppConfigure.class);
	
	private static String FILE_NAME="configure.json";
	
	private static AppConfigure gInstance;
	
	private static Profile active=null;
	
	
	public static String rootPath() {
	    String cp = AppConfigure.class.getResource("AppConfigure.class").getFile();
	    System.out.println(cp);

	    if (cp.startsWith("file:")) {
	      cp = cp.substring("file:/".length());
	    }
	    cp = cp.substring(0, cp.lastIndexOf("!"));
	    cp = cp.substring(0, cp.lastIndexOf("/"));
	    if (!Lang.isWin()) {
	      cp = "/" + cp;
	    }
	    return cp;
	}
	public static void main(String[] args) {
		AppConfigure.getProfile();
	}
	
	public static synchronized Profile getProfile(){
		if(active!=null){
			return active;
		}
		if(gInstance==null){
			File f=Files.findFile(FILE_NAME);
			try {
				gInstance=Json.fromJson(AppConfigure.class, new FileReader(f));
			} catch (JsonException e) {
				System.out.println("解析配置文件" + FILE_NAME + "失败:" + e.getMessage());
			} catch (FileNotFoundException e) {
				System.out.println("解析配置文件" + FILE_NAME + "找不到");
			}
		}
		if (gInstance == null) {
		      log.error("ERROR: could not load configure");
		}
		for(Profile p : gInstance.getProfiles()){
			if(gInstance.getActiveProfile().equals(p.getProfileName())){
				active=p;
				log.info("配置信息>" + Json.toJson(p));
		        return p;
			}
		}
		log.error("could not find profile " + gInstance.getActiveProfile() + " in configure file " + FILE_NAME);

	    return null;
		
	}
	
	private String activeProfile;
	
	private List<Profile> profiles;

	public String getActiveProfile() {
		return activeProfile;
	}

	public void setActiveProfile(String activeProfile) {
		this.activeProfile = activeProfile;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}
	
	
	
}
