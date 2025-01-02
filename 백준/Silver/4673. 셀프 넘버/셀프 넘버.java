public class Main {
    static boolean[] arr = new boolean[10001];

    static void pro() {
        for(int i=1; i<=10000; i++) {
            int result = calc(i);
            if(result <= 10000) {
                arr[result] = true;
            }
        }

        for(int i=1; i<=10000; i++) {
            if(!arr[i]) {
                System.out.println(i);
            }
        }
    }

    static int calc(int n) {
        int sum = n;
        while(n > 0) {
            sum = sum + (n % 10);
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        pro();
    }
}