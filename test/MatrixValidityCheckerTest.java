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

    @Test
    void matrix9x9RespectingAllRulesIsValid() {
        Matrix matrix = new Matrix(new int[][]{
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        }, 9, 9);

        MatrixValidityChecker checker = new MatrixValidityChecker(matrix);

        assertTrue(checker.isMatrixValid());
    }

    @Test
    void matrix9x9NotRespectingAllRulesIsNotValid() {
        Matrix matrix = new Matrix(new int[][]{
                {5, 3, 4, 5, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        }, 9, 9);

        MatrixValidityChecker checker = new MatrixValidityChecker(matrix);

        assertFalse(checker.isMatrixValid());
    }
}
