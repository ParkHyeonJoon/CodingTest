## <완전 탐색>
- 모든 경우 전부 탐색하는 방법
- 백 트래킹(Back Tracking)을 통해야 하는 상황 해결

👍: 부분점수 얻기 좋음. <br>
⚠️: 전부 탐색하기에 시간 복잡도 일반적으로 높음.


<t>기본 알고리즘 틀
```java
    // Recurrence Funtion(재귀함수)
    // 만약 M개를 전부 고름 -> 조건에 맞는 탐색을 한 가지 성공한 것!
    // 아직 M개를 고르지 않음 -> k 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
    static void rec_func(int k) {
        if(k == M + 1) { // 다 골랐다!
            // selected[1..M] 배열이 새롭게 탐색된 결과
            for(int i=1; i<=M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            for(int cand=1; cand <=N; cand++) {
                selected[k] = cand;

                // k+1번 ~ M번 을 모두 탐색하는 일을 해야 하는 상황
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }
```

재귀함수의 동작원리 : 내가 이해한 바로는 재귀함수는 그 안에서 동작이 끝날 때 까지 계속해서 깊게 들어가게 된다. 위 코드를 예로 들자면
rec_func에 1이 대입 되었고 차례대로 내려가다보면 rec_func(2)가 작동한다. 그 안에서 차례대로 내려가다보면 rec_func(3)이 작동된다.
그 때 재귀함수가 작동하지 않고 if(k == M + 1) 문에 들어간다면 rec_func(3)는 끝나게 된다. 그러면 rec_func(3)을 통해 얻은 값을
가진 채로 다시 rec_func(2)로 나오게 된다. 그리고 for문이 작동하여 selected[2]에 2가 대입되게 된다. 간단한 순서를 보여준다면<br>
`cand=1, rec_func(1) -> cand=1, rec_func(2) -> rec_func(3) -> cand=2, rec_func(2) -> rec_func(3) -> cand=2, rec_func(1)
-> cand=1, rec_func(2) -> rec_func(3) -> cand=2, rec_func(2) -> rec_func(3)`


4가지 유형 <br>
N개 중
- 1) 중복을 허용해서
    - A) M개를 순서 있게 나열하기 (BOJ 15651번)
      - 위에 기본 형식을 사용하면 풀 수 있다. 중복을 허용하고 순서있게 나열하는 문제.
      - 시간 복잡도 : O(N^M)
    - B) M개를 고르기 (BOJ 15652번)
      - start라는 변수를 하나 선언해준다. start는 selected[k-1] 로 선언을 해준다. 그리고 cand for문에서 cand의 값을 
        start로 선언해준다. 
      - 시간 복잡도 : O(N^M) 보다 작음
- 2) 중복없이
    - A) M개를 순서 있게 나열하기 (BOJ 15649번)
      - 중복 없이 사용하고 싶다면 전에 사용했던 숫자를 사용할 수 없다. 만약 N이 3이라고 가정한다면 첫 번째 자리에서 
        사용한 숫자가 무엇인지, 두 번째 자리에서 숫자를 사용하기 전에  확인해야 한다.
        - Simple version) boolean isUsed 를 선언하고 k까지 for문을 돌려 cand와 selected[i] 가 같으면 isUsed를 true로 선언해준다. 그리고
          isUsed가 false라면 전에 숫자와 중복되지 않다는 뜻이니 k번째에 cand가 올 수 있다는 걸 의미한다.
        - Advanced version) used 라는 1차원의 int 배열을 만든다. 크기는 N+1 만큼으로 선언한다. used[cand] 가 1이라면
          전에 숫자와 중복되는 것으로 바로 continue 한다. 1이 아니라면 전에 숫자가 중복되지 않는다는 뜻으로 밑에 로직을 실행하고
          used[cand]를 1로 설정해준다. used[] 배열의 인덱스 값을 통해 전에 숫자와 중복되는지 확인한다.
        - 시간 복잡도 : O(N! / (N - M)!)
    - B) M개를 고르기 (BOJ 15650번)
      - 전에 사용한 숫자보다 무조건 커야한다. cand 시작 값을 앞자리의 숫자 + 1 한 값으로 지정하면 겹치지 않고 무조건 하나 큰
        수 부터 시작할 수 있다. 
      - 시간 복잡도 : O(N! / M!(N - M)!) 


