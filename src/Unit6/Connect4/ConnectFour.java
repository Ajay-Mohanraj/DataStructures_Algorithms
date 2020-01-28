package Unit6.Connect4;

import java.util.Scanner;

public class ConnectFour {
	// Player 0 is Red; Player 1 is Yellow

	public static void main(String[] args) {
		int player = 0;  // Player 0 is red; Player 1 is yellow.

		Board board = new Board();
		Scanner input = new Scanner(System.in);
		String color = " ";

		// while there isn't a winner AND there isn't a draw
		while (board.checkWinner() == false && board.checkDraw() == false) {
			board.draw();
			System.out.println("-----------------\n");
			color = player++ % 2 == 0 ? "red" : "yellow";
			System.out.printf("Drop a %s disk at column (0-6): ", color);
			int chosenColumn = input.nextInt();
			boolean columnEmpty = board.dropChecker(chosenColumn, color);
			if (!columnEmpty) {
				System.out.println("\nColumn is full. Please enter a different column");
				player--;
			}
		}

		if (board.checkDraw()) {
			System.out.println("\nThe game ended in a draw.");
		}

		else {
			System.out.println("\n" + color + " wins!");
		}

		System.out.println("Here is the final board: ");
		board.draw();
	}
}
