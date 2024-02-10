import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            if(A==0 && B==0) {
                System.out.println(sb);
                break;
            }else {
                sb.append(A+B).append("\n");
            }
        }
    }
}