import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int m = arr1.length;        // arr1의 행 수
        int n = arr1[0].length;     // arr1의 열 수이자 arr2의 행 수
        int p = arr2[0].length;     // arr2의 열 수

        // 결과 행렬 초기화
        int[][] result = new int[m][p];

        // 행렬 곱셈 수행
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }
}