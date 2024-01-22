import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            int ans = 1;

            for(int i=0; i<N; i++){
                ans *= (M-i);
                ans /= (i+1);
            }

            System.out.println(ans);




        }

    }

}