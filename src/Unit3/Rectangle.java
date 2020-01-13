package Unit3;

public class Rectangle {
  private int length;
  private int width;
  
  public Rectangle (int length, int width) {
    this.length = length;
    this.width = width;
  }
}
  
  /* 
   * Implement equals.
   * 
   * Two Rectangles are equal if they have the same dimensions.  Note that a 
   * rotation of the rectangle does not effect its equality.  That is, a
   * 5 x 3 rectangle is equal to a 3 x 5 rectangle.
   */

  
  /* Implement compareTo
   * 
   * Rectangles are first sorted by area.  Rectangles with a larger area 
   * are "bigger".
   * 
   * Rectangles are then sorted by perimeter.  Rectangles with a larger 
   * perimeter are "bigger".  
   * 
   * Rectangles with an both equal area and perimeter are equal.
   * 
   */
  
  