package helix;

public class MatrixHelixMorph {

    /**
     * @param inMatrix
     * @return a matrix that is morphed into a helix version of inMatrix
     */
    public static int[][] helix(int[][] inMatrix) {

        if (inMatrix == null) return null;

        //Row and Column Length
        int rowLen = inMatrix.length;
        int colLen = 0;

        if (rowLen > 0) {
            colLen = inMatrix[0].length;

            // Check if Matrix is valid i.e, if every row and column length is same
            for (int i = 1; i < inMatrix.length; i++) {
                if (colLen != inMatrix[i].length) {
                    return null;
                }
            }
        }


        int[][] outMatrix = new int[rowLen][colLen];  //creating an outMatrix

        int outMatrixRowIndex = 0;
        int outMatrixColumnIndex = 0;
        int inMatrixRowIndex = 0;
        int inMatrixColumnIndex = 0;

        while (outMatrixRowIndex < rowLen && outMatrixColumnIndex < colLen) {

            //first row
            for (int i = outMatrixColumnIndex; i < colLen; ++i) {
                outMatrix[outMatrixRowIndex][i] = inMatrix[inMatrixRowIndex][inMatrixColumnIndex];

                if (inMatrixColumnIndex == inMatrix[0].length - 1) {
                    inMatrixRowIndex++;
                    inMatrixColumnIndex = 0;
                } else {
                    inMatrixColumnIndex++;
                }
            }
            outMatrixRowIndex++;

            //last column
            for (int i = outMatrixRowIndex; i < rowLen; ++i) {
                outMatrix[i][colLen - 1] = inMatrix[inMatrixRowIndex][inMatrixColumnIndex];

                if (inMatrixColumnIndex == inMatrix[0].length - 1) {
                    inMatrixRowIndex++;
                    inMatrixColumnIndex = 0;
                } else {
                    inMatrixColumnIndex++;
                }
            }
            colLen--;


            //last row
            if (outMatrixRowIndex < rowLen) {
                for (int i = colLen - 1; i >= outMatrixColumnIndex; --i) {
                    outMatrix[rowLen - 1][i] = inMatrix[inMatrixRowIndex][inMatrixColumnIndex];

                    if (inMatrixColumnIndex == inMatrix[0].length - 1) {
                        inMatrixRowIndex++;
                        inMatrixColumnIndex = 0;
                    } else {
                        inMatrixColumnIndex++;
                    }
                }
                rowLen--;
            }

            //first column
            if (outMatrixColumnIndex < colLen) {
                for (int i = rowLen - 1; i >= outMatrixRowIndex; --i) {
                    outMatrix[i][outMatrixColumnIndex] = inMatrix[inMatrixRowIndex][inMatrixColumnIndex];

                    if (inMatrixColumnIndex == inMatrix[0].length - 1) {
                        inMatrixRowIndex++;
                        inMatrixColumnIndex = 0;
                    } else {
                        inMatrixColumnIndex++;
                    }
                }

                outMatrixColumnIndex++;

            }
        }
        return outMatrix;

    }
}