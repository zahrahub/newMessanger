package project.newMessanger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import project.newMessanger.model.Profile;
import project.newMessanger.service.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ProfileResource {

	ProfileService profileService = new ProfileService();

	@GET
	public List<Profile> getProfiles() {
		return profileService.getAllprofiles();
	}

	@GET
	@Path("/{ProfileName}")
	public Profile getProfile(@PathParam("ProfileName")String profileName) {
		return profileService.getProfile(profileName);
	}
	
	@DELETE
	@Path("/{ProfileName}")
	public Profile deleteMessages(@PathParam("ProfileName") String profileName) {

		return profileService.removeProfile(profileName);
	}

	@PUT
	@Path("/{profileName}")
	public Profile updateProfiles(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		return profileService.updateProfiles(profile);
	}

	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}

}
