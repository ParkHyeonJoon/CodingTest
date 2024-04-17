class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int n = priorities.length;
        boolean[] printed = new boolean[n];
        
        while (true) {
            boolean printedNow = false;
            for (int i = 0; i < n; i++) {
                if (!printed[i]) {
                    boolean biggerExist = false;
                    for (int j = 0; j < n; j++) {
                        if (!printed[j] && priorities[j] > priorities[i]) {
                            biggerExist = true;
                            break;
                        }
                    }
                    if (!biggerExist) {
                        answer++;
                        printedNow = true;
                        printed[i] = true;
                        if (i == location) {
                            return answer;
                        }
                    }
                }
            }
            if (!printedNow) {
                break;
            }
        }
        
        return answer;
    }
}
