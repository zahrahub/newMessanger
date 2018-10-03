package project.newMessanger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
 
public class Message {
	private long id;
	private String author;
	private Date created;
	private String mmessage;
	
	public Message() {
		
	}
	
	public Message(long id, String author, String mmessage) {
		super();
		this.id = id;
		this.author = author;
		this.mmessage = mmessage;
		this.created = new Date();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getMmessage() {
		return mmessage;
	}
	public void setMmessage(String mmessage) {
		this.mmessage = mmessage;
	}
	
	
}
