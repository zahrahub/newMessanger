package project.newMessanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import project.newMessanger.database.Database;
import project.newMessanger.model.Message;


public class MessageService {
	private Map<Long, Message> messages = Database.getMessages();
	
	public MessageService() {
		 messages.put(1l, new Message(1, "zahra", "Hello world"));
		 messages.put(2l, new Message(2, "zahra1", "Hello jersy"));
	}
	
	public List<Message> getAllMessages(){
	
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getMessagesForYear(int year){
		List<Message> messageByYear = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for (Message message : messages.values()) {
			System.out.println("------------" + message.getCreated().getYear() );
			calendar.setTime(message.getCreated());
			if(calendar.get(Calendar.YEAR) == year) {
				messageByYear.add(message);
			}
		}
		return messageByYear;
	}
	
	public List<Message> getMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<>(messages.values());
		if(start + size > list.size()) {
			System.out.println(")))))))))))00");
			return new ArrayList<Message>();
		}
		System.out.println(list.subList(start, start + size));
		return list.subList(start, start + size);
	}
	
	public Message getMessage(Long id) {
		return messages.get(id);
	
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	
	public Message updateMessage(Message msg) {
		if(msg.getId() <= 0) {
			return null;
			
		}
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}