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

    @ManyToOne
    private Trip trip;
    @ManyToOne
    private User user;
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
     * @param trip         the trip
     * @param user         the user
     * @param sentDateTime the sent date time
     * @param messageBody  the message body
     */
    public Message(Trip trip, User user, LocalDate sentDateTime, String messageBody) {
        this.trip = trip;
        this.user = user;
        this.sentDateTime = sentDateTime;
        this.messageBody = messageBody;
    }

    /**
     * Gets trip.
     *
     * @return the trip
     */
    public Trip getTrip() {
        return trip;
    }

    /**
     * Sets trip.
     *
     * @param trip the trip
     */
    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
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
                "trip=" + trip +
                ", user=" + user +
                ", sentDateTime=" + sentDateTime +
                ", messageBody='" + messageBody + '\'' +
                ", id=" + id +
                '}';
    }
}