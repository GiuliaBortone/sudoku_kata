import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}
