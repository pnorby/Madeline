package utilities;

import entity.Message;
import entity.Trip;
import persistence.GenericDao;

import java.util.List;
import java.util.Set;

public class TripMessageUtil {
    private Trip trip;
    GenericDao<Trip> tripDao = new GenericDao<>(Trip.class);
    GenericDao<Message> messageDao = new GenericDao<>(Message.class);


    public TripMessageUtil(Trip trip){
        this.trip = trip;
    }

    public List<Message> getWebViewMessages(){
        Set<Message> webViewMessages = null;
        List<Message> tripMessages = null;

        try{
            tripMessages = messageDao.getMostRecentTen(trip);

        }
        catch(Exception e){

        }

        return tripMessages;
    }


}
