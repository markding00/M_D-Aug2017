/*
 * Mark Ding
 * Ms.Dreyer
 * APCS1 11/07/2017
 * This class mainly has the response of what would the robot say if the user type some certain words or random words.
 */
public class Magpie2 {

	//Get a default greeting and return a greeting	
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * takes in a user statement
	 * returns a response based on given rules
	 */
	public String getResponse(String statement) {
		String response = "";
		if (statement.indexOf("no") >= 0) {
			response = "Why so negative?";
		} else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0) {
			response = "Tell me more about your family.";
		} else if(statement.indexOf("Dreyer") >= 0) {
			response = "She sounds like a good teacher.";
		} else if(statement.indexOf("jokes") >= 0) {
			response = "I'm not a humorous person.";
		} else if(statement.indexOf("study") >= 0) {
			response = "Study is the easiest thing in the world.";
		} else if(statement.indexOf("name") >= 0){
			response = "My name is Mark Ding. And I have a robot friend called Sam Ding.";
		} else if(statement.trim().length() <= 0) {
			response = "Say something, please.";
		} else {
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * returns a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		} else if(whichResponse == 4) {
			response = "Well, that's right.";
		} else if(whichResponse == 5) {
			response = "Can we switch the topic?";
		}

		return response;
	}
}
