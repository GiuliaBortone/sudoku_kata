public class App {
    MatrixParser parser = new MatrixParser();

    public String solve(String originalMatrixInput, String possibleSolutionMatrixInput) {
        SudokuSolutionChecker checker = new SudokuSolutionChecker(parser.extractMatrixFrom(originalMatrixInput));

        if (checker.isAValidSolution(parser.extractMatrixFrom(possibleSolutionMatrixInput))) {
            return "The proposed solution is correct";
        } else {
            return "The proposed solution is incorrect";
        }
    }
}
