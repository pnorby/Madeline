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
        @Column(name = "trip_location_id")
        private int locationId;
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
         * @param tripName the trip name
         * @param locationId the id of the location of the trip
         * @param tripStartDate the date the trip begins
         * @param tripEndDate the date the trip ends
         * @param id the id of the trip
         *
         */
        public Trip(String tripName, int locationId, LocalDate tripStartDate, LocalDate tripEndDate, int id) {
            this.tripName = tripName;
            this.locationId = locationId;
            this.tripStartDate = tripStartDate;
            this.tripEndDate = tripEndDate;
            this.id = id;
        }
}
