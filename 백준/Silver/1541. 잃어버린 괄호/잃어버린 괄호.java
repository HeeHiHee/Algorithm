import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // 1. "-"로 문자열을 분리하여 배열에 저장한다
        String[] nums = str.split("-");
        int ans = 0;
        // 2. 배열마다 식을 계산하여 ans에서 빼준다.(첫 번째 값은 더함)
        for(int i=0; i<nums.length; i++){
            // 3. 각 배열마다 "+"로 문자열을 분리하여 계산한다.
            // "+"는 정규식에 사용되는 특수문자여서 이스케이프(\\)처리가 필요하다.
            String[] splitP = nums[i].split("\\+");
            int tmp = 0;
            // 4. "+"로 분리된 문자열의 수를 구하여 tmp에 더해준다.
            for(int j=0; j<splitP.length; j++){
                String num = splitP[j];
                for(int k=0; k< num.length(); k++){
                    tmp += (num.charAt(k)-'0')*Math.pow(10,splitP[j].length()-(k+1));
                }
            }
            if(i==0) ans += tmp;
            else ans -= tmp;
        }
        System.out.println(ans);
    }
}