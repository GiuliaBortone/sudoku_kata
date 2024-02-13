import java.util.Arrays;

public class SudokuSolutionChecker {
    public boolean isMatrixASquare(int rows, int columns) {
        return rows == columns;
    }

    public boolean isMatrixSizeValid(int size) {
        int n = 2;
        while (n * n < size) {
            n++;
        }

        return (n * n == size) && (n * n > 3);
    }

    public boolean doesMatrixHaveDuplicateInLine(int[][] matrixArray, int size) {
        for (int row = 0; row < size; row++) {
            int[] matrixRow = matrixArray[row];

            if (Arrays.stream(matrixRow).distinct().count() < size) {
                return false;
            }
        }

        return true;
    }
}
