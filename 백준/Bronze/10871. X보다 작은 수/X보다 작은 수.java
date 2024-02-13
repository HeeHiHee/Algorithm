import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<N; i++){
            if(arr[i]<X) {
                sb.append(arr[i]).append(" ");
            }
        }

        System.out.println(sb);

    }
}