package ee.rental.app.core.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property="atmessageId")
public class Message {
	@Id @GeneratedValue
	private Long id;
	@Lob
	private String message;
	//@JoinColumn(name="senderId")
	@OneToOne(cascade=CascadeType.ALL)
	//@PrimaryKeyJoinColumn
	private UserAccount sender;
	//@JoinColumn(name="receiverId")
	@OneToOne(cascade=CascadeType.ALL)
	//@PrimaryKeyJoinColumn
	private UserAccount receiver;
	@OneToOne(cascade=CascadeType.ALL)
	//@PrimaryKeyJoinColumn
	//dont need booking info in each message
	@JsonIgnore
	private Booking booking;
	private Date sentDate;
	private Boolean receiverRead;
	
	public Boolean getReceiverRead() {
		return receiverRead;
	}
	public void setReceiverRead(Boolean receiverRead) {
		this.receiverRead = receiverRead;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	@JsonIgnore
	public Booking getBooking() {
		return booking;
	}
	@JsonProperty
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserAccount getSender() {
		return sender;
	}
	public void setSender(UserAccount sender) {
		this.sender = sender;
	}
	public UserAccount getReceiver() {
		return receiver;
	}
	public void setReceiver(UserAccount receiver) {
		this.receiver = receiver;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", sender="
				+ sender + ", receiver=" + receiver + ", booking=" + booking
				+ ", sentDate=" + sentDate + ", receiverRead=" + receiverRead
				+ "]";
	}
}
