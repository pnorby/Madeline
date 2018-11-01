package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


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
      foreignKey = @ForeignKey(name = "trip_location_id_fk") )
    private Location location;

    @Column(name = "trip_name")
    private String tripName;

    @Column(name = "trip_start_date")
    private java.sql.Date tripStartDate;

    @Column(name = "trip_end_date")
    private java.sql.Date tripEndDate;


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
     */
    public Trip(Location location, String tripName, java.sql.Date tripStartDate, java.sql.Date tripEndDate) {
            this.location = location;
            this.tripName = tripName;
            this.tripStartDate = tripStartDate;
            this.tripEndDate = tripEndDate;

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
    public java.sql.Date getTripStartDate() {
        return tripStartDate;
    }

    /**
     * Sets trip start date.
     *
     * @param tripStartDate the trip start date
     */
    public void setTripStartDate(java.sql.Date tripStartDate) {
        this.tripStartDate = tripStartDate;
    }

    /**
     * Gets trip end date.
     *
     * @return the trip end date
     */
    public java.sql.Date getTripEndDate() {
        return tripEndDate;
    }

    /**
     * Sets trip end date.
     *
     * @param tripEndDate the trip end date
     */
    public void setTripEndDate(java.sql.Date tripEndDate) {
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


    @Override
    public String toString() {
        return "Trip{" +
                "location=" + location +
                ", tripName='" + tripName + '\'' +
                ", tripStartDate=" + tripStartDate +
                ", tripEndDate=" + tripEndDate +
                ", id=" + id +
                '}';
    }
}