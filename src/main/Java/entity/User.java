package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A class to represent a user.
 *
 * @author pnorby
 */
@Entity(name = "User")
@Table(name = "user")
public class User implements java.io.Serializable {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int userid;

    @OneToMany(mappedBy = "tripCreator", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Trip> tripsCreated = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Message> messages = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "user_trip_xref", catalog = "sample", joinColumns = {
            @JoinColumn(name = "userid") },
            inverseJoinColumns = { @JoinColumn(name = "tripid") }
    )
    Set<Trip> tripsAttending = new HashSet<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userName  the user name
     * @param email     the user email address
     * @param password  the password
     */
    public User(String firstName, String lastName, String userName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(String firstName, String lastName, String userName, String email, String password, Set<Trip> tripsAttending) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.tripsAttending = tripsAttending;
    }


    public Set<Trip> getTripsAttending(){
        return this.tripsAttending;
    }

    public void setTripsAttending(Set<Trip> trips) {
        this.tripsAttending = trips;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getUserid() {
        return userid;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setUserid(int id) {
        this.userid = id;
    }

    /**
     * Gets email.
     *
     * @return the email address
     */
    public String getEmail() {return email; }

    /**
     * Sets email.
     *
     * @param address the email address
     */
    public void setEmail(String address) {this.email = address; }

    /**
     * Add a trip.
     *
     * @param trip the trip to add
     */
    public void addTrip(Trip trip) {
        tripsCreated.add(trip);
        trip.setTripCreator( this );
    }

    /**
     * Gets trips.
     *
     * @return the trips
     */
    public Set<Trip> getTripsCreated() {
        return tripsCreated;
    }

    /**
     * Sets trips.
     *
     * @param trips the trips
     */
    public void setTripsCreated(Set<Trip> trips) {
        this.tripsCreated = trips;
    }

    /**
     * Gets messages.
     *
     * @return the messages
     */
    public Set<Message> getMessages() {
        return messages;
    }

    /**
     * Sets messages.
     *
     * @param messages the messages
     */
    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}