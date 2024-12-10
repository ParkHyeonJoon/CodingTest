import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);

        int left = 1;
        int right = distance;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(getRemoveRockCount(rocks, mid, distance) <= n) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public int getRemoveRockCount(int[] rocks, int mid, int distance) {
        int start = 0;
        int end = distance;

        int removeCnt = 0;
        for(int i=0; i<rocks.length; i++) {
            if(rocks[i] - start < mid) {
                removeCnt++;
                continue;
            }
            start = rocks[i];
        }
        if(end - start < mid) removeCnt++;

        return removeCnt;
    }
}