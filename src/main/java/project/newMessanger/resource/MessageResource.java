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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import project.newMessanger.model.Message;
import project.newMessanger.resource.bean.MessageFilterBean;
import project.newMessanger.service.MessageService;

@Path("/messages")

public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//For queryParam we should add ? fllowing by param = value
	//http://localhost:8080/newMessanger/webapi/messages?year=2018
	//http://localhost:8080/newMessanger/webapi/messages?start=0&size=1
	
//	public List<Message> getmessages(@QueryParam("year") int year
//										,@QueryParam("start") int start
//										,@QueryParam("size") int size) {
	
	public List<Message> getmessages(MessageFilterBean filterBean){
		
		if(filterBean.getYear() > 0) {
			return messageService.getMessagesForYear(filterBean.getYear());
		}
		if(filterBean.getStart() > 0 && filterBean.getSize() > 0) {
			return messageService.getMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		
		return messageService.getAllMessages();
	}
	

		//http://localhost:8080/newMessanger/webapi/messages/1

		
		@DELETE
		@Path("/{messageId}")
		@Produces(MediaType.APPLICATION_JSON)
		public Message deleteMessages(@PathParam("messageId")Long id) {

			return messageService.removeMessage(id);
		}
	
	
	//**********PUt method is used to update an existing object
	//http://localhost:8080/newMessanger/webapi/messages/1
	//headers : Content-Type    application/json
	//text(raw) : {
	/*"author": "Nikan",
		"created": "2018-09-22T09:54:50.179",
    	"mmessage": "Hello world again"
	}*/
	
	@PUT
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessages(@PathParam("messageId")Long id,Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	
	//**********POST method is used to create new objects
	//http://localhost:8080/newMessanger/webapi/messages
	//headers : Content-Type    application/json
	//text(raw) : {
	/*"author": "Nikan",
		"created": "2018-09-22T09:54:50.179",
    	"mmessage": "Hello world again"
	}*/
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessages(Message message) {
		return messageService.addMessage(message);
	}
	
	

	
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message test(@PathParam("messageId")Long messageId) {
		return  messageService.getMessage(messageId);
	}
	
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getmessages() {
//		List<Message> messages = messageService.getAllMessages();
//		
//		return Response.ok(messages).build();
//	}
//	

//	 
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getmessages() {
//		return  "hi there";
//	}
	
	//by browsing : http://localhost:8080/newMessanger/webapi/messages/test 
//	@GET
//	@Path("/test")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String test() {
//		return  "hi there";
//	}
//	

}
