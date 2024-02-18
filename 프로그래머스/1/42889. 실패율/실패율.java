import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] currentStage = new double[N+1]; // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
        double[] totalUser = new double[N+1]; // 스테이지에 도달한 플레이어 수
        
        for(int i=0; i<stages.length; i++) {
            currentStage[stages[i] - 1]++; // 1, 0, 1, 5, 1, 3, 2, 2 -> 1 3 2 1 0 1 
            // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
            for(int j=0; j<stages[i]; j++) {
                totalUser[j]++; // 0, 1 / 0 / 0,1 / 0,1,2,3,4,5 / 0,1 / 0,1,2,3 / 0,1,2 / 0,1,2 -> 8 7 4 2 1 0
                // 스테이지에 도달한 플레이어 수
            }
        }
        
        List<double[]> fail = new ArrayList<double[]>();
        
        for(int i=0; i<N; i++) {
            if(totalUser[i] == 0) {
                fail.add(new double[]{i,0});
            } else {
                fail.add(new double[]{i, currentStage[i] / totalUser[i]});
            }
        }
        
        fail.sort((a,b) -> Double.compare(b[1], a[1]));
        
        for(int i=0; i<fail.size(); i++) {
            answer[i] = (int)fail.get(i)[0]+1;
        }
        
        return answer;
        
        /*
        int[] fail = new int[N+2]; // N이 5이면 0~6
        for(int stage : stages) { // 2, 1, 2, 6, 2, 4, 3, 3
            fail[stage]++; // 각 스테이지에 멈춰있는 사람이 몇명인지 확인
            // fail = {0, 1, 3, 1, 2, 0, 1}
        }
        
        Double[] percent = new Double[N];
        int allPerson = stages.length; // 8
        
        for(int i=0; i<N; i++) {
            allPerson = allPerson - fail[i];
            percent[i] = (double)fail[i+1] / allPerson;
            // 1/8, 3/7, 2/4, 1/2, 0/1
        }
        int[] result = new int[N];
        Double[] copyPercent = Arrays.copyOf(percent, N);
        Arrays.sort(copyPercent, Collections.reverseOrder());
        // 2/4, 1/2, 7/3, 8/1, 0/1

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int finalJ = j+1;
                if(copyPercent[i].equals(percent[j]) && IntStream.of(result).noneMatch(x -> x == finalJ)) {
                    
                    result[i] = j+1; 
                    break;
                }
            }
        }
        return result;
        */
    }
}