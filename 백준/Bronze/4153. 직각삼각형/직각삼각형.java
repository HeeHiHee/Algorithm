import java.util.Scanner;

public class Main {
    static int[] num = new int[3];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int max = 0;
            int idx = -1; // 제일 큰 수의 인덱스
            for(int i=0; i<3; i++){
                num[i] = sc.nextInt();
                if(num[i]>max){max=num[i]; idx=i;}
            }
            if(num[0]==0)break;
            int line1 = max*max;
            int line2 = 0;
            for(int i=0; i<3; i++){
                if(i!=idx) line2 += num[i]*num[i];
            }
            sb.append((line1==line2)?"right":"wrong").append("\n");
        }
        System.out.println(sb);
    }
}