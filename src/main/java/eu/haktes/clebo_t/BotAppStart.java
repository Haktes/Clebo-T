package eu.haktes.clebo_t;

import java.util.Scanner;

/**
 * Start here
 */
public class BotAppStart {

	public static void main(String[] args) {
		System.out.println("Bot selection");

		Scanner sc = new Scanner(System.in);

		System.out.println("0 - Standart bot");
		System.out.println("1 - Tester bot...");
		System.out.println("2 - Petrov skusobny bot");
		System.out.println("Select Bot instance:");
		String choice = sc.nextLine();

		switch (choice) {
		case "0": {
			Bot bot = new Bot();
			bot.start();
			break;
		}
		case "1": {
			BotTester botTester = new BotTester();
			botTester.start();
			break;
		}
		case "2": {
			BotPeter botPeter = new BotPeter();
			botPeter.start();
			break;
		}
		default: {
			System.out.println("Nope!");
			break;
		}
		}

	}
}
