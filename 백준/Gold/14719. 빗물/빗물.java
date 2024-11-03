import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();

        int[] arr = new int[W];
        for(int i=0; i<W; i++) arr[i] = sc.nextInt();

        int sum = 0;
        for(int i=0; i<W; i++){
            int left = 0;
            int right = 0;

            // 왼쪽으로
            // j는 i-1이 아닌 i부터 시작(첫 블럭 고려)
            for(int j=i; j>=0; j--){
                if(left == H) break;
                if(arr[j] > arr[i] && arr[j] > left) left = arr[j];
            }

            // 오른쪽으로
            // j는 i+1이 아닌 i부터 시작(끝 블럭 고려)
            for(int j=i; j<W; j++){
                if(right == H) break;
                if(arr[j] > arr[i] && arr[j] > right) right = arr[j];
            }

            if(left == 0 || right == 0) continue;
            sum += (left <= right) ? (left-arr[i]) : (right-arr[i]);

        }
        System.out.println(sum);
    }
}