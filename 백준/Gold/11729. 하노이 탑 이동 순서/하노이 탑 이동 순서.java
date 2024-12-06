import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sb.append((int)Math.pow(2,N)-1).append("\n");
        hanoi(N,1,2,3);
        System.out.println(sb);
    }

    public static void hanoi(int N, int A, int B, int C){
        if(N==1){
            sb.append(A+" "+C+"\n");
            return;
        }
        hanoi(N-1, A, C, B);
        sb.append(A+" "+C+"\n");
        hanoi(N-1, B, A, C);
    }
}