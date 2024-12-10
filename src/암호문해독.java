import java.io.*;
import java.util.*;

class 암호문해독 {

    static List<String> rules = new ArrayList<>();
    static StringBuilder inputStr = new StringBuilder();

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inputStr.append(br.readLine());

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            rules.add(br.readLine());
        }
    }

    public static void solution() {
        // 문자 매칭 정보 저장하는 Map
        Map<Character, Character> keyMap = new HashMap<>();

        // 평문 저장할 result
        StringBuilder result = new StringBuilder();

        for(String rule : rules) {
            char from = rule.charAt(0);
            char to = rule.charAt(2);
            keyMap.put(from, to);
        }

        for(int i=0; i<inputStr.length(); i++) {
            char c = inputStr.charAt(i);
            Set<Character> visited = new HashSet<>();

            while(keyMap.containsKey(c)) {
                if(visited.contains(c)) {
                    // 변환 과정 반복 시 ?로 대체
                    c = '?';
                    break;
                }
                visited.add(c);
                c = keyMap.get(c);
            }

            result.append(c);

        }

        System.out.println(result.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }
}