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
        int squareSize = (int) Math.sqrt(matrix.rows());

        for (int i = 0; i < matrix.rows(); i += squareSize) {
            for (int j = 0; j < matrix.columns(); j += squareSize) {
                int[] square = extractSquare(matrix.array(), i, j, squareSize);
                if (arrayWithNoDuplicatesSize(square) < matrix.rows()) {
                    return false;
                }
            }
        }

        return true;
    }

    private int[] extractSquare(int[][] matrix, int startX, int startY, int size) {
        int[] square = new int[size * size];
        int index = 0;
        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                square[index++] = matrix[i][j];
            }
        }
        return square;
    }

    private long arrayWithNoDuplicatesSize(int[] array) {
        return Arrays.stream(array).distinct().count();
    }
}
