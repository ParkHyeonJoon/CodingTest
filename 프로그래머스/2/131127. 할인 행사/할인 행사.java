import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        int totalCount = 0; // 원하는 총 제품 수량

        // map 초기화 및 총 제품 수량 계산
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
            totalCount += number[i];
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> tempMap = new HashMap<>(map);
            int count = 0; // 할인된 제품 수량

            // 10일 동안 할인된 제품 확인
            for (int j = i; j < i + 10; j++) {
                if (tempMap.containsKey(discount[j])) {
                    int remaining = tempMap.get(discount[j]) - 1;
                    if (remaining >= 0) {
                        tempMap.put(discount[j], remaining);
                        count++;
                    }
                }
            }

            // 모든 제품을 할인받을 수 있는지 확인
            if (count == totalCount) {
                answer++;
            }
        }

        return answer;
    }
}