public class MatrixParser {

    public Matrix extractMatrixFrom(String input) {
        String[] rows = input.trim().split("\n");
        int numRows = rows.length;
        int numCols = rows[0].split(",").length;
        int[][] matrixArray = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            String[] nums = rows[i].split(",");
            for (int j = 0; j < numCols; j++) {
                if (nums[j].equals(" ")) {
                    matrixArray[i][j] = 0;
                    continue;
                }
                matrixArray[i][j] = Integer.parseInt(nums[j].trim());
            }
        }

        return new Matrix(matrixArray, numRows, numCols);
    }
}
