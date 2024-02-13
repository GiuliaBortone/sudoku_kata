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

    public boolean hasNoDuplicatesInLine(int[][] matrixArray, int size) {
        for (int row = 0; row < size; row++) {
            int[] matrixRow = matrixArray[row];

            if (Arrays.stream(matrixRow).distinct().count() < size) {
                return false;
            }
        }

        return true;
    }

    public boolean hasNoDuplicatesInColumn(int[][] matrixArray, int size) {
        for (int column = 0; column < size; column++) {
            int[] matrixColumn = new int[size];
            for (int row = 0; row < size; row++) {
                matrixColumn[row] = matrixArray[row][column];
            }

            if (Arrays.stream(matrixColumn).distinct().count() < size) {
                return false;
            }
        }

        return true;
    }
}
