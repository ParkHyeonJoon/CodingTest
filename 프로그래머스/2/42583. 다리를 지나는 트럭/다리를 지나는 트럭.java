import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0; 
        int weightSum = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for(int i=0; i<truck_weights.length; i++) {
            int truck = truck_weights[i];
            
            while(true) {
                if(bridge.isEmpty()) { // 큐(다리)가 아예 비어있을 경우
                    bridge.add(truck); // 큐에 트럭을 하나 추가, 다리에 트럭 한 대 올라감
                    weightSum += truck; // 다리 위에 올라가있는 트럭의 총 무게
                    time++; // 1초 흐른다
                    break;
                } else if(bridge.size() == bridge_length) {
                    weightSum -= bridge.poll();
                } else {
                    if(weightSum + truck <= weight) {
                        bridge.add(truck);
                        weightSum += truck;
                        time++;
                        break;
                    } else {
                        bridge.add(0);
                        time++;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}