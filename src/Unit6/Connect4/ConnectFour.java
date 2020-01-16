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
    Scanner input = new Scanner(System.in);
    
    while (board.checkWinner() == false && board.checkDraw() == false) {
      
      //
      // TODO: Write the main loop
      //
    }
    
    //
    // TODO: Once the program gets here, the game has either been won or ended in a draw.
    //   Determine which case is true and print out the final board along with a message 
    //  to the user.
    // 
  }
}
