package oop1.translator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Responder {
	private HashMap<String, String> englishToGerman;
	private ArrayList<String> errorResponses;
	private Random rnd;
	
	public Responder() {
		rnd = new Random();
		englishToGerman = new HashMap<>();
		fillEnglishToGerman();
		errorResponses = new ArrayList<>();
		fillErrorResponses();
	}

	private void fillEnglishToGerman() {
		englishToGerman.put("hello", "hallo");
		englishToGerman.put("saussage", "wurst");
		englishToGerman.put("beer", "bier");
		englishToGerman.put("table", "tisch");
		englishToGerman.put("chair", "stuhl");
		englishToGerman.put("i", "ich");
		englishToGerman.put("you", "du/sie");
		englishToGerman.put("the", "der/die/das");
		englishToGerman.put("work", "arbeit");
	}
	
	public String translate(String input) {
		String result = englishToGerman.get(input);
		if(result !=  null) {
			return "GERMAN: " + result;
		}

		return getErrorResponse();
	}

	public void fillErrorResponses() {
		// Adding responses to be used if no translation was found.
		errorResponses.add("I am sorry but I do not know how to translate this.");
		errorResponses.add("I don't know this word, sorry.");
		errorResponses.add("Are you sure that this is a word?");
		errorResponses.add("This cannot be translated.");
	}

	public String getErrorResponse() {
		// Pick a random number for the index in the error response list.
		// The number will be between 0 (inclusive) and the size of the list (exclusive).
		int idx = rnd.nextInt(errorResponses.size());
		return errorResponses.get(idx);
	}

}
