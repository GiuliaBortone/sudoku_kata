import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    void shouldReturnSolutionIsCorrect() {
        String originalMatrixInput = """
                5,3, , ,7, , , , ,
                6, , ,1,9,5, , , ,
                 ,9,8, , , , ,6, ,
                8, , , ,6, , , ,3,
                4, , ,8,5,3, , ,1,
                7, , , ,2, , , ,6,
                 ,6, , , , ,2,8, ,
                 , , ,4,1,9, , ,5,
                 ,4, , ,8, , ,7,9,""";

        String possibleSolutionMatrixInput = """
                5,3,4,6,7,8,9,1,2,
                6,7,2,1,9,5,3,4,8,
                1,9,8,3,4,2,5,6,7,
                8,5,9,7,6,1,4,2,3,
                4,2,6,8,5,3,7,9,1,
                7,1,3,9,2,4,8,5,6,
                9,6,1,5,3,7,2,8,4,
                2,8,7,4,1,9,6,3,5,
                3,4,5,2,8,6,1,7,9,""";

        App app = new App();
        assertEquals("The proposed solution is correct", app.solve(originalMatrixInput, possibleSolutionMatrixInput));
    }

    @Test
    void shouldReturnSolutionIsIncorrect() {
        String originalMatrixInput = """
                4,5,3,8,2,6,1,9,7,
                8,9,2,5,7,1,6,3,4,
                1,6,7,4,9,3,5,2,8,
                7,1,4,9,5,2,8,6,3,
                5,8,6,1,3,7,2,4,9,
                3,2,9,6,8,4,7,5,1,
                9,3,5,2,1,8,4,7,6,
                6,7,1,3,4,5,9,8,2,
                2,4,8,7,6,9,3,1,5,""";

        String possibleSolutionMatrixInput = """
                5,3,4,6,7,8,9,1,2,
                6,7,2,1,9,5,3,4,8,
                1,9,8,3,4,2,5,6,7,
                8,5,9,7,6,1,4,2,3,
                4,2,6,8,5,3,7,9,1,
                7,1,3,9,2,4,8,5,6,
                9,6,1,5,3,7,2,8,4,
                2,8,7,4,1,9,6,3,5,
                3,4,5,2,8,6,1,7,9,""";

        App app = new App();
        assertEquals("The proposed solution is incorrect", app.solve(originalMatrixInput, possibleSolutionMatrixInput));
    }
}
