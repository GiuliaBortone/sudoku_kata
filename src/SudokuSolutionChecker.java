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
}
