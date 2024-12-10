import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            String s = sc.next();
            sb.append(s.toLowerCase()).append("\n");
        }
        System.out.println(sb);
    }
}
