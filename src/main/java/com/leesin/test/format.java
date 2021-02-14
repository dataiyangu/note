package com.leesin.test;

public class format {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid == null || obstacleGrid.length == 0) {
                return 1;
            }

            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] result = new int[m][n];

            for (int i = 0; i < m; i++) {
                if (obstacleGrid[i][0] != 1) {
                    result[i][0] = 1;
                } else {
                    break;
                }
            }

            for (int i = 0; i < n; i++) {
                if (obstacleGrid[0][i] != 1) {
                    result[0][i] = 1;
                } else {
                    break;
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] != 1) {
                        result[i][j] = result[i - 1][j] + result[i][j - 1];
                    } else {
                        result[i][j] = 0;
                    }
                }
            }

            return result[m - 1][n - 1];
        }
    }
}
