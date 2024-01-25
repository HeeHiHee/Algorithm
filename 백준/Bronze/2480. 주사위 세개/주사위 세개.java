import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ans = 0;
        int one = 0;
        int[] dice = new int[7];
        for(int i=0; i<3; i++){
            dice[sc.nextInt()]++;
        }
        for(int i=0; i<7; i++){
            if(dice[i]==0) continue;

            if(dice[i]==3){
                ans = 10000 + i*1000;
            }else if(dice[i]==2){
                ans = 1000 + i*100;
            }else{
                one++;
                if(one==3){
                    ans = i*100;
                }
            }
        }

        System.out.println(ans);

    }
}