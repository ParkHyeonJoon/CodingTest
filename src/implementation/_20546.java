package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20546 {
    static class stock {
        int money = 0; // 초기 투자금
        int cnt = 0; // 주식 갯수

        public stock(int money, int cnt) {
            this.money = money;
            this.cnt = cnt;
        }

        public void buy_stock(int cnt, int todaycost) {
            if(this.money < todaycost * cnt) return;
            money = money - todaycost * cnt;
            this.cnt = this.cnt + cnt;
        }
        
        public int sell(int todaycost) {
            this.money = this.money + todaycost * cnt;
            this.cnt = 0;
            return todaycost;
        }
    }
    static int n;
    static int[] price = new int[14];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int bnp, timing;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<14; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        bnp = BNP();
        timing = Timing();

        if(bnp < timing)
            System.out.println("TIMING");
        else if(bnp > timing)
            System.out.println("BNP");
        else
            System.out.println("SAMESAME");
    }
    public static int BNP() {
        stock s = new stock(n, 0);

        for(int i=0; i<14; i++) {
            if(price[i] <= s.money) {
                s.buy_stock(s.money/price[i], price[i]);
            }
        }
        return (s.cnt*price[13]) + s.money; // 주식개수 x 마지막 날 주가 + 나머지 현금
    }

    public static int Timing() {
        stock s = new stock(n, 0);

        for(int i=3; i<14; i++) {
            if(price[i-1] < price[i-2] && price[i-2] < price[i-3]) {
                s.buy_stock(s.money/price[i], price[i]);
            } else if(price[i-1] > price[i-2] && price[i-2] > price[i-3]) {
                s.sell(price[i]);
            }
        }
        return (s.cnt*price[13])+s.money;
    }
}
