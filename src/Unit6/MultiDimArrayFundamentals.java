package Unit6;

public class MultiDimArrayFundamentals {
    /**
     * Print the 2d array in row major order.
     * Works with jagged arrays.
     * Format each int to print with 4 characters.
     */
    public static void printArray(int[][] ma) {
        for (int i = 0; i < ma.length; i++) {
            for (int k = 0; k < ma[i].length; k++) {
                System.out.printf("%4d", ma[i][k]);
            }
            System.out.println();
        }
    }


    /**
     * Fill 2d array with int "fill"
     * Works with jagged arrays.
     */
    public static void fillWith(int[][] ma, int fill) {
        for (int i = 0; i < ma.length; i++) {
            for (int k = 0; k < ma[i].length; k++) {
                ma[i][k] = fill;
            }
        }
    }


    /**
     * Fill 2d array with ascending numbers starting from 1;
     * Works with jagged arrays.
     */
    public static void numberEveryCell(int[][] ma) {
        int numCount = 1;
        for (int i = 0; i < ma.length; i++) {
            for (int k = 0; k < ma[i].length; k++) {
                ma[i][k] = numCount;
                numCount++;
            }
        }
    }

    /**
     * Creates and returns a deep copy of the passed array 'oldArr'
     */
    // deep copy is another copy of the array so the user can change it but it won't affect the original

    public static int[][] deepCopy(int[][] oldArr) {
        int[][] newArr = new int[oldArr.length][];
        for (int i = 0; i < oldArr.length; i++) {
            newArr[i] = new int[oldArr[i].length];
            for (int k = 0; k < oldArr[i].length; k++) {
                newArr[i][k] = oldArr[i][k];
            }
        }
        return newArr;
    }


    /**
     * Get the value of 2d arr at pos, the index if arr was
     * "flattened" or read in row-major order.
     * If no such position, throw an IndexOutOfBoundsException
     * ONLY works for rectangular arrays
     * <p>
     * Example: if arr = {{14, 15, 16},{1,5,9},{18,7,6}}
     * getValueRect(arr, 3) returns 1
     * getValueRect(arr, 5) returns 9
     * getValueRect(arr, 9) throws an exception
     */
    public static int getValueRect(int[][] arr, int pos) {


        int row = pos / arr[0].length;
        if (row < 0 || row > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        int column = pos % arr[0].length;

        return arr[row][column];

    }

    /**
     * Get the value of 2d arr at pos, the index if arr was
     * "flattened" or read in row-major order.
     * If no such position, throw an IndexOutOfBoundsException
     * NOTE: Works for jagged arrays
     * <p>
     * This function is conceptually the same as getValueRect, however,
     * the implementation is a bit more complex.
     */
    public static int getValueJagged(int[][] arr, int pos) {

        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[i].length; k++) {
                if (pos == 0) {
                    return arr[i][k];
                }
                pos--;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * Gets (copy of) row from 2d arr
     * Works for jagged arrays.
     * Must create a deep copy of the row.
     * <p>
     * If "row" is invalid, the method throws an ArrayIndexOutOfBoundsException.
     */
    public static int[] getRow(int[][] arr, int row) {
        if (row < 0 || row > arr.length) {
            throw new IndexOutOfBoundsException();
        }

        int[] array = new int[arr[row].length];
        for (int j = 0; j < arr[row].length; j++) {
            array[j] = arr[row][j];
        }
        return array;
    }

    /**
     * Gets (copy of) column from 2d arr
     * Won't work for jagged arrays if any row's length is < col
     * <p>
     * If "col" is invalid, the method throws an ArrayIndexOutOfBoundsException.
     */
    public static int[] getCol(int[][] arr, int col) {

        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (col > arr[i].length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            array[i] = arr[i][col];
        }
        return array;
    }

    /**
     * Reshapes arr (1d) into a rectangular array with row length of "rowLength"
     * If arr's length is not divisible by rowLength, throws an
     * IllegalArgumentException
     */
    public static int[][] reshape(int[] arr, int rowLength) {
        if (arr.length % rowLength != 0) {
            throw new IllegalArgumentException();
        }
        int[][] array = new int[arr.length / rowLength][rowLength];
        int pos = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < rowLength; j++) {
                array[i][j] = arr[pos++];
            }
        }
        return array;
    }

    /**
     * Flattens arr (2d) into a 1d array, elements in row-major order.
     * Works even with jagged arrays!
     */
    public static int[] flatten(int[][] arr) {
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                length++;
            }
        }
        int[] array = new int[length];
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                array[pos++] = arr[i][j];
            }
        }
        return array;
    }

    /**
     * Creates a 2d array that has two rows with the contents of row1 and row2.
     * This method must perform a deep copy of the contents of row1 and row2.
     */
    public static int[][] packRows(int[] row1, int[] row2) {
        //int[][] arr = {row1, row2};
        //return deepCopy(arr);

        int[][] arr = new int[2][];
        arr[0] = new int[row1.length];
        arr[1] = new int[row2.length];


        for (int j = 0; j < row1.length; j++) {
            arr[0][j] = row1[j];
        }
        for (int j = 0; j < row2.length; j++) {
            arr[1][j] = row2[j];
        }

        return arr;
    }


    public static void main(String[] args) {
        int[][] sample = {{9, 14, 2}, {3, 8}, {45, 31, -4, 2}};

        System.out.println("printArray Test");
        printArray(sample);

        System.out.println("\nfillWith Test");
        fillWith(sample, 3);
        printArray(sample);

        System.out.println("\nnumberEveryCell Test");
        numberEveryCell(sample);
        printArray(sample);

        System.out.println("\ndeepCopy Test");
        int[][] copiedSample = deepCopy(sample);
        sample[0][1] = 15;

        System.out.println("Sample changed:");
        printArray(sample);
        System.out.println("Copied sample not changed:");
        printArray(copiedSample);

    }
}