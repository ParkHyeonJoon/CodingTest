class Solution {
    public String solution(int n) {
//         StringBuilder answer = new StringBuilder();

//         recursive(n, answer);
        
//         return answer.reverse().toString();
//     }
    
//     private void recursive(int n, StringBuilder answer) {
//         int remainder = n % 3;
        
//         if (n <= 3) {
//             answer.append(remainder == 0 ? "4" : String.valueOf(remainder));
//             return;
//         }
        
//         answer.append(remainder == 0 ? "4" : String.valueOf(remainder));
//         recursive(n / 3, answer);
//     }
        
      String[] num = {"4","1","2"};
      String answer = "";

      while(n > 0){
          answer = num[n % 3] + answer;
          n = (n - 1) / 3;
      }
      return answer;
  } 
}