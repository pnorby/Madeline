package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * A class to represent a trip.
 *
 * @author pnorby
 */
@Entity(name = "Trip")
    @Table(name = "trip")
    public class Trip {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @ManyToOne
    @JoinColumn(name = "trip_location",
      foreignKey = @ForeignKey(name = "trip_location_id_fk"))
    private Location location;

    @ManyToOne
    @JoinColumn(name = "trip_creator",
            foreignKey = @ForeignKey(name = "trip_user_id_fk"))
    private User tripCreator;

    @Column(name = "trip_name")
    private String tripName;

    @Column(name = "trip_start_date")
    private LocalDate tripStartDate;

    @Column(name = "trip_end_date")
    private LocalDate tripEndDate;


    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Message> messages = new HashSet<>();

    /**
     * Instantiates a new User.
     */
    public Trip() {
        }

    /**
     * Instantiates a new User.
     *
     * @param location      the location
     * @param tripName      the trip name
     * @param tripStartDate the date the trip begins
     * @param tripEndDate   the date the trip ends
     * @param tripCreator   the trip creator
     */
    public Trip(Location location, String tripName, LocalDate tripStartDate, LocalDate tripEndDate, User tripCreator) {
            this.location = location;
            this.tripName = tripName;
            this.tripStartDate = tripStartDate;
            this.tripEndDate = tripEndDate;
            this.tripCreator = tripCreator;

        }

    /**
     * Gets location.
     *
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Gets trip start date.
     *
     * @return the trip start date
     */
    public LocalDate getTripStartDate() {
        return tripStartDate;
    }

    /**
     * Sets trip start date.
     *
     * @param tripStartDate the trip start date
     */
    public void setTripStartDate(LocalDate tripStartDate) {
        this.tripStartDate = tripStartDate;
    }

    /**
     * Gets trip end date.
     *
     * @return the trip end date
     */
    public LocalDate getTripEndDate() {
        return tripEndDate;
    }

    /**
     * Sets trip end date.
     *
     * @param tripEndDate the trip end date
     */
    public void setTripEndDate(LocalDate tripEndDate) {
        this.tripEndDate = tripEndDate;
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

    /**
     * Gets trip name.
     *
     * @return the trip name
     */
    public String getTripName() {
            return tripName;
        }

    /**
     * Sets trip name.
     *
     * @param tripName the trip name
     */
    public void setTripName(String tripName) {
            this.tripName = tripName;
        }

    /**
     * Gets trip creator.
     *
     * @return the trip creator
     */
    public User getTripCreator() {
        return tripCreator;
    }

    /**
     * Sets trip creator.
     *
     * @param tripCreator the trip creator
     */
    public void setTripCreator(User tripCreator) {
        this.tripCreator = tripCreator;
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
        return "Trip{" +
                "location=" + location +
                ", tripName='" + tripName + '\'' +
                ", tripStartDate=" + tripStartDate +
                ", tripEndDate=" + tripEndDate +
                ", tripCreator=" + tripCreator +
                ", id=" + id +
                '}';
    }
}
