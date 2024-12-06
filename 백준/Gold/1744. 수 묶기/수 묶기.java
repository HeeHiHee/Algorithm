import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, nums[], ma=0, ze=0, pl=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
            if(nums[i]<0) ma++;
            else if(nums[i]==0) ze++;
            else pl++;
        }
        Arrays.sort(nums); // 오름차순 정렬
        int ans = 0;
        int len = ma+ze;
        int i=0;
        while(i<N){
            // 음수
            if(i==len-1){ans+=nums[i]; i++; continue;}
            if(i<len){
                ans += nums[i]*nums[i+1];
                i+=2;
                continue;
            }
            // 양수
            if(i==len && pl%2==1){ans+=nums[i]; i++; continue;}
            if(i>=len){
                ans += Math.max(nums[i]*nums[i+1], nums[i]+nums[i+1]);
                i+=2;
            }
        }
        System.out.println(ans);
    }
}