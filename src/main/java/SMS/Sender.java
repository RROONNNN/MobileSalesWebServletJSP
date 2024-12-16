package SMS;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import Config.ConfigOfTwilio;

public class Sender {
	  private final TwilioRestClient client;

	    public Sender() {
	        client = new TwilioRestClient.Builder(ConfigOfTwilio.accountSID, ConfigOfTwilio.AuthToken).build();
	    }

	    public Sender(TwilioRestClient client) {
	        this.client = client;
	    }

	    public void send(String to, String message) {
	        new MessageCreator(
	                new PhoneNumber(to),
	                new PhoneNumber(ConfigOfTwilio.PhoneNumber),
	                message
	        ).create(client);
	    }
	    
   public static void main(String[] args) {
	   String phonenum="0359185374";
		System.out.println("+84"+phonenum.substring(1));
}
}
