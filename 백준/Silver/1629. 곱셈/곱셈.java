import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        long res = cal(A, B, C);
        System.out.println(res);
    }

    public static long cal(long A, long B, long C){
        if(B==1) return A%C;
        long val = cal(A, B/2, C);
        val = val * val % C;
        if(B%2==0) return val;
        return val * A % C;
    }
}
