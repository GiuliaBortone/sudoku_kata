import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SudokuSolutionCheckerTest {
    @Test
    void nonSquaredMatrixIsNotValid() {
        int rows = 4, columns = 3;
        SudokuSolutionChecker checker = new SudokuSolutionChecker();

        assertFalse(checker.isMatrixASquare(rows, columns));
    }

    @Test
    void squaredMatrixIsValid() {
        int rows = 3, columns = 3;
        SudokuSolutionChecker checker = new SudokuSolutionChecker();

        assertTrue(checker.isMatrixASquare(rows, columns));
    }

    @Test
    void matrixSizeNotSquareOfAnIntegerGreaterThan3IsNotValid() {
        int size = 3;
        SudokuSolutionChecker checker = new SudokuSolutionChecker();

        assertFalse(checker.isMatrixSizeValid(size));
    }

    @Test
    void matrixSizeSquareOfAnIntegerGreaterThan3IsValid() {
        int size = 9;
        SudokuSolutionChecker checker = new SudokuSolutionChecker();

        assertTrue(checker.isMatrixSizeValid(size));
    }

    @Test
    void matrixWithDuplicatesIsNotValid() {
        int[][] matrixArray = {{1, 2, 3, 4}, {2, 1, 4, 3}, {3, 4, 4, 2}, {4, 3, 2, 1}};
        SudokuSolutionChecker checker = new SudokuSolutionChecker();

        assertFalse(checker.hasNoDuplicatesInRowAndColumnAndSquare(matrixArray));
    }

    @Test
    void matrixWithNoDuplicatesIsValid() {
        int[][] matrixArray = {{1, 2, 3, 4}, {3, 4, 1, 2}, {2, 3, 4, 1}, {4, 1, 2, 3}};
        SudokuSolutionChecker checker = new SudokuSolutionChecker();

        assertTrue(checker.hasNoDuplicatesInRowAndColumnAndSquare(matrixArray));
    }
}
