import java.util.Arrays;

public class MatrixValidityChecker {
    private final Matrix matrix;

    public MatrixValidityChecker(Matrix matrix) {
        this.matrix = matrix;
    }

    public boolean isMatrixValid() {
        return isMatrixASquare() && isMatrixSizeValid() && hasNoDuplicatesInRowAndColumnAndSquare();
    }

    private boolean isMatrixASquare() {
        return matrix.rows() == matrix.columns();
    }

    private boolean isMatrixSizeValid() {
        int n = 2;
        while (n * n < matrix.rows()) {
            n++;
        }

        return (n * n == matrix.rows()) && (n * n > 3);
    }

    private boolean hasNoDuplicatesInRowAndColumnAndSquare() {
        return hasNoDuplicatesInRow()
                && hasNoDuplicatesInColumn()
                && hasNoDuplicatesInSquares();
    }

    private boolean hasNoDuplicatesInRow() {
        int size = matrix.rows();

        for (int row = 0; row < size; row++) {
            int[] matrixRow = matrix.array()[row];

            if (arrayWithNoDuplicatesSize(matrixRow) < size) {
                return false;
            }
        }

        return true;
    }

    private boolean hasNoDuplicatesInColumn() {
        int size = matrix.rows();

        for (int column = 0; column < size; column++) {
            int[] matrixColumn = extractColumnArray(column);

            if (arrayWithNoDuplicatesSize(matrixColumn) < size) {
                return false;
            }
        }

        return true;
    }

    private int[] extractColumnArray(int column) {
        int size = matrix.rows();

        int[] matrixColumn = new int[size];
        for (int row = 0; row < size; row++) {
            matrixColumn[row] = matrix.array()[row][column];
        }
        return matrixColumn;
    }

    private boolean hasNoDuplicatesInSquares() {
        int numberOfSquaresAndMatrixSize = matrix.rows();

        for (int square = 0; square < numberOfSquaresAndMatrixSize; square++) {
            int[] squareArray = extractSquareArray(numberOfSquaresAndMatrixSize, square);

            if (arrayWithNoDuplicatesSize(squareArray) < numberOfSquaresAndMatrixSize) {
                return false;
            }
        }

        return true;
    }

    private int[] extractSquareArray(int numberOfSquaresAndMatrixSize, int square) {
        int squaresSize = (int) Math.sqrt(numberOfSquaresAndMatrixSize);
        int[] squareArray = new int[numberOfSquaresAndMatrixSize];
        int arrayLength = 0;

        for (int i = square / 2 * squaresSize; i < (square / 2 + 1) * squaresSize; i++) {
            for (int j = square % 2 * squaresSize; j < (square % 2 + 1) * squaresSize; j++) {
                squareArray[arrayLength] = matrix.array()[i][j];
                arrayLength++;
            }
        }
        return squareArray;
    }

    private long arrayWithNoDuplicatesSize(int[] array) {
        return Arrays.stream(array).distinct().count();
    }
}
