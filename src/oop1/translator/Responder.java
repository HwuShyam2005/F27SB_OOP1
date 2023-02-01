package oop1.translator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
//CREATION OF STRINGS FOR THE 3 LANGUAGES
public class Responder {
	private HashMap<String, String> englishToGerman;
	private HashMap<String, String> englishToFrench;
	private HashMap<String, String> spanishToEnglish;
	private ArrayList<String> errorResponses;     
	private Random rnd;
	private int num;

//CREATION OF HASHMAPS FOR THE 3 LANGUAGES 
public Responder() {
	rnd = new Random();
	englishToGerman= new HashMap<>();
	  fillEnglishToGerman(); 
	spanishToEnglish = new HashMap<>();
	  fillSpanishToEnglish();    
    englishToFrench = new HashMap<>();
      fillEnglishToFrench();   
    errorResponses = new ArrayList<>();   
      fillErrorResponses();
    }
	
//ADDING WORDS IN ENGLISH AND THEIR GERMAN TRANSLATION WORD {CONVERSION 1}
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
//ADDING WORDS IN ENGLISH AND THEIR FRENCH TRANSLATION WORD {CONVERSION 2}    
private void fillEnglishToFrench() {
    englishToFrench.put("hello","salut");
	englishToFrench.put("saussage","saucisson");
	englishToFrench.put("beer","Bière");
	englishToFrench.put("table","tableau");
	englishToFrench.put("chair","chaise");
	englishToFrench.put("i","je");
	englishToFrench.put("you","vous");
	englishToFrench.put("the","le");
	englishToFrench.put("work","travail");
	englishToFrench.put("play","jouer");                // THE 2 UNIQUE WORDS
	englishToFrench.put("tree","arbre");
    	
    }
//ADDING WORDS IN SPANISH AND THEIR ENGLISH TRANSLATION WORD {CONVERSION 3}    
private void fillSpanishToEnglish() {
    spanishToEnglish.put("hola","hello");
   	spanishToEnglish.put("embutido","saussage");
   	spanishToEnglish.put("cerveza","beer");
    spanishToEnglish.put("mesa","table");
    spanishToEnglish.put("silla","chair");
    spanishToEnglish.put("i","i");
    spanishToEnglish.put("usted","you");
    spanishToEnglish.put("el","the");
    spanishToEnglish.put("trabaja","work");
    spanishToEnglish.put("tocar","play");               // THE 2 UNIQUE WORDS
   	spanishToEnglish.put("arbol","tree");
	}
//INITIALIZING NAMES FOR THE DIFFERENT TRANSLATIONS AND THE WORDS RECEIEVED
public String translate(String input) {
	   String result_German = englishToGerman.get(input);    
	   String result_French = englishToFrench.get(input); 
	   String result_English = spanishToEnglish.get(input); 
	   String resEng_German2 = englishToGerman.get(result_English); 
	   String resEng_French2 = englishToFrench.get(result_English); 
		
//THE IF AND ELSE IF CONDITION FOR PRINTING THE WORDS BASED ON THE WORDS PRESENT 
//IN EACH TRANSLATIONS 		
		if(result_German !=  null || result_French != null) {
			return "GERMAN WORD: " + result_German + "\nFRENCH WORD:" + result_French;
		}
		else if(result_English !=null){
			return "ENGLISH WORD:" + result_English + "\nGERMAN WORD:" + resEng_German2 + 
				   "\nFRENCH WORD" + resEng_French2;}
			 {
				 if(resEng_German2 !=  null || resEng_French2 != null) {
				 return "GERMAN WORD : " + resEng_German2 + "\nFRENCH WORD:" + resEng_French2;
				 }
			}
			  return getErrorResponse();
		}

//ADDING RESPONSES WHICH ARE USED WHEN THE TRANSLATION 
//IS NOT FORUND IN EITHER OF 3 TRANSLATIONS
public void fillErrorResponses() {
	errorResponses.add("I am sorry but I do not know how to translate this.");
	errorResponses.add("I don't know this word, sorry.");
	errorResponses.add("Are you sure that this is a word?");
	errorResponses.add("This cannot be translated.");
	}
	
//PICKING A RANDOM NUMBER FOR THE INDEX IN THE ERROR RESPONSE LIST.
//THE NUMBER WILL BE BETWEEN 0 (INCLUSIVE) AND THE SIZE OF THE GIVEN LIST (EXCLUSIVE)
public String getErrorResponse() {
	int idx = duplicateMessage();
	return errorResponses.get(idx);
	}
public int duplicateMessage() {
	int index;
	do {
		index = rnd.nextInt(errorResponses.size());
    }
	while(index == num);
	      num=index;
	return index;
   }
}

