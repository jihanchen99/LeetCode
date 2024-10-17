public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        /*
        LeetCode 59
        Given a positive integer n, generate an n * n matrix filled with
        elements from 1 to n^2 in spiral order
         */
        int[][] res = new int[n][n];
        int startX = 0, startY = 0;
        int offset = 1;
        int count = 1;
        int loop = 1;
        int i, j;

        while (loop <= n / 2) {
            // top row
            for (j = startY; j < n - offset; j++) {
                res[startX][j] = count++;
            }

            // right column
            for (i = startX; i < n - offset; i++) {
                res[i][j] = count++;
            }

            // bottom row
            for (j = n - offset; j > startY; j--) {
                res[i][j] = count++;
            }

            // left column
            for (i = n - offset; i > startX; i--) {
                res[i][j] = count++;
            }

            // update coordinates
            startX ++;
            startY++;
            offset++;
            loop++;
        }
        if (n % 2 == 1) {
            res[startX][startY] = n*n;
        }

        return res;
    }
}
