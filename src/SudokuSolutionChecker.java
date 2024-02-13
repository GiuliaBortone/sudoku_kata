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

    public boolean hasNoDuplicatesInRowAndColumnAndSquare(int[][] matrixArray) {
        return hasNoDuplicatesInRow(matrixArray)
                && hasNoDuplicatesInColumn(matrixArray)
                && hasNoDuplicatesInSquares(matrixArray);
    }

    private boolean hasNoDuplicatesInRow(int[][] matrixArray) {
        int size = matrixArray[0].length;

        for (int row = 0; row < size; row++) {
            int[] matrixRow = matrixArray[row];

            if (arrayWithNoDuplicatesSize(matrixRow) < size) {
                return false;
            }
        }

        return true;
    }

    private boolean hasNoDuplicatesInColumn(int[][] matrixArray) {
        int size = matrixArray[0].length;

        for (int column = 0; column < size; column++) {
            int[] matrixColumn = extractColumnArray(matrixArray, size, column);

            if (arrayWithNoDuplicatesSize(matrixColumn) < size) {
                return false;
            }
        }

        return true;
    }

    private static int[] extractColumnArray(int[][] matrixArray, int size, int column) {
        int[] matrixColumn = new int[size];
        for (int row = 0; row < size; row++) {
            matrixColumn[row] = matrixArray[row][column];
        }
        return matrixColumn;
    }

    private boolean hasNoDuplicatesInSquares(int[][] matrixArray) {
        int numberOfSquaresAndMatrixSize = matrixArray[0].length;

        for (int square = 0; square < numberOfSquaresAndMatrixSize; square++) {
            int[] squareArray = extractSquareArray(matrixArray, numberOfSquaresAndMatrixSize, square);

            if (arrayWithNoDuplicatesSize(squareArray) < numberOfSquaresAndMatrixSize) {
                return false;
            }
        }

        return true;
    }

    private int[] extractSquareArray(int[][] matrixArray, int numberOfSquaresAndMatrixSize, int square) {
        int squaresSize = (int) Math.sqrt(numberOfSquaresAndMatrixSize);
        int[] squareArray = new int[numberOfSquaresAndMatrixSize];
        int arrayLength = 0;

        for (int i = square / 2 * squaresSize; i < (square / 2 + 1) * squaresSize; i++) {
            for (int j = square % 2 * squaresSize; j < (square % 2 + 1) * squaresSize; j++) {
                squareArray[arrayLength] = matrixArray[i][j];
                arrayLength++;
            }
        }
        return squareArray;
    }

    private long arrayWithNoDuplicatesSize(int[] matrixRow) {
        return Arrays.stream(matrixRow).distinct().count();
    }
}
