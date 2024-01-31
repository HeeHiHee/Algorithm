import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        String B = sc.next();

        int num1 = A * Integer.parseInt(String.valueOf(B.charAt(2)));
        int num2 = A * Integer.parseInt(String.valueOf(B.charAt(1)));
        int num3 = A * Integer.parseInt(String.valueOf(B.charAt(0)));
        int num4 = A * Integer.parseInt(B);

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
    }
}