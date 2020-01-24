package Unit6.Connect4;

/** Implements a ConnectFour board */
public class Board {
	static final int ROWS = 6; // The number of rows on the board.
	static final int COLUMNS = 7; // The number of columns on the board.

	// board is the instance variable that stores the actual board, a 2d-array of chars.
	// The possible characters stored in the board include:
	//  ' ' - Empty Space
	//  'R' - Red checker
	//  'Y' - Yellow checker
	public char[][] board;

	/** Constructor of a Board object.
	 *
	 * Instantiates the 'board' variable and initializes all of the cells to ' '.
	 */
	public Board() {
		this.board = new char[ROWS][COLUMNS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				board[i][j] = ' ';
			}
		}
	}

	/** Writes the current board to System.out, per the format in the assignment PDF. */
	public void draw() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				if (j == 0) {
					System.out.print("|" + board[i][j] + "|");
				}
				else {
					System.out.print( board[i][j] + "|");
				}
			}
			System.out.println();
		}
	}



	/** Attempts to drop the specified checker in the specified column.  If the checker is
	 * successfully dropped, the method adds the checker to the board variable and returns true.
	 * If the specified column is full, the method returns false.
	 */
	public boolean dropChecker(int column, String color) {
		char checker = color.equals("red") ? 'R' : 'Y';
		for (int i = ROWS-1; i >= 0; i--) {
			if (board[i][column] == ' ') {
				board[i][column] = checker;
				return true;
			}
		}
		return false;
	}

	/** Determines if the game has a winner.  The method returns true if either user
	 * has four in a row in any direction.
	 **/
	public boolean checkWinner() {

		return (checkVerticalWinner() || checkHorizontalWinner() || checkDiagonalWinner());
	}

	private boolean checkVerticalWinner() {
		for (int j = 0; j < COLUMNS; j++) {
			for (int i = 0; i <= ROWS-4; i++) {
				char hole1 = board[i][j];
				char hole2 = board[i+1][j];
				char hole3 = board[i+2][j];
				char hole4 = board[i+3][j];
				if (hole1 != ' ' && hole1 == hole2 && hole1 == hole3 && hole1 == hole4) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkHorizontalWinner() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j <= COLUMNS-4; j++) {
				char hole1 = board[i][j];
				char hole2 = board[i][j+1];
				char hole3 = board[i][j+2];
				char hole4 = board[i][j+3];
				if (hole1 != ' ' && hole1 == hole2 && hole1 == hole3 && hole1 == hole4) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkDiagonalWinner() {
		// for loops running through each block and checking the right and left (down) diagonals
		// exceptions handled in try and catch block implemented inside of a for loop
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {

				// checking right diagonal down DONE
				try {
					char hole1 = board[i][j];
					char hole2 = board[i+1][j+1];
					char hole3 = board[i+2][j+2];
					char hole4 = board[i+3][j+3];

					if (hole1 != ' ' && hole1 == hole2 && hole1 == hole3 && hole1 == hole4) {
						return true;
					}
				}
				catch (ArrayIndexOutOfBoundsException e) {

				}

				// checking left diagonal down DONE
				try {
					char hole1 = board[i][j];
					char hole2 = board[i+1][j-1];
					char hole3 = board[i+2][j-2];
					char hole4 = board[i+3][j-3];

					if (hole1 != ' ' && hole1 == hole2 && hole1 == hole3 && hole1 == hole4) {
						return true;
					}
				}
				catch (ArrayIndexOutOfBoundsException e) {

				}

				// checking left diagonal up DONE
				try {
					char hole1 = board[i][j];
					char hole2 = board[i-1][j-1];
					char hole3 = board[i-2][j-2];
					char hole4 = board[i-3][j-3];

					if (hole1 != ' ' && hole1 == hole2 && hole1 == hole3 && hole1 == hole4) {
						return true;
					}
				}
				catch (ArrayIndexOutOfBoundsException e) {

				}

				// checking right diagonal up
				try {
					char hole1 = board[i][j];
					char hole2 = board[i-1][j+1];
					char hole3 = board[i-2][j+2];
					char hole4 = board[i-3][j+3];

					if (hole1 != ' ' && hole1 == hole2 && hole1 == hole3 && hole1 == hole4) {
						return true;
					}
				}
				catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}
		return false;
	}

	/** Determines if the game is a draw.
	 * This method assumes the user already checked if there is a winner via a call to
	 * checkWinner. This method returns true if there are no more blank squares. */
	public boolean checkDraw() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
}

