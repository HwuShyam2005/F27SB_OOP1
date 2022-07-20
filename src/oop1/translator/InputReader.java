package oop1.translator;

import java.util.Scanner;

public class InputReader {
	private Scanner scanner;
	
	public InputReader() {
		scanner = new Scanner(System.in);
	}
	
	public String getInput() {
		System.out.print("> ");                // print prompt
		String in = scanner.nextLine();
		return in.trim().toLowerCase();        // removing leading and trailing spaces and turning everything to lower case
	}
}
