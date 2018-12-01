package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * A class to represent a location.
 *
 * @author pnorby
 */
@Entity(name = "Location")
@Table(name = "location")
public class Location {
    @Column(name = "location_name")
    private String locationName;
    @Column(name = "location_address")
    private String locationAddress;
    @Column(name = "location_city")
    private String locationCity;
    @Column(name = "location_state")
    private String locationState;
    @Column(name = "location_zip")
    private String locationZip;
    @Column(name = "location_description")
    private String locationDescription;
    @Column(name="location_type")
    private String locationType;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Trip> trips = new HashSet<>();

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;


    /**
     * Instantiates a new Location.
     */
    public Location() {
    }

    /**
     * Instantiates a new Location.
     *
     * @param locationName    the location name
     * @param locationAddress the address of the location
     * @param locationCity    the location city
     * @param locationState   the location state
     * @param locationZip     the location zip
     * @param locationDescription the description of the location
     * @param locationType    the type of location
     */
    public Location(String locationName, String locationAddress, String locationCity, String locationState, String locationZip, String locationDescription, String locationType) {
        this.locationName = locationName;
        this.locationAddress = locationAddress;
        this.locationCity = locationCity;
        this.locationState = locationState;
        this.locationZip = locationZip;
        this.locationDescription = locationDescription;
        this.locationType = locationType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets location name.
     *
     * @return the location name
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * Gets location type.
     *
     * @return the location type
     */
    public String getLocationType() {
        return locationType;
    }

    /**
     * Sets location type.
     *
     * @param locationType the location type
     */
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    /**
     * Sets location name.
     *
     * @param locationName the location name
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * Gets location address.
     *
     * @return the location address
     */
    public String getLocationAddress() {
        return locationAddress;
    }

    /**
     * Sets location address.
     *
     * @param locationAddress the location address
     */
    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    /**
     * Gets location city.
     *
     * @return the location city
     */
    public String getLocationCity() {
        return locationCity;
    }

    /**
     * Sets location city.
     *
     * @param locationCity the location city
     */
    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    /**
     * Gets location state.
     *
     * @return the location state
     */
    public String getLocationState() {
        return locationState;
    }

    /**
     * Sets location state.
     *
     * @param locationState the location state
     */
    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    /**
     * Gets location zip.
     *
     * @return the location zip
     */
    public String getLocationZip() {
        return locationZip;
    }

    /**
     * Sets location zip.
     *
     * @param locationZip the location zip
     */
    public void setLocationZip(String locationZip) {
        this.locationZip = locationZip;
    }

    /**
     * Gets trips.
     *
     * @return the trips
     */
    public Set<Trip> getTrips() {
        return trips;
    }

    /**
     * Gets location description.
     *
     * @return the location description
     */
    public String getLocationDescription() {
        return locationDescription;
    }

    /**
     * Sets location description.
     *
     * @param locationDescription the location description
     */
    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    /**
     * Sets trips.
     *
     * @param trips the trips
     */
    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }

    /**
     * Add a trip.
     *
     * @param trip the trip to add
     */
    public void addTrip(Trip trip) {
        trips.add(trip);
        trip.setLocation( this );
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationName='" + locationName + '\'' +
                ", locationAddress='" + locationAddress + '\'' +
                ", locationCity='" + locationCity + '\'' +
                ", locationState='" + locationState + '\'' +
                ", locationZip='" + locationZip + '\'' +
                ", locationDescription='" + locationDescription + '\'' +
                ", locationType='" + locationType + '\'' +
                ", trips=" + trips +
                ", id=" + id +
                '}';
    }
}
