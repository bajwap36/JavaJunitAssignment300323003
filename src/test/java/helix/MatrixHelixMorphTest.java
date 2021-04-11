package helix;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class MatrixHelixMorphTest {

    /** Check if two integer matrices have the same contents
     *
     * @param matrix1
     * @param matrix2
     * @return true if the contents of matrix1 and matrix2 are identical and false otherwise
     */
    public static boolean testEqual(int[][] matrix1, int[][] matrix2) {

        /*
            Basic sanity checking:
                Verify that lengths are equal
         */
        if (matrix1 == null || matrix2 == null) {
            return true;
        }
        if (matrix1.length != matrix2.length) {
            return false;
        }
        if (matrix1.length > 0) {if (matrix1[0].length != matrix2[0].length) {
            return false;
        }}

        /*
            Test the contents of the matrices
         */
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    //Test1
    @Test
    public void test2x2() {
        int[][] inMatrix  = { {1, 2}, {3, 4} };
        int[][] expOutput = { {1, 2}, {4, 3} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    //Test2
    @Test
    public void test1x1() {
        int[][] inMatrix  = { {1} };
        int[][] expOutput = { {1} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    //Test3
    @Test
    public void test3x3() {
        int[][] inMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expOutput = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    //Test4
    @Test
    public void test4x4() {
        int[][] inMatrix = {{9, 3, 1, 4, 6}, {3, 2, 7, 1, 8}, {8, 3, 2, 4, 1}, {10, 11, 15, 19, 14}};
        int[][] expOutput = {{9, 3, 1, 4, 6}, {4, 1, 10, 11, 3}, {2, 14, 19, 15, 2}, {3, 8, 8, 1, 7}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    //Test5
    @Test
    public void test5x5() {
        int[][] inMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
        int[][] expOutput = {{1, 2, 3}, {12, 13, 4}, {11, 14, 5}, {10, 15, 6}, {9, 8, 7}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    //Test6
    @Test
    public void test1x2() {
        int[][] inMatrix = {{1, 2}};
        int[][] expOutput = {{1, 2}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    //Test7
    @Test
    public void test2x1() {
        int[][] inMatrix = {{1}, {2}};
        int[][] expOutput = {{1}, {2}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    //Test8
    @Test
    public void testInvalid() {
        int[][] inMatrix = {{1, 2}, {3, 4, 5}, {6, 7}};
        int[][] expOutput = null;
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    //Test9
    @Test
    public void testNull() {
        int[][] inMatrix = null;
        int[][] expOutput = null;
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    //Test10
    @Test
    public void testEmpty() {
        int[][] inMatrix = {};
        int[][] expOutput = {};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }
}
