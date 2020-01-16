package Unit6.Connect4;

/** Implements a ConnectFour board */
public class Board {
  static final int ROWS = 6; // The number of rows on the board.
  static final int COLUMNS = 7; // The number of columns on the board.

  // board is the instance variable that stores the actual board, a 2-array of chars.
  // The possible characters stored in the board include:
  //  ' ' - Empty Space
  //  'R' - Red checker
  //  'Y' - Yellow checker
  private char[][] board;

  /** Constructor of a Board object.
    *
    * Instantiates the 'board' variable and initializes all of the cells to ' '.
    */
  public Board() {
  }

  /** Writes the current board to System.out, per the format in the assignment PDF. */
  public void draw() {
  }

  /** Attempts to drop the specified checker in the specified column.  If the checker is
    * successfully dropped, the method adds the checker to the board variable and returns true.
    * If the specified column is full, the method returns false.
    */
  public boolean dropChecker(int column, char checker) {
    return false;
  }

  /** Determines if the game has a winner.  The method returns true if either user
    * has four in a row in any direction.
    **/
  public boolean checkWinner() {
    return false;
  }

  /** Determines if the game is a draw.
    * This method assumes the user already checked if there is a winner via a call to
    * checkWinner. This method returns true if there are no more blank squares. */
  public boolean checkDraw() {
    return false;
  }
}
