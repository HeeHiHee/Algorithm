import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N, v, arr[], ans=0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); arr = new int[N];
        for(int i=0; i<N; i++){arr[i]=sc.nextInt();}
        v = sc.nextInt();
        for(int i : arr){if(i==v)ans++;}
        System.out.println(ans);
    }
}