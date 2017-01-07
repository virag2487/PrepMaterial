package com.test;

//Install the Java helper library from twilio.com/docs/java/install
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Example {
	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "ACf4b44f88f17ece4f0761233fcf3186f0";
	public static final String AUTH_TOKEN = "your_auth_token";

	public static void main(String[] args) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message message = Message
				.creator(new PhoneNumber("+15558675309"), new PhoneNumber("+15017250604"),
						"This is the ship that made the Kessel Run in fourteen parsecs?")
				.setMediaUrl("https://c1.staticflickr.com/3/2899/14341091933_1e92e62d12_b.jpg")
				.create();

		System.out.println(message.getSid());
	}
}

