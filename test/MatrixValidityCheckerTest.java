import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatrixValidityCheckerTest {
    @Test
    void matrixRespectingAllRulesIsValid() {
        int[][] matrixArray = {{1, 2, 3, 4}, {3, 4, 1, 2}, {2, 3, 4, 1}, {4, 1, 2, 3}};
        MatrixValidityChecker checker = new MatrixValidityChecker(new Matrix(matrixArray, 4, 4));

        assertTrue(checker.isMatrixValid());
    }

    @Test
    void matrixNotRespectingAllRulesIsNotValid() {
        int[][] matrixArray = {{1, 2, 3, 4}, {2, 1, 4, 3}, {3, 4, 1, 2}, {4, 3, 2, 1}};
        MatrixValidityChecker checker = new MatrixValidityChecker(new Matrix(matrixArray, 4, 4));

        assertFalse(checker.isMatrixValid());
    }
}
