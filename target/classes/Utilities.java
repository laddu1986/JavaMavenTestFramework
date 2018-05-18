package resources;

import java.util.Date;

public class Utilities {

	public static String getTestAccount() {

		String timestamp = String.valueOf(new Date().getTime());
		String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
		return email;
	}

}
