import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int A = arrayA[0]; int B = arrayB[0];
        for(int i=1; i<arrayA.length; i++) {
            A = gcd(arrayA[i], A);
            if(A == 1)
                break;
        }
        for(int i=1; i<arrayB.length; i++) {
            B = gcd(arrayB[i], B);
            if(B == 1) 
                break;
        }
        
        if(div(arrayA, B)) {
            answer = Math.max(answer, B);
        }
        if(div(arrayB, A)) {
            answer = Math.max(answer, A);
        }
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        if(a%b == 0) return b;
        else return gcd(b, a%b);
    }
    
    public boolean div(int[] array, int num) {
        for(int arr : array) {
            if(arr%num == 0) {
                return false;
            }
        }
        return true;
    }
}