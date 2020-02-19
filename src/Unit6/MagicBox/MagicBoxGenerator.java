package Unit6.MagicBox;

import Unit6.MultiDimArrayFundamentals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBoxGenerator {
	public static int solutionCount = 0;

	private static void generateMagicBox_v1(ArrayList<int[][]> solutions, int[][] box, int pos) {
		int rows = box.length;
		int cols = box[0].length;

		if (pos >= rows * cols) {
			solutionCount++;
			if (solutionCount % 1000000 == 0) {
				System.out.println("tried solution " + solutionCount);
			}
			if (MagicBoxChecker.isSolution(box)) {
				solutions.add(MultiDimArrayFundamentals.deepCopy(box));
			}
			return;
		}

		int row = pos / cols;
		int col = pos % cols;

		for (int num = 1; num <= rows * cols; num++) {
			box[row][col] = num;
			generateMagicBox_v1(solutions, box, pos+1);
		}
		box[row][col] = 0;
	}

	public static ArrayList<int[][]> generateMagicBox_v1(int rows, int columns) {
		ArrayList<int[][]> solutions = new ArrayList<>();
		generateMagicBox_v1(solutions, new int[rows][columns], 0);
		return solutions;
	}
	private static void generateMagicBox_v2(ArrayList<int[][]> solutions, int[][] box, int pos, boolean[] used) {
		int rows = box.length;
		int cols = box[0].length;

		if (pos >= rows * cols) {
			solutionCount++;
			if (solutionCount % 1000000 == 0) {
				System.out.println("tried solution " + solutionCount);
			}
			if (MagicBoxChecker.isSolution(box)) {
				solutions.add(MultiDimArrayFundamentals.deepCopy(box));
			}
			return;
		}

		int row = pos / cols;
		int col = pos % cols;

		for (int num = 1; num <= rows * cols; num++) {
			if (used[num]) {
				continue;
			}
			used[num] = true;
			box[row][col] = num;
			generateMagicBox_v2(solutions, box, pos+1, used);
			used[num] = false;
		}
		box[row][col] = 0;
	}

	public static ArrayList<int[][]> generateMagicBox_v2(int rows, int columns) {
		ArrayList<int[][]> solutions = new ArrayList<>();

		boolean[] used = new boolean[rows*columns+1];

		generateMagicBox_v2(solutions, new int[rows][columns], 0, used);
		return solutions;
	}

	private static void generateMagicBox_v3(ArrayList<int[][]> solutions, int[][] box, int pos, boolean[] used, int rowSum, int targetRowSum) {

		int rows = box.length;
		int cols = box[0].length;

		if (pos >= rows * cols) {
			solutionCount++;
			if (solutionCount % 1000000 == 0) {
				System.out.println("tried solution " + solutionCount);
			}
			if (MagicBoxChecker.isSolution(box)) {
				solutions.add(MultiDimArrayFundamentals.deepCopy(box));
			}
			return;
		}

		int row = pos / cols;
		int col = pos % cols;
		boolean endOfRow = (col == cols - 1);

		for (int num = 1; num <= rows * cols; num++) {
			if (used[num]) {
				continue;
			}
			if (num + rowSum > targetRowSum) {
				break;
			}
			if (endOfRow && (rowSum + num != targetRowSum)) {
				continue;
			}
			used[num] = true;
			box[row][col] = num;
			generateMagicBox_v3(solutions, box, pos+1, used, endOfRow ? 0 : rowSum+num, targetRowSum);
			used[num] = false;
		}
		box[row][col] = 0;
	}

	public static ArrayList<int[][]> generateMagicBox_v3(int rows, int columns) {
		ArrayList<int[][]> solutions = new ArrayList<>();
		int n = rows * columns;
		int sum = n * (n+1) / 2;
		int targetRowSum = sum / rows;

		boolean[] used = new boolean[rows*columns+1];

		generateMagicBox_v3(solutions, new int[rows][columns], 0, used, 0, targetRowSum);
		return solutions;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Rows?");
		int rows = input.nextInt();

		System.out.println("Columns?");
		int columns = input.nextInt();

		ArrayList<int[][]> solutions = generateMagicBox_v3(rows, columns);
		System.out.println(solutions.size() + " solutions");

		for (int[][] solution : solutions) {
			System.out.println();
			MultiDimArrayFundamentals.printArray(solution);
		}

		System.out.println("Total solutions tried: " + solutionCount);

	}
}
