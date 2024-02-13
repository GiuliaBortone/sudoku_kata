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

    public boolean hasNoDuplicatesInLine(int[][] matrixArray) {
        int size = matrixArray[0].length;

        for (int row = 0; row < size; row++) {
            int[] matrixRow = matrixArray[row];

            if (Arrays.stream(matrixRow).distinct().count() < size) {
                return false;
            }
        }

        return true;
    }

    public boolean hasNoDuplicatesInColumn(int[][] matrixArray) {
        int size = matrixArray[0].length;

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

    public boolean hasNoDuplicatesInSquares(int[][] matrixArray) {
        int numberOfSquaresAndMatrixSize = matrixArray[0].length;
        int squaresSize = (int) Math.sqrt(numberOfSquaresAndMatrixSize);

        for (int square = 0; square < numberOfSquaresAndMatrixSize; square++) {
            int[] squareArray = new int[numberOfSquaresAndMatrixSize];
            int arrayLength = 0;

            for (int i = square / 2 * squaresSize; i < (square / 2 + 1) * squaresSize; i++) {
                for (int j = square % 2 * squaresSize; j < (square % 2 + 1) * squaresSize; j++) {
                    squareArray[arrayLength] = matrixArray[i][j];
                    arrayLength++;
                }
            }

            if (Arrays.stream(squareArray).distinct().count() < numberOfSquaresAndMatrixSize) {
                return false;
            }
        }

        return true;
    }
}
