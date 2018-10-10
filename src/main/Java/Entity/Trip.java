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
        private LocalDate tripStartDate;

        @Column(name = "trip_end_date")
        private LocalDate tripEndDate;

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
     * @param location   the id of the location of the trip
     * @param tripStartDate the date the trip begins
     * @param tripEndDate   the date the trip ends
     * @param id            the id of the trip
     */
    public Trip(String tripName, Location location, LocalDate tripStartDate, LocalDate tripEndDate, int id) {
            this.tripName = tripName;
            this.location = location;
            this.tripStartDate = tripStartDate;
            this.tripEndDate = tripEndDate;
            this.id = id;
        }

    /**
     * Gets location id.
     *
     * @return the location id
     */
    public Location getLocation() {
            return location;
        }

    /**
     * Sets location id.
     *
     * @param location the location
     */
    public void setLocation(Location location) {
            this.location = location;
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
