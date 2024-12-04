import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Integer N, A[], B[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new Integer[N]; B = new Integer[N];
        for(int i=0; i<N; i++){A[i] = sc.nextInt();}
        for(int i=0; i<N; i++){B[i] = sc.nextInt();}
        Arrays.sort(A);
        Arrays.sort(B,(a,b)->b-a);
        int ans = 0;
        for(int i=0; i<N; i++){
            ans += A[i]*B[i];
        }
        System.out.println(ans);
    }
}