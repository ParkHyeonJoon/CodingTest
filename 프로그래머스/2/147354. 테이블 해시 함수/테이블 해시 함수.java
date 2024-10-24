import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        // 정렬을 위한 비교자 생성
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[col - 1] == o2[col - 1]) {
                    return Integer.compare(o2[0], o1[0]);
                }
                return o1[col - 1] - o2[col - 1];
            }
        };

        // 데이터 정렬
        Arrays.sort(data, comparator);

        // 해시 값 계산
        for (int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;
            for (int j = 0; j < data[0].length; j++) {
                sum += data[i][j] % (i + 1);
            }
            answer = (answer ^ sum);
        }

        return answer;
    }
}