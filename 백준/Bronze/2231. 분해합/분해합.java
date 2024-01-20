import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;

        for(int i=0; i<N; i++){
            int num = i;
            int sum = num;

            while (num != 0) {
                sum += num % 10; // 각 자릿수를 더해
                num /= 10;
            }

            if(sum==N){
                ans = i;
                break;
            }

        }

        System.out.println(ans);

    }
}