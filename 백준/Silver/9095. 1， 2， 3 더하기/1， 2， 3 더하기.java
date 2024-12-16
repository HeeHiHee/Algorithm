import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] D = new int[12];
        D[1]=1; D[2]=2; D[3]=4;
        for(int i=4; i<12; i++){
            D[i] = (D[i-1] + D[i-2] + D[i-3]);
        }
        while (T-->0){
            int N = sc.nextInt();
            sb.append(D[N]).append("\n");
        }
        System.out.println(sb);
    }
}