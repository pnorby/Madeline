package controller;

import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.*;

import com.mailjet.client.resource.Contact;
import com.mailjet.client.resource.Email;
import entity.Trip;
import entity.User;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


import static com.mailjet.client.resource.Email.resource;

/**
 * A servlet to send email invitations
 * @author pnorby
 */

@WebServlet(
        urlPatterns = {"/sendInvite"}
)

public class SendInviteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        MailjetClient client;
        MailjetRequest request;
        MailjetResponse response;
        User inviteSender;
        GenericDao<Trip> tripDao = new GenericDao<>(Trip.class);
        GenericDao<User> userDao = new GenericDao<>(User.class);
        String tripId = req.getParameter("tripId");
        int theId = 0;
        Trip theTrip;
        String senderName = "";
        Boolean sendIt = false;

        String theRecipient = req.getParameter("recipient");
        String recipientEmail = "";
        String returnToTrip = "";
        String responseMessage = "There was an error sending your invitation, please try again or contact an administrator";

        try{
           System.out.println("made it into send email servlet");

            client = new MailjetClient(System.getenv("1cbd843a91f3fe6333b051557f200656"), System.getenv("956e34cece8d391082163a41743fd2c6"));


            if(strCheck(tripId) && strCheck(theRecipient) ){
                theId = Integer.parseInt(tripId);
                theTrip = tripDao.getById(theId);
                recipientEmail = theRecipient;
                inviteSender = theTrip.getTripCreator();
                senderName = (inviteSender.getFirstName() + " " + inviteSender.getLastName());
                sendIt = true;
            }


            //send email invitation;

            if(sendIt){
                request = new MailjetRequest(Email.resource);

                request.property(Email.FROMEMAIL, "pnorby@madisoncollege.edu").property(Email.HTMLPART, "<h3><a href='Madeline/joinTrip?recipientEmail=" + recipientEmail + "&trip=" + tripId + "'>Click here to join this trip!</a></h3><br />").property(Email.RECIPIENTS, new JSONArray().put(new JSONObject().put("Email", recipientEmail)));


                response = client.post(request);
                System.out.println(response.getStatus());
                System.out.println(response.getData());
                /*JSONObject message = new JSONObject();
                message.put(Emailv31.Message.FROM, new JSONObject()
                        .put(Emailv31.Message.EMAIL, "pnorby@madisoncollege.edu")
                        .put(Emailv31.Message.NAME, "Madeline Invitation")
                )
                        .put(Emailv31.Message.SUBJECT, "You've been invited on a trip!")
                        .put(Emailv31.Message.TEXTPART, "Dear guest, you've been invited on a trip by " + senderName)
                        .put(Emailv31.Message.HTMLPART, "<a href='Madeline/joinTrip?recipientEmail=" + recipientEmail + "&trip=" + tripId + "'>Click here to join this trip!</a>")
                        .put(Emailv31.Message.TO, new JSONArray()
                        .put(new JSONObject()
                        .put(Emailv31.Message.EMAIL, recipientEmail)));
                email = new MailjetRequest(Emailv31.resource).property(Emailv31.MESSAGES, (new JSONArray()).put(message));

                response = client.post(email);*/
                System.out.println("made it into sendIt");
                System.out.println(recipientEmail);

                //JSONArray recipients;


                //recipients = new JSONArray().put(new JSONObject().put(Contact.EMAIL, recipientEmail));
                //System.out.println(recipients);

                //email = new MailjetRequest(Email.resource).property(Email.FROMNAME, senderName).property(Email.FROMEMAIL, "pnorby@madisoncollege.edu").property(Email.SUBJECT, "You've been invited on a trip by" + senderName).property(Email.TEXTPART, "Paste this link into your browser! LINK " + "http://localhost:8080/Madeline/joinTrip?recipientEmail=" + recipientEmail + "&trip=" + tripId).property(Email.RECIPIENTS, recipients).property(Email.MJCUSTOMID, "JAVA-Email");
                //System.out.println(email);

                //response = client.post(email);



                responseMessage = "Invitation Sent!";
            } else {
                responseMessage = "Failed to send email! Please contact an administrator if problem persists!";
            }


            resp.setHeader("Refresh", "3; URL=tripController?select=" + theId);
            resp.setContentType("text/html");
            PrintWriter out  = resp.getWriter();
            out.print("<h1>" + responseMessage + "</h1>");
            out.close();



        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    private Boolean strCheck(String s){
        Boolean passes = false;

        if(s != null && !s.isEmpty()) {
            passes = true;
        }

        return passes;
    }
}
