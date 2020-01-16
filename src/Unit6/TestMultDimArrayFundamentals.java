package Unit6;

import java.util.Arrays;

public class TestMultDimArrayFundamentals extends MultiDimArrayFundamentals {
  
  public static void main (String[] args) {
    System.out.println("\n----------\nTesting fillWith:\n----------\n");
    
    int[][] a1 = {{1,2,3},{4,5},{6,7,8,9}};
    int[][] a1_c = {{3,3,3},{3,3},{3,3,3,3}};
    fillWith(a1, 3);
    printArray(a1);
    if (Arrays.deepEquals(a1, a1_c))
      System.out.println("Passes 1.");
    else{
      System.out.println("Fails 1, should print:");
      printArray(a1_c);
    }
    
    System.out.println("\n----------\nTesting numberEveryCell:\n----------\n");
    int[][] a2 = {{3,3,3},{3,3},{3,3,3,3}};
    int[][] a2_c = {{1,2,3},{4,5},{6,7,8,9}};
    numberEveryCell(a2);
    printArray(a2);
    if (Arrays.deepEquals(a2, a2_c))
      System.out.println("Passes 2.");
    else{
      System.out.println("Fails 2, should print:");
      printArray(a2_c);
    }
    
       
    System.out.println("\n----------\nTesting getValueRect:\n----------\n");
    int[][] a3 = {{-1,-2,-3},{-4,-5,-6},{-7,-8,-9}};
    boolean passes3 = true;
    for(int i = 0; i < 9; i++){
      if (getValueRect(a3, i) != ((-1) * i - 1)){
        System.out.printf("Fails 3: For the array below and pos: %d,  returns %d\n",i, getValueRect(a3, i));
        printArray(a3);
        passes3 = false;
        break;
      }
    }
    if (passes3){
      try{
        getValueRect(a3, 9);
        System.out.println("Fails 3: pos 9 does not throw an IndexOutOfBoundsException");
      }
      catch( IndexOutOfBoundsException ex){
        try{
          getValueRect(a3, -1);
          System.out.println("Fails 3: pos -1 does not throw an IndexOutOfBoundsException");
        }
        catch( IndexOutOfBoundsException ex2){
          System.out.println("Passes 3.");
        }
      }
    }
    
    
    
    System.out.println("\n----------\nTesting getValueJagged:\n----------\n");
    int[][] a4 = {{-1,-2,-3},{-4,-5,-6,-7},{-8,-9}};
    boolean passes4 = true;
    for(int i = 0; i < 9; i++){
      if (getValueJagged(a4, i) != ((-1) * i - 1)){
        System.out.printf("Fails 4: For the array below and pos: %d, returns %d\n",i, getValueJagged(a4, i));
        printArray(a4);
        passes4 = false;
        break;
      }
    }
    if (passes4){
      try{
        getValueJagged(a4, 9);
        System.out.println("Fails 4: pos 9 does not throw an IndexOutOfBoundsException");
      }
      catch( IndexOutOfBoundsException ex){
        try{
          getValueJagged(a4, -1);
          System.out.println("Fails 4: pos -1 does not throw an IndexOutOfBoundsException");
        }
        catch( IndexOutOfBoundsException ex2){
          System.out.println("Passes 4.");
        }
      }
    }
    
    System.out.println("\n----------\nTesting getRow:\n----------\n");
    int[][] a5 = {{0,1,2},{3,4,5,6},{7,8}};
    boolean passes5 = true;
    try {
      for(int i = 0; i < a5.length; i++){
        
        if (!Arrays.equals(a5[i], getRow(a5,i))){
          printArray(a5);
          System.out.printf("Fails 5: On the above array, getRow returns the following for row " + i + ":");
          printArray(new int[][]{getRow(a5,i)});
          passes5 = false;
          break;
        }
      }
      if(passes5){
        if(a5[0] == getRow(a5,0))
          System.out.println("Fails 5: Gets a shallow copy of row, not a deep copy");
        else
          System.out.println("Passes 5");
        
      }
    }
    catch(NullPointerException ex) {
      System.out.println("Fails 5: Null Pointer Exception (not implemented?)");
    }
    
    System.out.println("\n----------\nTesting getCol:\n----------\n");
    int[][] a6 = {{0,1,2},
            {3,4,5,10},
            {6,7,8}};
    try{
      boolean passes6 = true;
      for(int i = 0; i < a6[0].length; i++){
        
        if (!Arrays.equals(new int[]{a6[0][i],a6[1][i],a6[2][i]}, getCol(a6,i))){
          printArray(a6);
          System.out.printf("Fails 6: On the above array, getCol returns the following for col " + i + ":");
          printArray(new int[][]{getCol(a5,i)});
          passes6 = false;
          break;
        }
      }
      
      if(passes6){
        System.out.println("Passes 6.");
      }
    }
    catch(NullPointerException ex) {
      System.out.println("Fails 6: Null Pointer Exception (not implemented?)");
    }
    
    System.out.println("\n----------\nTesting reshape:\n----------\n");
    try{
      int[] a7 = {1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12};
      int[][] a7_c1 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
      int[][] a7_c2 = {{1,2},{3,4},{5,6},{7,8},{9,10},{11,12}};
      System.out.println("Original 1d array:");
      printArray(new int[][]{a7});
      System.out.println("Reshaping:");
      printArray(reshape(a7,3));
      if (Arrays.deepEquals(reshape(a7,3), a7_c1))
        System.out.println("Passes 7a.");
      else{
        System.out.println("Fails 7a, should print:");
        printArray(a7_c1);
      }
      System.out.println("Reshaping:");
      printArray(reshape(a7,2));
      if (Arrays.deepEquals(reshape(a7,2), a7_c2))
        System.out.println("Passes 7b.");
      else{
        System.out.println("Fails 7b, should print:");
        printArray(a7_c2);
      }
      try{
        reshape(a7,5);
        System.out.println("Fails 7c, should throw IllegalArgumentException for :");
        
      }
      catch (IllegalArgumentException ex){
        System.out.println("Passes 7c.");
      }
    }
    catch(NullPointerException ex) {
      System.out.println("Fails 7a/b/c: Null Pointer Exception (not implemented?)");
    }
    
    System.out.println("\n----------\nTesting flatten:\n----------\n");
    
    try{
      int[][] a8_1 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
      int[][] a8_2 = {{1,2},{3,4},{5,6},{7,8},{9,10},{11,12}};
      int[][] a8_3 = {{1,2,3},{4},{5,6},{7,8,9,10},{11,12}};
      int[] a8_c = {1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12};
      
      if (Arrays.equals(flatten(a8_1), a8_c))
        System.out.println("Passes 8a.");
      else{
        printArray(a8_1);
        System.out.println("Fails 8a, flattens above array as:");      
        printArray(new int[][]{flatten(a8_1)});
      }
      
      if (Arrays.equals(flatten(a8_2), a8_c))
        System.out.println("Passes 8b.");
      else{
        printArray(a8_2);
        System.out.println("Fails 8b, flattens above array as:");      
        printArray(new int[][]{flatten(a8_2)});
      }
      
      if (Arrays.equals(flatten(a8_3), a8_c))
        System.out.println("Passes 8c.");
      else{
        printArray(a8_3);
        System.out.println("Fails 8c, flattens above array as:");      
        printArray(new int[][]{flatten(a8_3)});
      }
    }
    catch(NullPointerException ex) {
      System.out.println("Fails 8a/b/c: Null Pointer Exception (not implemented?)");
    }
    
    System.out.println("\n----------\nTesting packRows:\n----------\n");
    try {
      int[] a9_1 = {1, 2, 3};
      int[] a9_2 = {4, 5, 6, 7};
      int[][] a9_sol = {{1,2,3},{4,5,6,7}};
      if(Arrays.deepEquals(a9_sol, packRows(a9_1, a9_2))){
        if(packRows(a9_1, a9_2)[0] == a9_1 || packRows(a9_1, a9_2)[1] == a9_2 )
          System.out.println("Sort of Fails 9: Gets a shallow copy of row, not a deep copy");
        else
          System.out.println("Passes 9.");
      }
      else{
        printArray(new int[][]{a9_1,a9_2});
        System.out.println("Fails 9: Given the two rows above, packRows returns below:");
        printArray(packRows(a9_1, a9_2));
      }
    }
    catch(NullPointerException ex) {
      System.out.println("Fails 9: Null Pointer Exception (not implemented?)");
    }
    
  }
}
