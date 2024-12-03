import java.util.Scanner;

public class Main {
    static int N, K, coin[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 동전 개수
        K = sc.nextInt(); // 만들 금액
        coin = new int[N];
        for(int i=N-1; i>=0; i--){coin[i] = sc.nextInt();}
        int cnt = 0; // 필요한 동전 개수
        for(int i=0; i<N; i++){
            if(K>=coin[i]){
                cnt += K/coin[i];
                K = K%coin[i];
            }
        }
        System.out.println(cnt);
    }
}