package Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * A class to represent a message.
 *
 * @author pnorby
 */
@Entity(name = "Message")
@Table(name = "message")
public class Message {

    @Column(name = "trip_id")
    private int tripId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "sent_dtm")
    private LocalDate sentDateTime;
    @Column(name = "message_body")
    private String messageBody;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;


    /**
     * Instantiates a new Message.
     */
    public Message() {
    }

    /**
     * Instantiates a new Message.
     *
     * @param tripId       the trip the message is associated with
     * @param userId       person who sent the message
     * @param sentDateTime the time the message was sent
     * @param messageBody  the message body
     */
    public Message(int tripId, int userId, LocalDate sentDateTime, String messageBody) {
        this.tripId = tripId;
        this.userId = userId;
        this.sentDateTime = sentDateTime;
        this.messageBody = messageBody;
    }

    /**
     * Gets trip id.
     *
     * @return the trip id
     */
    public int getTripId() {
        return tripId;
    }

    /**
     * Sets trip id.
     *
     * @param tripId the trip id
     */
    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets sent date time.
     *
     * @return the sent date time
     */
    public LocalDate getSentDateTime() {
        return sentDateTime;
    }

    /**
     * Sets sent date time.
     *
     * @param sentDateTime the sent date time
     */
    public void setSentDateTime(LocalDate sentDateTime) {
        this.sentDateTime = sentDateTime;
    }

    /**
     * Gets message body.
     *
     * @return the message body
     */
    public String getMessageBody() {
        return messageBody;
    }

    /**
     * Sets message body.
     *
     * @param messageBody the message body
     */
    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "tripId=" + tripId +
                ", userId=" + userId +
                ", sentDateTime=" + sentDateTime +
                ", messageBody='" + messageBody + '\'' +
                ", id=" + id +
                '}';
    }
}