package project.newMessanger.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injection")
@Produces(MediaType.TEXT_PLAIN) //make sure your header in browser are clear
@Consumes(MediaType.TEXT_PLAIN)
public class InjectionDemoTest {

	@GET
	@Path("annotation")
	//For queryParam we should add ; fllowing by param = value
	//http://localhost:8080/newMessanger/webapi/injection/annotation;param=value
	//For HeaderParam we should add a desired name and take the value
	public String getInjection(@MatrixParam("param")String maxparam
			,@HeaderParam("authSessionId") String idValue ) {
		System.out.println("hey");
		return "matrix param is :" + maxparam + "costomHeaderValue is : " + idValue ;
	}
	
	@GET
	@Path("context")
	
	public String getParamUsingContext(@Context UriInfo info
										,@Context HttpHeaders headers) {
		//return info.getAbsolutePath().toString();
		return headers.getCookies().toString();
	}
}
