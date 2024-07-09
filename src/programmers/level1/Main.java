package programmers.level1;

import java.util.*;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0; i<=N; i++) {
            String command = sc.nextLine();
            if(command.contains("u")) {
                String[] pushNum = command.split(" ");
                Push(Integer.parseInt(pushNum[1]));
            }
            else if(command.equals("size")) {
                System.out.println(stack.size());
            } else {
                if(command.equals("empty")) {
                    if(stack.isEmpty()) System.out.println(-Peek());
                    else System.out.println("0");
                }
                if(command.equals("top")) {
                    System.out.println(Peek());
                }
                else {
                    System.out.println(stack.peek());
                    stack.pop();
                }
            }
        }
    }
    private static void Push(int pushNum) {
        stack.push(pushNum);
    }

    private static int Peek() {
        return stack.peek();
    }
}

