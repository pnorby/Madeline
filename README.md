# Paul Norby's Individual Project

### Problem Statement

Every year my family (and extended family) takes a vacation to a campground.  Many email chains and group text messages are created to communicate thoughts and coordination surrounding
the trip.  This application will serve as a single source of information and communication to facilitate better planning and centralize communication.

### Project Technologies/Techniques 

* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Admin role: create/read/update/delete (crud) of all data
  * User role: select a campground, a date, possibly manage supplies
  * All: 
* Database
  * MySQL
  * users and roles
  * Store all data for the trip
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  * NOAA for weather conditions at a campsite or other location
* CSS 
  * Bootstrap 
* Data Validation
  * Bootstrap Validator for front end
  
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Hosting
  * AWS
* Independent Research Topic/s
  * CI tools in AWS
  * Materialize
  * Google Maps API
  * Hibernate Validation
  * Hibernat Search
* Project Lombok to eliminate boilerplate code like getters/setters/equals
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage 
* IDE: IntelliJ IDEA