import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int sum = A+B;
            sb.append("Case #" + t + ": " + sum).append("\n");
        }

        System.out.println(sb);

    }
}