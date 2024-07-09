class Solution {
    public int solution(int number, int limit, int power) {
        /*
        주어진 number까지의 약수의 개수를 배열에 담는다
        하나씩 limit와 비교한다
        limit를 넘지 않으면 sum에 그대로 더한다
        limit를 넘는다면 sum에 power를 더한다
        sum을 출력
        */
        int answer = 0;
        int[] arr = new int[number+1];
        for(int i=1; i<=number; i++) {
            /*for(int j=1; j<=i; j++) {
                if(i%j == 0) {
                    arr[i]++;
                }
            }*/
            for(int j=1; j*j<=i; j++) {
                if(j*j == i) arr[i]++;
                else if(i%j == 0) arr[i] += 2;
            }
            if(arr[i] <= limit) {
                answer += arr[i];
            }
            if(arr[i] > limit) {
                answer += power;
            }
        }
        
        return answer;
    }
}