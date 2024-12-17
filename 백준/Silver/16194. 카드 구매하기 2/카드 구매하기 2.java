import java.util.Scanner;

public class Main {
    static int N, cost[], res[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt()+1; cost = new int[N]; res = new int[N];
        for(int i=1; i<N; i++){
            cost[i] = sc.nextInt();
        }
        for(int i=1; i<N; i++){
            res[i] = cost[i];
            for(int j=i-1; j>0; j--){
                res[i] = Math.min(res[i], res[j]+cost[i-j]);
            }
        }
        System.out.println(res[N-1]);
    }
}