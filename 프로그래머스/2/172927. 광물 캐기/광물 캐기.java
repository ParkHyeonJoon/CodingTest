import java.util.*;


class Solution {
    public int solution(int[] picks, String[] minerals) {
        int loop = Math.min(minerals.length/5 + 1, picks[0]+picks[1]+picks[2]);
        int[][] stresszone = new int[loop][3];
        int dia = 0; int iro = 0; int sto = 0;
        int answer = 0;
        
        for(int i=0; i<minerals.length; i+=5) {
            if(i/5 == loop) {
                break;
            }
            for(int j=i; j<5+i; j++) {
                String s = minerals[j];
                if(s.equals("diamond")) {
                    dia += 1;
                    iro += 5;
                    sto += 25;
                } else if(s.equals("iron")) {
                    dia += 1;
                    iro += 1;
                    sto += 5;
                } else if(s.equals("stone")) {
                    dia += 1;
                    iro += 1;
                    sto += 1;
                }
                if(j == minerals.length-1) break;
            
            }
            stresszone[i/5][0] = dia;
            stresszone[i/5][1] = iro;
            stresszone[i/5][2] = sto;
        
            dia = iro = sto = 0;
        }
    
        Arrays.sort(stresszone, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2]; // 피로도를 기준으로 내림차순 정렬
            }
        });
    
        for(int i=0; i<loop; i++) {
            if(picks[0] != 0) {
                answer += stresszone[i][0];
                 picks[0]--;
            }
             else if(picks[1] != 0) {
                  answer += stresszone[i][1];
                 picks[1]--;
          }
             else if(picks[2] != 0) {
               answer += stresszone[i][2];
               picks[2]--;
            }
        }
    
        return answer;
    }
}