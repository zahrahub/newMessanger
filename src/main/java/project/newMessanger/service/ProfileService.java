package project.newMessanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import project.newMessanger.database.Database;
import project.newMessanger.model.Message;
import project.newMessanger.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = Database.getProfiles();
	
	public ProfileService() {
		 profiles.put("zahra", new Profile(1l, "zahra", "zahra", "mollanoori"));
		 profiles.put("nikan", new Profile(2l, "nikan", "nikan", "musavi"));
		 
	}
	
	public List<Profile> getAllprofiles(){
	
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String name) {
		return profiles.get(name);
	
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	
	public Profile updateProfiles(Profile profile) {
		if(profile.getFirstName().isEmpty()) {
			return null;
			
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String name) {
		return profiles.remove(name);
	}

}
