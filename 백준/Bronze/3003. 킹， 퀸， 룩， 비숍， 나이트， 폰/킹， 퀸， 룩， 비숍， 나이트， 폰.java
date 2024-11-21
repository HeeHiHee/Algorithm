import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 체스 말의 기본 개수
        int[] defaultPieces = {1, 1, 2, 2, 2, 8};

        // 입력받은 체스 말의 개수
        int[] currentPieces = new int[6];
        for (int i = 0; i < 6; i++) {
            currentPieces[i] = sc.nextInt();
        }

        // 각 말의 부족하거나 초과된 개수를 계산
        for (int i = 0; i < 6; i++) {
            System.out.print((defaultPieces[i] - currentPieces[i]) + " ");
        }
    }
}