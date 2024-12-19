import java.util.*;
public class Main {

    static int N;
    static HashSet<String> set = new HashSet<>();
    static String[] arr;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<N; i++) {
            set.add(sc.nextLine());
        }
    }

    static void pro() {
        arr = new String[set.size()];
        arr = set.toArray(new String[0]);
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() < o2.length()) {
                    return -1;
                } else if(o1.length() == o2.length()) {
                    for(int i=0; i<o1.length(); i++) {
                        if(o1.charAt(i) == o2.charAt(i)) continue;
                        else return o1.charAt(i) - o2.charAt(i);
                    }
                } else return 1;
                return 0;
            }
        });
        
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}