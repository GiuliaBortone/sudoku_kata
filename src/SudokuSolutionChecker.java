public class SudokuSolutionChecker {
    private final Matrix originalMatrix;

    public SudokuSolutionChecker(Matrix original) {
        this.originalMatrix = original;
    }

    public boolean isAValidSolution(Matrix possibleSolution) {
        MatrixValidityChecker checker = new MatrixValidityChecker(possibleSolution);

        return checker.isMatrixValid() && areOriginalNumbersStillPresentIn(possibleSolution);
    }

    private boolean areOriginalNumbersStillPresentIn(Matrix possibleSolution) {
        for (int row = 0; row < originalMatrix.rows(); row++) {
            for (int column = 0; column < originalMatrix.columns(); column++) {
                if (originalMatrix.array()[row][column] != 0 && originalMatrix.array()[row][column] != possibleSolution.array()[row][column]) {
                    return false;
                }
            }
        }
        return true;
    }
}
