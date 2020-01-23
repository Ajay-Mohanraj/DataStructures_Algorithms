package Unit6.Connect4;

import java.util.Scanner;

public class ConnectFour {
	// Player 0 is Red; Player 1 is Yellow
	// Use the following arrays to get a label or checker letter for the player.
	static String colorLabelCaps[] = { "Red", "Yellow" };
	static String colorLabel[] = { "red", "yellow" };
	static char colorChar[] = { 'R', 'Y' };

	public static void main(String[] args) {
		int player = 0;  // Player 0 is red; Player 1 is yellow.

		Board board = new Board();
		board.draw();
		Scanner input = new Scanner(System.in);

		// while there isn't a winner AND there isn't a draw
		while (board.checkWinner() == false && board.checkDraw() == false) {
			board.draw();
			System.out.print("-----------------\n");
			String color = player++ % 2 == 0 ? "red" : "yellow";
			System.out.printf("Drop a %s disk at column (0-6): ", color);
			int chooseColumn = input.nextInt();
			board.dropChecker(chooseColumn, color);
		}

		//
		// TODO: Once the program gets here, the game has either been won or ended in a draw.
		//   Determine which case is true and print out the final board along with a message
		//  to the user.
		//
	}
}
