import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] nums = str.split("-");
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            String[] splitP = nums[i].split("\\+");
            int tmp = 0;
            for(int j=0; j<splitP.length; j++){
                tmp += Integer.parseInt(splitP[j]);
            }
            if(i==0) ans += tmp;
            else ans -= tmp;
        }
        System.out.println(ans);
    }
}