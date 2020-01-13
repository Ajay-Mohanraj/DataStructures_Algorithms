class BlobMonster implements Comparable<BlobMonster> {
  int size;
  int numTeeth;
  boolean isPoisonous;
  
  public BlobMonster(int s, int n, boolean p) {
    size = s;
    numTeeth = n;
    isPoisonous = p;
  } 
  
  public boolean equals (Object o) {
    if (!(o instanceof BlobMonster))
      return false;
    
    BlobMonster other = (BlobMonster) o;
    
    return 
      (this.size == other.size) &&
      (this.numTeeth == other.numTeeth) &&
      (this.isPoisonous == other.isPoisonous);
  }
  
  public int compareTo (BlobMonster other) {
    if (this.isPoisonous != other.isPoisonous) {
      if (this.isPoisonous) { 
        return 1;
      }
      else { 
        return -1;
      }
    }
    
    int diff = this.size - other.size;
    if (diff != 0) { 
      return diff;
    }
  
    else {
      return this.numTeeth - other.numTeeth; 
    }
  }
  
  public static void main(String[] args) {
    BlobMonster a = new BlobMonster(50, 20, true);
    BlobMonster b = new BlobMonster(50, 20, false);
    BlobMonster c = new BlobMonster(40, 20, false);
    BlobMonster d = new BlobMonster(50, 10, false);
    BlobMonster e = new BlobMonster(50, 10, false);
    
    // Make sure equal monsters are equal and have a compareTo of 0.
    if (d.equals(e) && (d.compareTo(e) == 0)) 
      System.out.println("Passed 1");
    else
      System.out.println("Failed 1");

    // Poisonous is scarier
    if (!d.equals(a) && (d.compareTo(a) < 0)) 
      System.out.println("Passed 2");
    else
      System.out.println("Failed 2");

    // If both have the same poison property, size is next
    if (!d.equals(c) && (d.compareTo(c) > 0)) 
      System.out.println("Passed 4");
    else
      System.out.println("Failed 4");

    // If everything else is equal, teeth matter
    if (!d.equals(b) && (d.compareTo(b) < 0)) 
      System.out.println("Passed 3");
    else
      System.out.println("Failed 3");
    
    // Make sure that comparing against another object type returns false.
    if (!d.equals("Frog")) 
      System.out.println("Passed 5");
    else
      System.out.println("Failed 5");
  }
}
