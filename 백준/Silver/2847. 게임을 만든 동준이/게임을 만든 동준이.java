import java.util.Scanner;

public class Main {
    static int N, num[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        num = new int[N];
        for(int i=0; i<N; i++){num[i] = sc.nextInt();}
        int ans = 0; // 감소횟수
        for(int i=N-2; i>=0; i--){
            if(num[i]>=num[i+1]){
                ans += num[i]-(num[i+1]-1);
                num[i]=num[i+1]-1;
            }
        }
        System.out.println(ans);
    }
}