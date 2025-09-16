package assignment.queue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountingGame {

	private static void playGame(String rhyme[], Queue<String> names) {

	}

	public static void main(String[] args) throws FileNotFoundException {
		Queue<String> names = new Queue<>();

		Scanner filein = new Scanner(new File("counting_game.txt"));

		String rhymeLine = filein.nextLine().trim();
		while (filein.hasNextLine()) {
			String name = filein.nextLine().trim();
			names.enqueue(name);
		}
		filein.close();

		String rhyme[] = rhymeLine.replaceAll("[^A-Za-z0-9\\s]+", "").split("\\s+");
		playGame(rhyme, names);
	}

}
