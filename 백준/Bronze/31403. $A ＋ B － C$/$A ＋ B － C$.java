import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A=sc.nextInt(), B=sc.nextInt(), C=sc.nextInt();
        System.out.println(A+B-C);
        String D = Integer.toString(A) + Integer.toString(B);
        int ans = Integer.parseInt(D) - C;
        System.out.println(ans);
    }
}