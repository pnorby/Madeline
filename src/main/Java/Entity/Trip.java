package Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.*;


/**
 * A class to represent a trip.
 *
 * @author pnorby
 */
@Entity(name = "Trip")
    @Table(name = "trip")
    public class Trip {


        @ManyToOne
        private Location location;

        @Column(name = "trip_name")
        private String tripName;

        @Column(name = "trip_start_date")
        private String tripStartDate;

        @Column(name = "trip_end_date")
        private String tripEndDate;

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
        @GenericGenerator(name = "native",strategy = "native")
        private int id;

    /**
     * Instantiates a new User.
     */
    public Trip() {
        }

    /**
     * Instantiates a new User.
     *
     * @param tripName      the trip name
     * @param tripStartDate the date the trip begins
     * @param tripEndDate   the date the trip ends
     */
    public Trip(String tripName, String tripStartDate, String tripEndDate) {
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
     * Sets trip start date.
     *
     * @param tripStartDate the trip start date
     */
    public void setTripStartDate(String tripStartDate) {
        this.tripStartDate = tripStartDate;
    }

    /**
     * Sets trip end date.
     *
     * @param tripEndDate the trip end date
     */
    public void setTripEndDate(String tripEndDate) {
        this.tripEndDate = tripEndDate;
    }


    /**
     * Gets trip start date.
     *
     * @return the trip start date
     */
    public String getTripStartDate() {
        return tripStartDate;
    }

    public String getTripEndDate() {
        return tripEndDate;
    }

    public int getId() {
        return id;
    }

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
