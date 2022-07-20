package oop1.translator;

public class TranslationSystem {
	private InputReader reader;
	private Responder responder;

	/**
	 * Creates a technical support system.
	 */
	public TranslationSystem() {
		reader = new InputReader();
		responder = new Responder();
	}

	/**
	 * Start the translation system. This will print a welcome message and enter
	 * into a dialog with the user, until the user ends the dialog.
	 */
	public void start()
	{
		boolean finished = false;
		printWelcome();

		System.out.println();
		System.out.println("Please, type in a single word to translate it.");

		while(!finished) {
			String input = reader.getInput();

			if(input.contains("quit")) {
				finished = true;
			}
			else {
				String response = responder.translate(input);
				System.out.println(response);
			}
		}
		printGoodbye();
	}

	/**
	 * Print a welcome message to the screen.
	 */
	private void printWelcome()
	{
		System.out.println("Welcome to the DodgySoft Translation System.");
		System.out.println();
		System.out.println("This system translates everything you type in.");
		System.out.println("Just type in a single word and press enter to see the translation.");
		System.out.println("Please type 'quit' to exit our system.");
	}

	/**
	 * Print a good-bye message to the screen.
	 */
	private void printGoodbye()
	{
		System.out.println("Auf Wiedersehen!");
	}

	public static void main(String[] args) {
		TranslationSystem ts = new TranslationSystem();
		ts.start();

	}

}
