<form method="GET" action="adminUpdateLocation">
    <label for="lName">Name:</label>
    <input type="text" id="lName" name="locationName" placeholder="${theLocation.locationName}"/>
    <br/>
    <label for="lAddress">Address:</label>
    <input type="text" id="lAddress" name="address" placeholder="${theLocation.locationAddress}"/>
    <br/>
    <label for="lCity">City:</label>
    <input type="text" id="lCity" name="city" placeholder="${theLocation.locationCity}"/>
    <br/>
    <label for="lState">State:</label>
    <input type="text" id="lState" name="state" placeholder="${theLocation.locationState}"/>
    <br/>
    <label for="lZip">Zip:</label>
    <input type="text" id="lZip" name="zip" placeholder="${theLocation.locationZip}"/>
    <br/>
    <label for="lDescription">Description:</label>
    <input type="textarea" id="lDescription" name="description" placeholder="${theLocation.locationDescription}"/>
    <br/>
    <label for="lType">Type:</label>
    <input type="text" id="lType" name="type" placeholder="${theLocation.locationType}"/>

    <br/>
    <input type="hidden" type="text" name="locationId" value="${theLocation.id}"/>
    <button type="submit">Submit</button>
</form>
